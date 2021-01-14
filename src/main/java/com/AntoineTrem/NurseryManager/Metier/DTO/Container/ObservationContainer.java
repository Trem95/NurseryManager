package com.AntoineTrem.NurseryManager.Metier.DTO.Container;

import com.AntoineTrem.NurseryManager.Metier.DTO.ObservationDTO;

import java.util.List;

public class ObservationContainer extends ElementsContainer<ObservationDTO>{

    public ObservationContainer(List<ObservationDTO> list, int count) {
        super(list, count);
    }
}
