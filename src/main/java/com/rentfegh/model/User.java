package com.rentfegh.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", schema = "feghrent")
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Set<Rent> rents = new HashSet<Rent>();

    public User() {
    }

    @Column(name = "firstName", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone", nullable = false, length=10)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Id
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public User(String firstName, String lastName, String phone, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    @OneToMany(mappedBy = "primaryKey.user", cascade = CascadeType.ALL)
    public Set<Rent> getRents() {
        return rents;
    }
    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(phone, user.phone) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                Objects.equals(rents, user.rents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phone, email, password, rents);
    }
}
