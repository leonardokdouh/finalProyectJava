package model.people;

import model.products.Products;

import java.util.List;
import java.util.Objects;

public class Clients extends People {

    private Integer clientNumber;

    private List<Products> rentalHistory;


    public Clients(int id, String name, String lastName, int age, Integer clientNumber, List<Products> rentalHistory) {
        super(id, name, lastName, age);
        this.clientNumber = clientNumber;
        this.rentalHistory = rentalHistory;
    }

    public Clients() {
    }

    public Integer getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(Integer clientNumber) {
        this.clientNumber = clientNumber;
    }

    public List<Products> getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(List<Products> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Clients clients = (Clients) o;
        return Objects.equals(clientNumber, clients.clientNumber) && Objects.equals(rentalHistory, clients.rentalHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clientNumber, rentalHistory);
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientNumber=" + clientNumber +
                ", rentalHistory=" + rentalHistory +
                '}';
    }
}
