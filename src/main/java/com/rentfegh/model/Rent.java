package com.rentfegh.model;

import com.rentfegh.dao.RentDAO;
import com.rentfegh.dao.RentDAOInterface;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rent", schema = "feghrent")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.user",
                joinColumns = @JoinColumn(name = "email", referencedColumnName = "email")),
        @AssociationOverride(name = "primaryKey.car",
                joinColumns = @JoinColumn(name= "id", referencedColumnName = "carsid"))})

public class Rent implements Serializable{

    private RentPK primaryKey = new RentPK();
    private Date finDate;

    public Rent() {
    }

    public Rent(RentPK primaryKey, Date finDate) {
        this.primaryKey = primaryKey;
        this.finDate = finDate;
    }

    @Column(name = "finDate", nullable = false)
    public Date getFinDate() {
        return finDate;
    }
    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    @EmbeddedId
    public RentPK getPrimaryKey(){
        return primaryKey;
    }
    public void setPrimaryKey(RentPK primaryKey) {
        this.primaryKey = primaryKey;
    }
    @Transient
    public User getUser(){
        return getPrimaryKey().getUser();
    }
    public void setUser(User user){
        getPrimaryKey().setUser(user);
    }
    @Transient
    public Car getCar(){
        return getPrimaryKey().getCar();
    }
    public void setCar(Car car){
        getPrimaryKey().setCar(car);
    }
    @Transient
    public Date getInitDate(){
        return getPrimaryKey().getInitDate();
    }
    public void setInitDate(Date d){
        getPrimaryKey().setInitDate(d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return primaryKey.equals(rent.primaryKey) &&
                finDate.equals(rent.finDate);
    }

    @Override
    public String toString() {
        return "Rent{" +
                primaryKey.toString() +
                ", finDate=" + finDate +
                '}';
    }
}

