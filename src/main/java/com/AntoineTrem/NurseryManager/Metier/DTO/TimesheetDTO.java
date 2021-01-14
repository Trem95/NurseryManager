package com.AntoineTrem.NurseryManager.Metier.DTO;

import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallBabyDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class TimesheetDTO {

    private int id;

    @NotBlank
    @Past
    private Date arrivalTime;

    @NotBlank
    @Future
    private Date leaveTime;

    @NotBlank
    private SmallBabyDTO baby;
}
