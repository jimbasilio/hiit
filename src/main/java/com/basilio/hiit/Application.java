package com.basilio.hiit;

import java.util.StringJoiner;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*-
     * Customize tomcat. 
     * - turns on gzip compression 
     * - turns on compression for json 
     * - turns on mimetype for text/manifest
     * - sets cookies to be only used over https (secure) and httpOnly setting turned on for XSS
     */
    @Override
    public void customize(final ConfigurableEmbeddedServletContainer container) {
        ((TomcatEmbeddedServletContainerFactory) container)
                .addContextCustomizers(new TomcatContextCustomizer() {
                    @Override
                    public void customize(Context context) {
                        // https://www.owasp.org/index.php/HttpOnly
                        //
                        // http://en.wikipedia.org/wiki/HTTP_cookie#Secure_and_HttpOnly
                        // "The HttpOnly attribute directs browsers not to expose cookies through channels other than HTTP (and HTTPS) requests."
                        // "An HttpOnly cookie is not accessible via non-HTTP methods, such as calls via JavaScript (e.g., referencing "document.cookie"),"
                        // "and therefore cannot be stolen easily via cross-site scripting (a pervasive attack technique).[37] Among others, Facebook and"
                        // "Google use the HttpOnly attribute extensively."
                        context.setUseHttpOnly(true);
                        context.addMimeMapping("appcache",
                                "text/cache-manifest");
                    }
                });

        ((TomcatEmbeddedServletContainerFactory) container)
                .addConnectorCustomizers(new TomcatConnectorCustomizer() {
                    @Override
                    public void customize(final Connector connector) {
                        // for more settings for tomcat look at the docs:
                        // http://tomcat.apache.org/tomcat-7.0-doc/config/http.html

                        AbstractHttp11Protocol httpProtocol = (AbstractHttp11Protocol) connector
                                .getProtocolHandler();
                        httpProtocol.setCompression("on");

                        // needs to be set when site sits behind ssl
                        // accelerator. tomcat will return 'true' to .isSecured
                        // requests to it.
                        String mimeTypes = httpProtocol
                                .getCompressableMimeTypes();
                        StringJoiner joiner = new StringJoiner(",");
                        joiner.add(mimeTypes)
                                .add(MediaType.APPLICATION_JSON_VALUE)
                                .add("text/css").add("application/javascript")
                                .add("text/cache-manifest");
                        httpProtocol.setCompressableMimeTypes(joiner.toString());
                    }
                });
    }
}
