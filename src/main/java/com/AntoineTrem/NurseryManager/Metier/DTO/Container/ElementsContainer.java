package com.AntoineTrem.NurseryManager.Metier.DTO.Container;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ElementsContainer<DTO> {

    private final List<DTO> list;
    private final int count;
}
