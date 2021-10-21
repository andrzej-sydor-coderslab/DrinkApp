package pl.coderslab.DrinkApp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "softs")
public class SoftDrink {

    public SoftDrink(long id, String name, String ingredients, String description, String preparationTime, String priceLevel, Admin admin) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.preparationTime = preparationTime;
        this.priceLevel = priceLevel;
        this.admin = admin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String ingredients;
    private String description;
    private String preparationTime;
    private String priceLevel;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public SoftDrink() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }
}
