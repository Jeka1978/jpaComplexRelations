package com.epam.jeka.jpacomplexrelations.repo;

import com.epam.jeka.jpacomplexrelations.model.DatabaseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseInstanceRepo  extends JpaRepository<DatabaseInstance,Long> {
}
