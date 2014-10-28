package com.basilio.hiit.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-13T22:30:53.344-0500")
@StaticMetamodel(StepEntity.class)
public class StepEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<StepEntity, Integer> durationInSeconds;
	public static volatile SingularAttribute<StepEntity, Integer> reps;
	public static volatile SingularAttribute<StepEntity, IterationEntity> iterationEntity;
}
