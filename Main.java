import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
    private String nome;
    private int horas;
    private double valorhora;

    public Funcionario(String nome, int horas, double valorhora) {
        this.nome = nome;
        this.horas = horas;
        this.valorhora = valorhora;
    }

    public String getnome() {
        return nome;
    }

    public double pagamento() {
        return horas * valorhora;
    }
}

class FuncionarioTerc extends Funcionario {
    private double despesaadicional;

    public FuncionarioTerc(String nome, int horas, double valorhora, double despesaadicional) {
        super(nome, horas, valorhora);
        this.despesaadicional = despesaadicional;
    }

    @Override
    public double pagamento() {
        return super.pagamento() + despesaadicional * 1.1;
    }
}

public class Empresa {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.print("Digite o número de funcionários: ");
        int n = leia.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Dados do funcionário #" + (i + 1) + ":");

            System.out.print("Terceirizado (s/n)? ");
            char escolha = leia.next().charAt(0);

            System.out.print("Nome: ");
            leia.nextLine(); 
            String nome = leia.nextLine();

            System.out.print("Horas: ");
            int horas = leia.nextInt();

            System.out.print("Valor por hora: ");
            double valorhora = leia.nextDouble();

            if (escolha == 's') {
                System.out.print("Despesa adicional: ");
                double DespesaAdicional = leia.nextDouble();
                funcionarios.add(new FuncionarioTerc(nome, horas, valorhora, despesaadicional));
            } else {
                funcionarios.add(new Funcionario(nome, horas, valorhora));
            }
        }

        System.out.println();
        System.out.println("PAGAMENTOS:");
        for (Funcionario func : funcionarios) {
            System.out.printf("%s - R$ %.2f%n", func.getnome(), func.pagamento());
        }

        leia.close();
    }
}

//Aluno: João Batista dos Santos Batista 3° A
Recuperação POO 
Questão 1
