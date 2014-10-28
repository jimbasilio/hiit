package com.basilio.hiit.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-13T22:32:57.524-0500")
@StaticMetamodel(IterationEntity.class)
public class IterationEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<IterationEntity, Integer> cycles;
	public static volatile SingularAttribute<IterationEntity, ProgramEntity> programEntity;
	public static volatile SetAttribute<IterationEntity, StepEntity> stepEntity;
}
