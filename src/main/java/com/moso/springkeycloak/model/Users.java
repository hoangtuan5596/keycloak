package com.moso.springkeycloak.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
}
