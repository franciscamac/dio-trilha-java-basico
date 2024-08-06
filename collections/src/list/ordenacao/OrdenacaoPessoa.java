package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {
    private List<Pessoa> pessoas;
    public OrdenacaoPessoa() {
        this.pessoas = new ArrayList<>();
    }
    public void adicionar(String nome, int idade, double altura) {
        pessoas.add(new Pessoa(nome, idade, altura));

    }
    public List<Pessoa> ordenadoPorIdade() {
        List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoas);
        Collections.sort(pessoaPorIdade);
    return pessoaPorIdade;
    }

    public List<Pessoa> ordenadoPorAltura() {
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoas);
        Collections.sort(pessoaPorAltura, new ComparatorPorAltura());
        return pessoaPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoas = new OrdenacaoPessoa();

        // Adicionando pessoas à lista
        ordenacaoPessoas.adicionar("Alice", 20, 1.56);
        ordenacaoPessoas.adicionar("Bob", 30, 1.80);
        ordenacaoPessoas.adicionar("Charlie", 25, 1.70);
        ordenacaoPessoas.adicionar("David", 17, 1.56);

        // Exibindo a lista de pessoas adicionadas
        System.out.println("Pessoas ordenadas:");
        System.out.println(ordenacaoPessoas.pessoas);

        // Ordenando e exibindo por idade
        System.out.println("Ordenado po idade: ");
        System.out.println(ordenacaoPessoas.ordenadoPorIdade());

        // Ordenando e exibindo por altura
        System.out.println("Ordenado po altura: ");
        System.out.println(ordenacaoPessoas.ordenadoPorAltura());
    }
}
