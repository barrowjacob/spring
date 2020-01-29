package com.codeup.springblog.Models;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name="sandwichDetails")
public class SandwichDetails {
    @OneToOne
    private Sandwich sandwich;

    public Sandwich getSandwich() {
        return sandwich;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, columnDefinition = "INT(11) UNSIGNED")
    private Long id;
    @Column(nullable=false, columnDefinition = "TEXT")
    private String historyOfSandwich;
    @Column(nullable=false, columnDefinition = "TEXT")
    private String ingredients;
    @Column(nullable=false, columnDefinition = "TINYINT(1)")
    private boolean isDelicious;

    public SandwichDetails() {
    }
    public SandwichDetails(String historyOfSandwich,
                           String ingredients,
                           boolean isDelicious) {
        this.historyOfSandwich = historyOfSandwich;
        this.ingredients = ingredients;
        this.isDelicious = isDelicious;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistoryOfSandwich() {
        return historyOfSandwich;
    }

    public void setHistoryOfSandwich(String historyOfSandwich) {
        this.historyOfSandwich = historyOfSandwich;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isDelicious() {
        return isDelicious;
    }

    public void setDelicious(boolean delicious) {
        isDelicious = delicious;
    }
}
