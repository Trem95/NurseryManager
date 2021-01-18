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

public class Meal {

    @Id
    @Column(name = "meal_id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn( name="baby_id", nullable = false)
    private Baby baby;

    @Column(name = "type_meal", nullable = false)
    @Size(max = 50)
    private String typeMeal;

    @Column(name = "meal_obs")
    private String mealObs;

    @Column(name = "meal_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date mealDate;

    @Column(name = "meal_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date mealTime;

}
