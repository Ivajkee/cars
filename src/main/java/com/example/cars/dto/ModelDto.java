package com.example.cars.dto;

import com.example.cars.enums.Color;
import com.example.cars.model.Car;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelDto implements Serializable {
    @JsonProperty("car")
    private Car car;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("model")
    private String model;
    @JsonProperty("year")
    private String year;
    @JsonProperty("color")
    private Color color;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelDto modelDto = (ModelDto) o;
        return Objects.equals(car, modelDto.car) &&
                Objects.equals(id, modelDto.id) &&
                Objects.equals(model, modelDto.model) &&
                Objects.equals(year, modelDto.year) &&
                color == modelDto.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, id, model, year, color);
    }
}
