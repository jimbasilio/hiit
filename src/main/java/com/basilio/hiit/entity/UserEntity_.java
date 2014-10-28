package com.basilio.hiit.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-13T22:36:17.918-0500")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ {
	public static volatile SingularAttribute<UserEntity, String> username;
	public static volatile SetAttribute<UserEntity, ProgramEntity> programEntity;
}
