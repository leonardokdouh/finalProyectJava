package model.products;

import utils.enums.GamingConsoles;

import java.util.Objects;

public class GamingProducts extends Products implements IProducts {
    private int id;
    private GamingConsoles console;

    public GamingProducts(int id, GamingConsoles console, String name, int price, int days) {
        super(name, price, days);
        this.id = id;
        this.console = console;
    }

    public GamingProducts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GamingConsoles getConsole() {
        return console;
    }

    public void setConsole(GamingConsoles console) {
        this.console = console;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GamingProducts that = (GamingProducts) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return super.toString() + "GamingProducts{" +
                "id=" + id +
                ", console=" + console +
                '}';
    }

    @Override
    public void applyDiscount(Integer percentage) {
        setPrice(this.getPrice() * ((100 - percentage)) / 100);
    }

    @Override
    public void appllyCharge(Integer percentage) {
        setPrice(this.getPrice() * ((100 + percentage) + 20) / 100);

    }

}
