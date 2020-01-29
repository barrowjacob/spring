package com.codeup.springblog.Models;


import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name="sandiwches")
public class Sandwich {

    @OneToOne(mappedBy="sandwich")
    private SandwichDetails sandwichDetails;

    public SandwichDetails getSandwichDetails() {
        return sandwichDetails;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, columnDefinition = "INT(11) UNSIGNED")
    private Long id;
    @Column(nullable=false, columnDefinition = "VARCHAR(100)")
    private String sandwichName;
    @Column(nullable=false, columnDefinition = "VARCHAR(200)")
    private String whoOwnsTheSandwich;

    public Sandwich() {
    }
    public Sandwich(String sandwichName, String whoOwnsTheSandwich) {
        this.sandwichName = sandwichName;
        this.whoOwnsTheSandwich = whoOwnsTheSandwich;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public String getWhoOwnsTheSandwich() {
        return whoOwnsTheSandwich;
    }

    public void setWhoOwnsTheSandwich(String whoOwnsTheSandwich) {
        this.whoOwnsTheSandwich = whoOwnsTheSandwich;
    }
}
