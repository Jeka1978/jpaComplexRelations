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
public class Schema {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "database_instance_id")
    private DatabaseInstance databaseInstance;


    @Singular("index")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schema",cascade = CascadeType.ALL)
    private Set<Indeks> indices = new java.util.LinkedHashSet<>();

    @Singular
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schema",cascade = CascadeType.ALL)
    private Set<Tablica> tables = new java.util.LinkedHashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Schema schema = (Schema) o;
        return id != null && Objects.equals(id, schema.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}