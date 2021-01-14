package com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO;

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
    private Date mealDate;

}
