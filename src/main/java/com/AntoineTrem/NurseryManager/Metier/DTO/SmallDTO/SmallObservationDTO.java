package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.exception.DataException;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallObservationDTO {

    private int id;
    private String obsAuthor;
    private String observation;
    private int babyId;
    private Date observationDate;
}
