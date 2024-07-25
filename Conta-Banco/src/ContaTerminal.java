
import java.util.Scanner;
class Conta {
    private int numero;
    private String tipo;
    private double saldo;

    public Conta(int numero, String tipo, double saldo) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Conta() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;

    }

    public void sacar(double valor) {
        if (this.saldo < valor) {
            this.saldo -= valor;
        }else
            System.out.println("Saldo insuficiente!");
    }
}
public class ContaTerminal {
    public static void main(String[] args) {
        //TODO: conhecer e importar a classe scanner
        //Exibir as mensagens para o nosso usuario
        //Obter pela scanner os valores digitados no terminal
        //Exibir a mensagem conta criada

        Scanner sc = new Scanner(System.in);

        Conta conta = new Conta();
        String texto = """
                Menu
                1 - Para Cadastrar Conta
                2 - Para Depositar Conta
                3 - Para Sacar Conta
                4 - Sair
                """;
        int opcao = 0;
        while (true) {
            System.out.println(texto);
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o numero: ");
                    conta.setNumero(sc.nextInt());
                    System.out.println("Digite o tipo: ");
                    conta.setTipo(sc.next());
                    System.out.println("Digite o saldo: ");
                    conta.setSaldo(sc.nextDouble());
                    System.out.println("Conta criada com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja depositar: ");
                    conta.depositar(sc.nextDouble());
                    System.out.println("Valor atual: " + conta.getSaldo());
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja sacar: ");
                    conta.sacar(sc.nextDouble());
                    System.out.println("Valor atual: " + conta.getSaldo());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;

            }
        }
    }
}