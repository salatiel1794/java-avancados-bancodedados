
package com.salatil1794.shop.repositories;

import com.salatil1794.shop.entities.Product;
import java.util.List;
import java.util.UUID;

public class ProductRepository {
    
    public Product findOne(String id) {
        Product product = null;
        return product;
    }
    
    public List<Product> findByIds(List<String> ids) {
        List<Product> collection = null;
        return collection;        
    }
    
    public List<Product> findByName(String name) {
        List<Product> collection = null;
        return collection; 
    }
    
     public void save (Product product) {
         if (product.getId() == null) {
             product.setId(UUID.randomUUID());
         }
         
         // SAVE Product         
     }
     
     public void delete(Product product) {
         // delete product
     }
     
     public void delete(String id) {
         this.delete(this.findOne(id));
     }
    
}
