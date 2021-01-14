package com.AntoineTrem.NurseryManager.Metier.DTO;

import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallMealDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallNapDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallObservationDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallTimesheetDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class BabyDTO {

    private int id;

    @NotBlank
    @Size(max = 50)
    private String name;

    private Collection<SmallMealDTO> meals;

    private Collection<SmallNapDTO> naps;

    private Collection<SmallObservationDTO> observations;

    private Collection<SmallTimesheetDTO> timesheets;

}
