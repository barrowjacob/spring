package com.codeup.springblog.Models;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private int id;
    @Column(nullable = false, unique = true, columnDefinition = "INT(3) UNSIGNED")
    private int age;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length=2, columnDefinition = "VARCHAR(2) default 'XX'")
    private char resideState;

    public Dog() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getResideState() {
        return resideState;
    }

    public void setResideState(char resideState) {
        this.resideState = resideState;
    }
}
