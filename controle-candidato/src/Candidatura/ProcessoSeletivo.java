package Candidatura;

import java.util.Scanner;

class Candidato{
    private String nome;
    private int idade;
    private double salarioPretendido;

    public Candidato(String nome, int idade, double salarioPretendido) {
        this.nome = nome;
        this.idade = idade;
        this.salarioPretendido = salarioPretendido;
    }
    public Candidato() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getSalarioPretendido() {
        return salarioPretendido;
    }
    public void setSalarioPretendido(double salarioPretendido) {
        this.salarioPretendido = salarioPretendido;
    }

    public void cadastraCandidato(Scanner sc) {

        System.out.println("Processo Seletivo");
        System.out.println("Digite o nome do candidato: ");
        setNome(sc.nextLine());
        System.out.println("Digite a idade do candidato: ");
        setIdade(sc.nextInt());
        System.out.println("Digite o salario pretendido do candidato: ");
        setSalarioPretendido(sc.nextDouble());
    }
    public void mostraCandidato() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Salario pretendido: " + getSalarioPretendido());
    }
    public void analisaCandidato() {
        double salarioBase = 2000;
        System.out.println("Salario Base: " + salarioBase);
        if(salarioPretendido < salarioBase) {
            System.out.println("LIGAR PARA O CANDIDATO");
            tentarEntrarEmContato();
        }else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
            tentarEntrarEmContato();
        }else
            System.out.println("NÃO LIGAR PARA O CANDIDATO");
    }
    public void tentarEntrarEmContato() {
        int tentativas = 3;
        boolean contatoBemSucedido = false;
        for (int i = 0; i < tentativas; i++) {
            System.out.println("Tentativa " + (i + 1) + " de entrar em contato com " + getNome());
            if (simularContato()) {
                contatoBemSucedido = true;
                System.out.println("Contato bem-sucedido com " + getNome());
                break;
            }
        }
        if (!contatoBemSucedido) {
            System.out.println("Não foi possível entrar em contato com " + getNome() + " após " + tentativas + " tentativas.");
        }
    }

    private boolean simularContato() {
        return Math.random() > 0.5;
    }
}
class GerenciadorCandidato extends Candidato{
    private Candidato[] candidatos;
    private int contCandidato;

    public GerenciadorCandidato(int quantidade) {
        candidatos = new Candidato[quantidade];
        contCandidato = 0;
    }
    public void adicionaCandidato(Candidato candidato) {
        if(contCandidato< candidatos.length){
            candidatos[contCandidato] = candidato;
            contCandidato++;
        }else{
            System.out.println("Não é possivel adicionar mais candidatos");
        }
    }
    public void cadastraCandidatos(Scanner sc) {
        if (contCandidato >= candidatos.length) {
            System.out.println("Capacidade máxima de candidatos atingida.");
            return;
        }
        Candidato candidato = new Candidato();
        System.out.println("Cadastrando candidato " + (contCandidato + 1));
        candidato.cadastraCandidato(sc);
        adicionaCandidato(candidato);
    }
    public void mostraCandidatos() {
        if (contCandidato == 0) {
            System.out.println("Nenhum candidato cadastrado.");
        } else {
            for (int i = 0; i < contCandidato; i++) {
                candidatos[i].mostraCandidato();
                System.out.println();
            }
        }
    }
    public void analisaCandidatos() {
        if (contCandidato == 0) {
            System.out.println("Nenhum candidato cadastrado.");
        } else {
            for (int i = 0; i < contCandidato; i++) {
                System.out.println("Analisando candidato " + (i + 1) + ":");
                 candidatos[i].analisaCandidato();
                candidatos[i].mostraCandidato();

            }
        }
    }
}
public class ProcessoSeletivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorCandidato gec = new GerenciadorCandidato(3);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Candidato");
            System.out.println("2. Mostrar Candidatos");
            System.out.println("3. Analisar Candidatos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    gec.cadastraCandidato(sc);
                    break;
                case 2:
                    gec.mostraCandidato();
                    break;
                case 3:
                    gec.analisaCandidatos();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();

    }

}
