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
public class ObservationDTO {

    private int id;

    @NotBlank
    @Size( max = 20)
    private String obsAuthor;

    private String observation;

    @NotBlank
    private SmallBabyDTO baby;

    @NotBlank
    private Date observationDate;
}
