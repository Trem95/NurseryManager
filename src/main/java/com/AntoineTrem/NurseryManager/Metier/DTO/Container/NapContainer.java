package com.AntoineTrem.NurseryManager.Metier.DTO.Container;

import com.AntoineTrem.NurseryManager.Metier.DTO.NapDTO;

import java.util.List;

public class NapContainer extends ElementsContainer<NapDTO>{

    public NapContainer(List<NapDTO> list, int count) {
        super(list, count);
    }
}
