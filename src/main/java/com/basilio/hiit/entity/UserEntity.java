package com.basilio.hiit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "User")
@Entity
public class UserEntity {
    @Id
    private String username;
}
