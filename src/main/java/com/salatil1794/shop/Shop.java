package com.salatil1794.shop;

import com.salatil1794.shop.entities.Product;
import com.salatil1794.shop.entities.ProductGroupController;
import com.salatil1794.shop.repositories.ProductRepository;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        ProductRepository repository = new ProductRepository();
        
        try {
            List<String> ids = repository.findByName("bovina").stream()
                    .map(product -> product.getId())
                    .collect(Collectors.toList());
            
            List<Product> products = repository.findByIds(ids);
            
            products.forEach(product -> {
            System.out.println(product.getName());
        });
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
}
