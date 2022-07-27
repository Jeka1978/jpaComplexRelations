package com.epam.jeka.jpacomplexrelations;

import com.epam.jeka.jpacomplexrelations.model.DatabaseInstance;
import com.epam.jeka.jpacomplexrelations.model.Schema;
import com.epam.jeka.jpacomplexrelations.model.Tablica;
import com.epam.jeka.jpacomplexrelations.services.MainService;
import com.epam.jeka.jpacomplexrelations.services.MetaDataProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaComplexRelationsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JpaComplexRelationsApplication.class, args);
        MainService mainService = context.getBean(MainService.class);
        DatabaseInstance databaseInstance = context.getBean(MetaDataProvider.class).get();

        mainService.save(databaseInstance);
        System.out.println();
    }

}
