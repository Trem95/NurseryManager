package com.AntoineTrem.NurseryManager.Metier.DTO;

import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallBabyDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date arrivalTime;

    @NotBlank
    @Future
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date leaveTime;

    @NotBlank
    private SmallBabyDTO baby;
}
