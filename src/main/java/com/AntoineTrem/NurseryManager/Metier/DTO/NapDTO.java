package com.AntoineTrem.NurseryManager.Metier.DTO;

import com.AntoineTrem.NurseryManager.Metier.DTO.SmallDTO.SmallBabyDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class NapDTO {

    private int id;

    @NotBlank
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date napTimeBegin;

    @NotBlank
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private Date napTimeEnd;

    private String napObs;

    @NotBlank
    private SmallBabyDTO baby;
}
