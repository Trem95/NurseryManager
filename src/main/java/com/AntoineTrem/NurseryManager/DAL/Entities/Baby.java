package com.AntoineTrem.NurseryManager.DAL.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class Baby {

    @Id
    @Column( name= "baby_id", nullable = false)
    private int id;

    @Column( name="baby_name", nullable = false )
    @Size( max = 50 )
    private String name;

    @OneToMany(mappedBy = "baby")
    private Collection<Meal> meals;

    @OneToMany(mappedBy = "baby")
    private Collection<Nap> naps;

    @OneToMany(mappedBy = "baby")
    private Collection<Observation> observations;

    @OneToMany(mappedBy ="baby")
    private Collection<Timesheet> timesheets;


}
