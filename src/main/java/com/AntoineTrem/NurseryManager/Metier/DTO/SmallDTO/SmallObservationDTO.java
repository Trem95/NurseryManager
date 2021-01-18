package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.exception.DataException;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallObservationDTO {

    private int id;
    private String obsAuthor;
    private String observation;
    private int babyId;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date observationDate;
    @JsonFormat( pattern = "HH:mm")
    private Date observationTime;
}
