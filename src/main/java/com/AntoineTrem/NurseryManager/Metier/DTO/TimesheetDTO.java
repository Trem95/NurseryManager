package com.AntoineTrem.NurseryManager.Metier.DTO;

import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallBabyDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@ToString
public class TimesheetDTO {

    private int id;

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date timesheetDate;

    @NotBlank
    @JsonFormat( pattern = "HH:mm")
    private Date arrivalTime;

    @NotBlank
    @JsonFormat( pattern = "HH:mm")
    private Date leaveTime;

    @NotBlank
    private SmallBabyDTO baby;
}
