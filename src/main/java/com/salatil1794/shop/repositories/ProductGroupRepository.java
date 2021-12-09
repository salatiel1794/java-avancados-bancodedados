
package com.salatil1794.shop.repositories;

import DataBase.MySQLDatabaseConnector;
import com.salatil1794.shop.entities.ProductGroup;
import java.util.UUID;

public class ProductGroupRepository {
    
    public ProductGroup findOne(String id) {
        MySQLDatabaseConnector.getInstance().connect();
        
        ProductGroup productGroup = null;
        
        MySQLDatabaseConnector.getInstance().disconnect();
        return productGroup;
    }
    
    public void save(ProductGroup productGroup) {
        MySQLDatabaseConnector.getInstance().connect();
//        if (productGroup.getId() == null) {
//            productGroup.setId(UUID.randomUUID());
//        }
        //save productGroup
        MySQLDatabaseConnector.getInstance().disconnect();
    }
    
    public void delete(ProductGroup productGroup) {
        MySQLDatabaseConnector.getInstance().connect();
        // delete productGroup
        MySQLDatabaseConnector.getInstance().disconnect();
    }
    
    public void delete(String id) {
        
        this.delete(this.findOne(id));
     
    }
    
}
