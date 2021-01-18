package com.AntoineTrem.NurseryManager.DAL.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Timesheet {
// SI ENFANT RESTE PLUS DE 5H = JOURNEE COMPLETE
// SI DOUBLE REPAS = JOURNEE COMPLETE
// ENUM = 1 (demi jour) 2(jour comp) 3(malade) 4(congé)
    @Id
    @Column(name ="timesheet_id", nullable = false)
    private int id;

    @Column(name = "timesheet_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date timesheetDate;

    @Column( name = "arrival_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;

    @Column( name ="leave_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date leaveTime;

    @ManyToOne
    @JoinColumn( name = "baby_id", nullable = false)
    private Baby baby;


}
