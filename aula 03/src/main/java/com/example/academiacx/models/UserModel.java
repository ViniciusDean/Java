package com.example.academiacx.models;

import com.example.academiacx.models.dto.UserDto;
import com.example.academiacx.models.security.RoleModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String username;

    private String email;

    private String password;

    @ManyToMany
    private List<RoleModel> roles;

    @ManyToMany
    private List<MovieModel> favoritesMovies;


    public UserModel() {
    }

    public UserModel(UserDto userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.username = userDto.getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    public List<MovieModel> getFavoritesMovies() {
        return favoritesMovies;
    }

    public void setFavoritesMovies(List<MovieModel> favoritesMovies) {
        this.favoritesMovies = favoritesMovies;
    }
}
