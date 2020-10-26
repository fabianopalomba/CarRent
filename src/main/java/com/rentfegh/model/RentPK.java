package com.rentfegh.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

public class RentPK implements Serializable {
    private String email;
    private int id;
    private Date initDate;

    @Column(name = "email", nullable = false, length = 45)
    @Id
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "initDate", nullable = false)
    @Id
    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentPK rentPK = (RentPK) o;

        if (id != rentPK.id) return false;
        if (email != null ? !email.equals(rentPK.email) : rentPK.email != null) return false;
        if (initDate != null ? !initDate.equals(rentPK.initDate) : rentPK.initDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (initDate != null ? initDate.hashCode() : 0);
        return result;
    }
}
