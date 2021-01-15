package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallNapDTO {

    private int id;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date napTimeBegin;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date napTimeEnd;
    private  String napObs;
    private int babyId;
}
