package com.accesadades.botiga.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Marca aquesta classe com una entitat JPA
@Table(name = "categoria") // Defineix la taula 'categoria' a la base de dades
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generacio automatica de l'ID
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) // Relacio One-to-Many amb Subcategoria
    private Set<Subcategoria> subcategories;
}
