package com.AntoineTrem.NurseryManager.Metier.DTO.Container;

import com.AntoineTrem.NurseryManager.Metier.DTO.PaednurseDTO;

import java.util.List;

public class PaednurseContainer extends ElementsContainer<PaednurseDTO>{

    public PaednurseContainer(List<PaednurseDTO> list, int count) {
        super(list, count);
    }
}
