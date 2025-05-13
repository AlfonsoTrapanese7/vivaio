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
@Table(name = "accessory")
public class Accessory {

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
    private String size;
    private String brand;
    private String material;
    private int isActive; // 0 = false; 1 = true
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

}
