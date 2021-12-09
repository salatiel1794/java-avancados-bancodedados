
package com.salatil1794.shop.entities;

import com.salatil1794.shop.repositories.ProductGroupRepository;

public class ProductGroupController {
        
    private ProductGroupRepository repository = new ProductGroupRepository();
    
    public ProductGroup create(ProductGroup productGroup) {
        
        this.repository.save(productGroup);
        
        return productGroup;
        
    }
    
}
