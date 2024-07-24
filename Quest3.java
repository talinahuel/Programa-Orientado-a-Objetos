
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProcessadorDeContrato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Número do contrato: ");
        String numeroContrato = scanner.nextLine();
        
        System.out.print("Data do contrato (dd/MM/yyyy): ");
        String dataContratoStr = scanner.nextLine();
        LocalDate dataContrato = LocalDate.parse(dataContratoStr, formatter);
        
        System.out.print("Valor total do contrato: ");
        double valorTotal = scanner.nextDouble();
        
        System.out.print("Número de meses para parcelamento: ");
        int numeroMeses = scanner.nextInt();
        
        double taxaJuroMensal = 0.01;
        double taxaPagamento = 0.02;
        
        double valorParcelaBase = valorTotal / numeroMeses;
        
        System.out.println("\nParcelas:");
        for (int i = 1; i <= numeroMeses; i++) {
            LocalDate dataParcela = dataContrato.plusMonths(i);
            double valorParcelaComJuros = valorParcelaBase * (1 + taxaJuroMensal * i);
            double valorParcelaComTaxa = valorParcelaComJuros * (1 + taxaPagamento);
            
            System.out.printf("Parcela %d: Data: %s, Valor: %.2f%n", i, dataParcela.format(formatter), valorParcelaComTaxa);
        }
        
        scanner.close();
    }
}

//Equipe: João Batista, Gabriel, Talita Santos, Lyvia Mariah 3° A
Apresentação POO
  Questão 3
