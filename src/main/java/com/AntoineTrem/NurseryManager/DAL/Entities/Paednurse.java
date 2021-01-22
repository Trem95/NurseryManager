package com.AntoineTrem.NurseryManager.DAL.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Paednurse {

    @Id
    @Column( name = "paednurse_id", nullable = false)
    private int id;

    @Column( name = "name", nullable = false)
    @Size( max = 50)
    private String name;

    @Column( name = "login", nullable = false)
    @Size( max = 50)
    private String login;

    @Column( name ="pwd", nullable = false, columnDefinition = "blob")
    @Size( max = 50)
    private String pwd;

}
