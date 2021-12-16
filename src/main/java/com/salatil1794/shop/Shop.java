package com.salatil1794.shop;

import com.salatil1794.shop.entities.Product;
import com.salatil1794.shop.entities.ProductGroup;
import com.salatil1794.shop.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {

    Scanner scan = new Scanner(System.in);

    ProductRepository repository = new ProductRepository();

    public Shop() {
        try {
            boolean isRunning = true;

            while (isRunning) {
                System.out.println("O que deseja fazer? "
                        + "\nDigite \"I\" para inserir um produto"
                        + "\nDigite \"L\" para listar os produtos"
                        + "\nDigite \"U\" para atualizar um produto"
                        + "\nDigite \"D\" para deletar um produto"
                        + "\nDigite \"E\" para sair"
                );
                String action = this.scan.nextLine();
                System.out.println("\n");

                switch (action.toUpperCase()) {
                    case "I":
                        this.insert();
                        break;
                    case "L":
                        this.list();
                        break;
                    case "U":
                        this.update();
                        break;
                    case "D":
                        this.delete();
                        break;
                    case "E":
                        isRunning = false;
                        System.out.println("Bye bye...");
                        break;
                    default:
                        System.out.println("Digite uma opção valida");
                }
                if (action.equalsIgnoreCase("e")) {
                    System.out.println("\nPrecione\"Enter\" para continuar...");
                    this.scan.nextLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void insert() throws Exception {
        System.out.println("Insira as informações solicitadas do produto");
        System.out.println("Nome: ");
        String name = this.scan.nextLine();
        System.out.println("Preço: ");
        String price = this.scan.nextLine();
        System.out.println("Estoque: ");
        String stock = this.scan.nextLine();
        
        Product product = new Product();
        product.setName(name.trim());
        product.setPrice(
            (int)(Float.parseFloat(price.replace(",", ".")) * 100)
                );
        product.setStatus(true);
        product.setStock(Integer.parseInt(stock));
        product.setProductGroup(new ProductGroup());
        product.getProductGroup().setId("f86ef161-3664-46b4-9c29-03e519c0421ei"
                + "");
        
        this.repository.save(product);
    }

    private void list() throws Exception {

        List<Product> products = this.repository.findAll();
        List<String> message = new ArrayList<>();

        products.forEach(product -> {
            message.add("! " + product.getId() + " ! "
                    + product.getName() + " ! "
                    + product.getPrice() + " ! "
                    + product.getStock() + " ! "
                    + product.getProductGroup().getName() + " !");
        });
        
        System.out.println(String.join(
                "\n----------------------------------------\n", message
        ));
    }
    
    private void update() throws Exception {
        System.out.println("Digite o ID do produto que vai ser atualizado:");
        String id = this.scan.nextLine();
        
        Product product = this.repository.findOne(id.trim());
        if (product == null) {
            System.out.println("Produto do id \"" + id + "\", "
            + "não localizado...");
            return;
        }
        
        float price = ((float) product.getPrice()) / 100;
        System.out.println("Digite novo preço "
        + "(atual: " + price +"):");
        
        String newPrice = this.scan.nextLine().trim();
        System.out.println("Digite o novo estoque "
        + "(atual : " + product.getStock() + "): ");
        String newStock = this.scan.nextLine().trim();
        
        product.setPrice(
        (int) (Float.parseFloat(newPrice.replace(",", ".")) *100));
        product.setStock(Integer.parseInt(newStock));
        
        this.repository.save(product);
                
        
        
    }
    
    private void delete() throws Exception {

        System.out.println("Digite o ID do produto que vai ser deletado:");
        String id = this.scan.nextLine();
        
        Product product = this.repository.findOne(id.trim());
        if (product == null) {
            System.out.println("Produto do id \"" + id + "\", "
            + "não localizado...");
            return;
        }
         this.repository.delete(product);
    }
    
    public static void main(String[] args) {
        
    
        new Shop();

    }
}
