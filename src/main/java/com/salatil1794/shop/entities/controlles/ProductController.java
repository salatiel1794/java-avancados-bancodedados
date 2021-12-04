
package com.salatil1794.shop.entities.controlles;

import com.salatil1794.shop.entities.Product;
import com.salatil1794.shop.entities.ProductGroup;
import com.salatil1794.shop.repositories.ProductRepository;

public class ProductController {
    private ProductRepository repository = new ProductRepository();
    
    public Product create(Product product) {
        this.repository.save(product);
        
        return product;
    }
            
}
