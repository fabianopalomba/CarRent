package com.rentfegh.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cars", schema = "feghrent")
public class Car implements Serializable {
    private int carsid;
    private String brand;
    private String model;
    private Set<Rent> rents = new HashSet<Rent>();

    public Car() {
    }

    public Car(int carsid, String brand, String model) {
        this.carsid = carsid;
        this.brand = brand;
        this.model = model;
    }

    @Id
    @GeneratedValue
    @Column(name = "carsid", nullable = false)
    public int getCarsid() {
        return carsid;
    }
    public void setCarsid(int carsid) {
        this.carsid = carsid;
    }

    @Column(name = "brand", nullable = false, length = 45)
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model", nullable = false, length = 45)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @OneToMany (mappedBy = "primaryKey.car", cascade = CascadeType.ALL)
    public Set<Rent> getRents() {
            return rents;
        }
    public void setRents(Set<Rent> rents1){
            this.rents = rents1;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carsid == car.carsid &&
                brand.equals(car.brand) &&
                model.equals(car.model) &&
                Objects.equals(rents, car.rents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsid, brand, model, rents);
    }
}
