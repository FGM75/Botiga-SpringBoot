package com.accesadades.botiga.Model;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Marca aquesta classe com una entitat JPA
@Table(name = "products") // Defineix la taula 'products' a la base de dades
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generacio automatica de l'ID
    private long product_id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String company;
    @Column
    private float price;
    @Column
    private long units;
    @Column(name = "creation_at")
    private LocalDateTime creationDate;
    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name="subcategory_id") // Relacio Many-to-One amb Subcategoria
    private Subcategoria subcategory;  
}
