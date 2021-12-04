package com.salatil1794.shop;

import com.salatil1794.shop.confg.ConexaoMySQL;
import com.salatil1794.shop.entities.ProductGroup;
import com.salatil1794.shop.entities.ProductGroupController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;

public class Shop {

    Scanner scan = new Scanner(System.in);

    ProductGroupController controller = new ProductGroupController();

//    public static void main(String[] args) {
//        new Shop();
//    }
//    public Shop() {
//        System.out.println("Por favor insira o nome do grupo do produto: ");
//        ProductGroup group = new ProductGroup();
//        group.setNome(this.scan.nextLine().trim());
//        group.setStatus(true);
//        this.controller.create(group);
//        System.out.println("---------------------------\n"
//                + "ID: " + group.getId() + "\n"
//                + "Nome: " + group.getNome() + "\n"
//                + "status: " + (group.isStatus() ? "ATIVO" : "INATIVOS") + "\n"
//                + "--------------------------------------------------");
//    }
    public static void main(String[] args) {
        try {
            Connection conexaoMySQL = ConexaoMySQL.getConexaoMySQL();
            Statement statement = conexaoMySQL.createStatement();
            System.out.println(ConexaoMySQL.status);
//             ResultSet result = statement.executeQuery("");

            //inserindo dados via sql direto
//        statement.execute("INSERT INTO product_groups (id, name, status) " 
//                + "VALUES ('" + UUID.randomUUID() + "', 'carnes', true)");
//             while (result.next()) {
//                 System.out.println(result.getString("id"));
            String sql = "INSERT INTO products (id, name, price, stock, "
                    + "status, product_group_id)"
                    + "Values ("
                    + "'" + UUID.randomUUID() + "', "
                    + "'picanha', "
                    + "7000, "
                    + "99, "
                    + "true, "
                    + "(SELECT id FROM product_groups LIMIT 1)"
                    + ")";
            System.out.println(sql);
            statement.execute(sql);

//             }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            ConexaoMySQL.FecharConexao();
        }
    }

}
