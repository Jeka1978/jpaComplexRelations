package com.epam.jeka.jpacomplexrelations.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tablica {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "schema_id")
    private Schema schema;


    @Singular
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tablica",cascade = CascadeType.ALL)
    private Set<Indeks> indices = new java.util.LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tablica tablica = (Tablica) o;
        return id != null && Objects.equals(id, tablica.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}