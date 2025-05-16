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
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-Za-zàèìòù ]{1,30}$", message = "Name can contain characters only")
    private String name;
    private double price;
    private String description;
    @Pattern(regexp = "^[A-Za-zàèìòù ]{1,30}$", message = "Color can contain characters only")
    private String color;
    private String photo;
    private int quantity;
    private LocalDate dateOfRestock;
    @Pattern(regexp = "^[A-Za-zàèìòù ]{1,30}$", message = "Origin can contain characters only")
    private String origin;
    @Pattern(regexp = "^[A-Za-zàèìòù ]{1,30}$", message = "Season can contain characters only")
    private String season;
    @Pattern(regexp = "^[A-Za-zàèìòù ]{1,30}$", message = "Watering can contain characters only")
    private String watering;
    private int isActive; // 0 = false; 1 = true
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private Type type;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_location", referencedColumnName = "id")
    private Location location;
    
}
