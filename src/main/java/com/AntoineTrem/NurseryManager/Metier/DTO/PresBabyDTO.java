package com.AntoineTrem.NurseryManager.Metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PresBabyDTO {

    private int id;
    private String name;
    private List<Integer> mealsId;
    private List<Integer> napsId;
    private List<Integer> observationsId;
    private List<Integer> timesheetId;

}
