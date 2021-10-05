package pl.coderslab.DrinkApp.entity;

import javax.persistence.*;

@Entity
@Table(name="drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String ingredients;
    private int preparationTime;
    private String priceLevel;

    public Drink() {
    }

    public Drink(long id, String name, String ingredients, int preparationTime, String priceLevel) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.priceLevel = priceLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", preparationTime=" + preparationTime +
                ", priceLevel='" + priceLevel + '\'' +
                '}';
    }
}
