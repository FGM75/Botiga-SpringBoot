package com.accesadades.botiga.Model;

import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Marca aquesta classe com una entitat JPA
@Table(name = "subcategorias") // Defineix la taula 'subcategorias' a la base de dades
public class Subcategoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generacio automatica de l'ID
    private long id;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoria_id") // Relacio Many-to-One amb Categoria
    private Categoria categoria;

    @OneToMany(mappedBy = "subcategory") // Relacio One-to-Many amb Product
    private Set<Product> products;
}
