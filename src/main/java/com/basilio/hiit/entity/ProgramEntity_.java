package com.basilio.hiit.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-13T22:36:17.911-0500")
@StaticMetamodel(ProgramEntity.class)
public class ProgramEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<ProgramEntity, Integer> iterations;
	public static volatile SingularAttribute<ProgramEntity, String> name;
	public static volatile SingularAttribute<ProgramEntity, LocalDate> creationDate;
	public static volatile SingularAttribute<ProgramEntity, UserEntity> userEntity;
}
