package com.AntoineTrem.NurseryManager.Metier.DTO;

import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallBabyDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor

public class MealDTO {

    private int id;

    @NotBlank
    private SmallBabyDTO baby;

    @NotBlank
    @Size( max = 50)
    private String typeMeal;


    private String mealObs;

    private Date mealDate;

}
