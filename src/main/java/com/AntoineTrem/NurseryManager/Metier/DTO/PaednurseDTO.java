package com.AntoineTrem.NurseryManager.Metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.SecondaryTable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor
public class PaednurseDTO {

    private int id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String login;

    @NotBlank
    @Size(max =50)
    private String pwd;
}
