package com.epam.jeka.jpacomplexrelations.services;

import com.epam.jeka.jpacomplexrelations.model.DatabaseInstance;
import com.epam.jeka.jpacomplexrelations.model.Indeks;
import com.epam.jeka.jpacomplexrelations.model.Schema;
import com.epam.jeka.jpacomplexrelations.model.Tablica;
import org.springframework.stereotype.Service;

@Service
public class MetaDataProvider {


    public DatabaseInstance get() {

        Indeks productFirstIndex = Indeks.builder().name("Product_Id_primary").build();
        Indeks productSecondIndex = Indeks.builder().name("Product_Id_secondary").build();
        Indeks productShopIndex = Indeks.builder().name("shop_index").build();

        Tablica productTable = Tablica.builder().name("Product")
                .index(productFirstIndex)
                .index(productSecondIndex)
                .build();

        Tablica shopTable = Tablica.builder()
                .name("shop")
                .index(productShopIndex)
                .build();

        Schema productSchema = Schema.builder()
                .name("product_schema")
                .index(productFirstIndex)
                .index(productSecondIndex)
                .index(productShopIndex)
                .table(productTable)
                .table(shopTable)
                .build();

        productTable.setSchema(productSchema);
        shopTable.setSchema(productSchema);

        productFirstIndex.setSchema(productSchema);
        productFirstIndex.setTablica(productTable);

        productSecondIndex.setSchema(productSchema);
        productSecondIndex.setTablica(productTable);

        productShopIndex.setSchema(productSchema);
        productShopIndex.setTablica(shopTable);

      return   DatabaseInstance.builder()
                .name("db2_danon")
                .schema(productSchema)
                .build();
    }

}
