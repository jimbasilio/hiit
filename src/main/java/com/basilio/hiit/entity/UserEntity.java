package com.basilio.hiit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.basilio.hiit.entity.ProgramEntity;
import java.util.Set;
import javax.persistence.OneToMany;

@Table(name = "User")
@Entity
public class UserEntity {

    @Id
    private String username;
    @OneToMany(mappedBy = "userEntity")
    private Set<ProgramEntity> programEntity;
    /**
     * @return the id
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(5, 7).append(username).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        UserEntity rhs = (UserEntity) obj;
        return new EqualsBuilder().append(username, rhs.getUsername())
                .isEquals();
    }

    public Set<ProgramEntity> getProgramEntity() {
        return programEntity;
    }

    public void setProgramEntity(Set<ProgramEntity> param) {
        this.programEntity = param;
    }

}
