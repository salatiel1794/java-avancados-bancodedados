
package com.salatil1794.shop.entities;

import java.util.UUID;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
    
    private String nome;
    private float price;
    private long stock;
    private boolean status;
    private ProductGroup productGroup;
    
    public Product() {
        
    }
    
    public Product(String name, float price, long stock) {
        this.nome =  name;
        this.price = price;
        this.stock = stock;
        this.setId(UUID.randomUUID());
    }
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public long getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(long stock) {
        this.stock = stock;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the productGroup
     */
    public ProductGroup getProductGroup() {
        return productGroup;
    }

    /**
     * @param productGroup the productGroup to set
     */
    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }
    
    
}
