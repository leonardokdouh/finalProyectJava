package model.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import utils.enums.Shifts;

import java.util.Objects;

public class Workers extends People {

    @JsonProperty("socialSecurityNumber")
    private Integer socialSecurityNumber;

    @JsonProperty("shift")
    private Shifts shift;

    @JsonProperty("email")
    private String email;


    public Workers(Integer socialSecurityNumber, Integer id, String name, String lastName, int age, String email, Shifts shift) {
        super(id, name, lastName, age);
        this.socialSecurityNumber = socialSecurityNumber;
        this.shift = shift;
        this.email = email;
    }

    public Workers() {

    }

    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Integer socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Shifts getShift() {
        return shift;
    }

    public void setShift(Shifts shift) {
        this.shift = shift;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Workers workers = (Workers) o;
        return Objects.equals(socialSecurityNumber, workers.socialSecurityNumber) && Objects.equals(shift, workers.shift) && Objects.equals(email, workers.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), socialSecurityNumber, shift, email);
    }

    @Override
    public String toString() {
        return super.toString() + "Workers{" +
                "socialSecurityNumber=" + socialSecurityNumber +
                ", shift='" + shift + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
