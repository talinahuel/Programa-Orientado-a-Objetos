import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de produtos: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Product> produtos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Produto " + (i + 1) + ":");
            System.out.print("Nome: ");
            String name = scanner.nextLine();

            System.out.print("Preço: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Tipo (I para Importado, U para Usado, N para Normal): ");
            String tipo = scanner.nextLine().toUpperCase();

            Product produto;
            if (tipo.equals("I")) {
                System.out.print("Taxa de Alfândega: ");
                double customsFee = scanner.nextDouble();
                scanner.nextLine();
                produto = new ImportedProduct(name, price, customsFee);
            } else if (tipo.equals("U")) {
                System.out.print("Data de Fabricação (aaaa-mm-dd): ");
                String dateString = scanner.nextLine();
                produto = new UsedProduct(name, price, dateString);
            } else {
                produto = new Product(name, price);
            }

            produtos.add(produto);
        }

        System.out.println("\nEtiquetas de Preço:");
        for (Product produto : produtos) {
            System.out.println(produto.priceTag());
        }

        scanner.close();
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String priceTag() {
        return "Nome: " + name + "\nPreço: R$" + String.format("%.2f", price);
    }
}

class ImportedProduct extends Product {
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        double totalPrice = price + customsFee;
        return "Nome: " + name +
                "\nPreço: R$" + String.format("%.2f", price) +
                "\nTaxa de Alfândega: R$" + String.format("%.2f", customsFee) +
                "\nPreço Total: R$" + String.format("%.2f", totalPrice);
    }
}

Aluno: João Batista dos Santos Batista 
  Recuperação de POO 
  Questão 2

class UsedProduct extends Product {
    private String manufactureDate;

    public UsedProduct(String name, double price, String manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return "Nome: " + name +
                "\nPreço: R$" + String.format("%.2f", price) +
                "\nData de Fabricação: " + manufactureDate;
    }
}
