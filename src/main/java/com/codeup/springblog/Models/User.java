//package com.codeup.springblog.Models;
//
//import javax.persistence.*;
//import java.util.List;
//
//
//@Entity
//@Table(name="users")
//public class User {
////    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
////    private List<Post> posts;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable=false, columnDefinition = "LONG UNSIGNED")
//    private Long id;
//
//    @Column(nullable=false)
//    private String email;
//
//    @Column(nullable=false)
//    private String username;
//
//    @Column(nullable=false)
//    private String password;
//
//    public User() {
//    }
//    public User(Long id, String email, String username, String password) {
//        this.id = id;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//}
//
