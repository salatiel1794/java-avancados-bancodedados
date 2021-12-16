package com.salatil1794.shop.repositories;

import com.salatil1794.shop.confg.ConexaoMySQL;
import com.salatil1794.shop.entities.Product;
import com.salatil1794.shop.entities.ProductGroup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepository {
    private String getbaseSelect() {
        String sql = "SELECT p.*, "
                + "pg.id AS 'product_group.id', "
                + "pg.name AS 'product_group.name', "
                + "pg.status AS 'product_group.status', "
                + "pg.created_at AS 'product_group.created_at', "
                + "pg.updated_at AS 'product_group.updated_at' "
                + "from PRODUCTS P "
                + "JOIN product_groups pg ON pg.id = p.product_group_id";
        
        return sql;
    } 

    public Product findOne(String id) throws Exception {
        Connection connection = ConexaoMySQL.getConexaoMySQL();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(
                this.getbaseSelect() + " "
                + "WHERE p.id = '" + id + "' "
                + "LIMIT 1");

        if (!resultset.next()) {
            return null;
        }

        return this.paraResultSetToProduct(resultset);

    }

    public List<Product> findByIds(List<String> ids) throws Exception {
        List<Product> collection = new ArrayList();
        Connection connection = ConexaoMySQL.getConexaoMySQL();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(
                this.getbaseSelect() + " "
                + "WHERE p.id IN ('" + String.join("','", ids) + "')");
        // IN ('id1','id2'.'id3')
        while (resultset.next()) {
            collection.add(this.paraResultSetToProduct(resultset));

        }
        return collection;
    }
    
    public List<Product> findAll() throws Exception {
        List<Product> collection = new ArrayList();

        Connection connection = ConexaoMySQL.getConexaoMySQL();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(this.getbaseSelect());
        while (resultset.next()) {
            collection.add(this.paraResultSetToProduct(resultset));

        }
        return collection;
    }


    public List<Product> findByName(String name) throws Exception {
        List<Product> collection = new ArrayList();

        Connection connection = ConexaoMySQL.getConexaoMySQL();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(
                this.getbaseSelect() + " "
                + "WHERE p.name LIKE '%" + name + "%'");
        // IN ('id1','id2'.'id3')
        while (resultset.next()) {
            collection.add(this.paraResultSetToProduct(resultset));

        }
        return collection;
    }

    public void save(Product product) throws Exception {
        boolean isInsert = false;

        if (product.getId() == null) {
            product.setId(UUID.randomUUID().toString());
            isInsert = true;
        }

        Connection connection = ConexaoMySQL.getConexaoMySQL();

        String sql;

        if (isInsert) {
            sql = "INSERT INTO products (id, name, price, stock, "
                    + "status, product_group_id)"
                    + "Values ("
                    + "'" + product.getId() + "', "
                    + "'" + product.getName() + "', "
                    + product.getPrice() + ", "
                    + product.getStock() + ", "
                    + product.isStatus() + ", "
                    + "'" + product.getProductGroup().getId() + "' "
                    + ")";
        } else {
            sql = "UPDATE products SET "
                    + "name = '" + product.getName() + "', "
                    + "price = " + product.getPrice() + ", "
                    + "stock = " + product.getStock() + ", "
                    + "status = " + product.isStatus() + ", "
                    + "product_group_id = '" + product.getProductGroup().getId() + "' "
                    + "WHERE id = '" + product.getId() + "' "
                    + "LIMIT 1";
        }
        System.out.println(sql);

        Statement statement = connection.createStatement();
        if (isInsert) {
            statement.execute(sql);

        } else {
            boolean isUpdated = statement.executeUpdate(sql) == 1;
            if (!isUpdated) {
                throw new Exception("Not updated product");

            }
        }

        // SAVE Product         
    }

    public void delete(Product product) throws Exception {
        this.delete(product.getId());
        // delete product
        
    }

    public void delete(String id) throws Exception {
        Connection connection = ConexaoMySQL.getConexaoMySQL();
        Statement statement = connection.createStatement();
        boolean isDeleted = statement.executeUpdate("DELETE FROM products "
                + "WHERE id + '" + id + "' "
                + "LIMIT 1") == 1;

        if (!isDeleted) {
            throw new Exception("product not deleted");
        }
    }

    private Product paraResultSetToProduct(ResultSet resultset) throws Exception {

        Product product = new Product();
        product.setId(resultset.getString("id"));
        product.setName(resultset.getString("name"));
        product.setPrice(resultset.getInt("price"));
        product.setStock(resultset.getInt("stock"));
        product.setStatus(resultset.getBoolean("status"));
        product.setCreatedAt(resultset.getDate("created_at"));
        product.setUpdatedAt(resultset.getDate("updated_at"));
        
        ProductGroup group = new ProductGroup();
        group.setId(resultset.getString("product_group_id"));
        group.setName(resultset.getString("product_group.name"));
        group.setStatus(resultset.getBoolean("product_group.status"));
        group.setCreatedAt(resultset.getDate("product_group.Created_at"));
        group.setUpdatedAt(resultset.getDate("product_group.updated_at"));
        product.setProductGroup(group);
        
        return product;
    }
}


