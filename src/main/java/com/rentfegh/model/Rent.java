package com.rentfegh.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@IdClass(RentPK.class)
public class Rent {
    private String email;
    private int id;
    private Date initDate;
    private Date finDate;

    public Rent(String email, int id, Date initDate, Date finDate) {
        this.email = email;
        this.id = id;
        this.initDate = initDate;
        this.finDate = finDate;
    }

    @Id
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "initDate", nullable = false)
    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    @Basic
    @Column(name = "finDate", nullable = false)
    public Date getFinDate() {
        return finDate;
    }

    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        if (id != rent.id) return false;
        if (email != null ? !email.equals(rent.email) : rent.email != null) return false;
        if (initDate != null ? !initDate.equals(rent.initDate) : rent.initDate != null) return false;
        if (finDate != null ? !finDate.equals(rent.finDate) : rent.finDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (initDate != null ? initDate.hashCode() : 0);
        result = 31 * result + (finDate != null ? finDate.hashCode() : 0);
        return result;
    }
}

