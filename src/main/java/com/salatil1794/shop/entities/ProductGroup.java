
package com.salatil1794.shop.entities;

import java.util.UUID;

public class ProductGroup extends Entity {
    
    private String nome;
    private boolean status;
    
    public ProductGroup() {
        
    }
    
    public ProductGroup(String name, float price, long stock) {
        this.nome =  name;
        this.status = status;
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
    
}
