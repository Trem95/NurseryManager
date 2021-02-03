package com.AntoineTrem.NurseryManager.Metier.DTO;

import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallBabyDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@ToString
public class ObservationDTO {

    private int id;

    @NotBlank
    @Size( max = 20)
    private String obsAuthor;

    private String observation;

    @NotBlank
    private SmallBabyDTO baby;

    @NotBlank
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date observationDate;

    @NotBlank
    @JsonFormat( pattern = "HH:mm")
    private Date observationTime;
}
