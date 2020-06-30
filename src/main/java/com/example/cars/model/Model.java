package com.example.cars.model;

import com.example.cars.enums.Color;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String year;
    @Enumerated(EnumType.STRING)
    private Color color;
    @ManyToOne()
    @JoinColumn(nullable = false)
    private Car car;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model1 = (Model) o;
        return Objects.equals(car, model1.car) &&
                Objects.equals(id, model1.id) &&
                Objects.equals(model, model1.model) &&
                Objects.equals(year, model1.year) &&
                color == model1.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, id, model, year, color);
    }
}
