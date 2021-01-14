package com.AntoineTrem.NurseryManager.DAL.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Observation {

    @Id
    @Column( name = "observation_id", nullable = false)
    private int id;

    @Column(name = "observation_author", nullable = false)
    @Size( max = 20)
    private String obsAuthor;

    @Column( name="observation")
    private String observation;

    @ManyToOne
    @JoinColumn( name = "baby_id", nullable = false)
    private Baby baby;

    @Column( name = "observation_date", nullable = false)
    private Date observationDate;
}
