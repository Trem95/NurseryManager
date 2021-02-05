package com.AntoineTrem.NurseryManager.DAL.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Nap {

    @Id
    @Column( name ="nap_id", nullable = false)
    private int id;

    @Column( name = "nap_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date napDate;

    @Column( name = "nap_time_begin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date napTimeBegin;

    @Column( name = "nap_time_end")
    @Temporal(TemporalType.TIME)
    private Date napTimeEnd;

    @Column( name ="nap_obs")
    private String napObs;

    @ManyToOne
    @JoinColumn( name = "baby_id", nullable = false)
    private Baby baby;

}
