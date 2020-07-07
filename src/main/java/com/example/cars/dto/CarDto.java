package com.example.cars.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CarDto implements Serializable {
    private Long id;
    private String name;
    Set<ModelDto> models = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ModelDto> getModels() {
        return models;
    }

    public void setModels(Set<ModelDto> models) {
        this.models = models;
    }
}
