package com.example.aves.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "aves")
public class Ave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String especie;
    private String color;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
