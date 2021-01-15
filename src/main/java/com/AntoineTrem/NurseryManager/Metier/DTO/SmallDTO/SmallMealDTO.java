package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallMealDTO {

    private int id;
    private int babyId;
    private String typeMeal;
    private String mealObs;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date mealDate;

}
