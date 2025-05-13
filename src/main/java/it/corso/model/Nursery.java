package it.corso.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "nursery")
public class Nursery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String description;
    private String color;
    private String photo;
    private int quantity;
    private LocalDate dateOfRestock;
    private String origin;
    private String season;
    private String watering;
    private int isActive;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private Type type;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_location", referencedColumnName = "id")
    private Location location;
    
}
