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
public class DatabaseInstance {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Singular
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "databaseInstance",cascade = CascadeType.PERSIST)
    private Set<Schema> schemas = new java.util.LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DatabaseInstance that = (DatabaseInstance) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
