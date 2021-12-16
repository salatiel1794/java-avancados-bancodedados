
package com.salatil1794.shop.entities;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;

public class ProductGroup {
    
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private boolean status;
    private String id;
    
    public ProductGroup() {
        
    }
    
    public ProductGroup(String name, float price, long stock) {
        this.name =  name;
        this.status = status;
        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return getName();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.setName(nome);
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
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }


    
}
