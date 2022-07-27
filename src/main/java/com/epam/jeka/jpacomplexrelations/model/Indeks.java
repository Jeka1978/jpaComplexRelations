package com.epam.jeka.jpacomplexrelations.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Indeks {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "schema_id")
    private Schema schema;

    @ManyToOne
    @JoinColumn(name = "tablica_id")
    private Tablica tablica;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Indeks indeks = (Indeks) o;
        return id != null && Objects.equals(id, indeks.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}