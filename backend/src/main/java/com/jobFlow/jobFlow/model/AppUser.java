package com.jobFlow.jobFlow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table (name = "app_user")
public class AppUser {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(max = 255, message = "La contraseña no debe superar los 255 caracteres.")
    private String password;

    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @Size(max = 150, message = "El nombre de usuario no debe superar los 150 caracteres.")
    private String username;

    @Enumerated (EnumType.STRING)
    @NotNull(message = "El rol es esencial.")  
    private UserRole role;

    public AppUser(Long id, String password, String username, UserRole role) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    
    
}
