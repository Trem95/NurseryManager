package com.AntoineTrem.NurseryManager.Metier.DTO.Container;

import com.AntoineTrem.NurseryManager.Metier.DTO.BabyDTO;
import com.AntoineTrem.NurseryManager.Metier.DTO.PresBabyDTO;

import java.util.List;

public class BabyContainer extends ElementsContainer<PresBabyDTO>{

    public BabyContainer(List<PresBabyDTO> list, int count) {
        super(list, count);
    }
}
