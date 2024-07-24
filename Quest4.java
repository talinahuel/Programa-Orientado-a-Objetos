import java.util.Scanner;

public class LocadoraCarros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Modelo do carro: ");
        String modeloCarro = scanner.nextLine();

        System.out.print("Número de horas de locação: ");
        int numeroHoras = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Valor por hora: ");
        double valorHora = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Valor diário: ");
        double valorDiario = scanner.nextDouble();
        scanner.nextLine();

        double valorLocacao;
        if (numeroHoras <= 12) {
            valorLocacao = numeroHoras * valorHora;
        } else {
            int numeroDias = (int) Math.ceil(numeroHoras / 24.0);
            valorLocacao = numeroDias * valorDiario;
        }

        double imposto;
        if (valorLocacao <= 100.00) {
            imposto = valorLocacao * 0.20;
        } else {
            imposto = valorLocacao * 0.15;
        }

        double valorTotal = valorLocacao + imposto;

        System.out.println("\nNota de Pagamento:");
        System.out.printf("Modelo do carro: %s%n", modeloCarro);
        System.out.printf("Valor da locação: R$ %.2f%n", valorLocacao);
        System.out.printf("Valor do imposto: R$ %.2f%n", imposto);
        System.out.printf("Valor total a pagar: R$ %.2f%n", valorTotal);

        scanner.close();
    }
}

//Equipe: Talita Santos, Lyvia Mariah, João Batista, Gabriel 3° "A"
Apresentação POO
Questão 4  
