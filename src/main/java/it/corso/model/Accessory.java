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
@Table(name = "accessory")
public class Accessory {

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

    @Pattern(regexp = "^[A-Za-zàèìòù ]{1,50}$", message = "Size can contain characters only")
    private String size;

    @Pattern(regexp = "^[A-Za-zàèìòù ]{1,30}$", message = "Brand can contain characters only")
    private String brand;

    @Pattern(regexp = "^[A-Za-zàèìòù0-9 ]{1,30}$", message = "Material can contain characters only")
    private String material;

    private int isActive; // 0 = false; 1 = true
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

}
