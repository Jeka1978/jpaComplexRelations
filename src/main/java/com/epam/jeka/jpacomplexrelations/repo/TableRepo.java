package com.epam.jeka.jpacomplexrelations.repo;

import com.epam.jeka.jpacomplexrelations.model.Tablica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepo  extends JpaRepository<Tablica,Long> {
}
