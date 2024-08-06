package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtosSet;

    public CadastroProdutos() {
        produtosSet = new HashSet<>();
    }
    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtosSet.add(new Produto(codigo, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtosSet);
        if (!produtosSet.isEmpty()) {
            return produtosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }


    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        if (!produtosSet.isEmpty()) {
            produtosPorPreco.addAll(produtosSet);
            return produtosPorPreco;
        }else{
            throw new RuntimeException("O conjunto esta vazio!");
        }
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(123,"Mousse", 23.9,2);
        cadastroProdutos.adicionarProduto(234,"Teclado", 50.0,3);
        cadastroProdutos.adicionarProduto(788,"Pen drive", 5.0, 1);

        System.out.println(cadastroProdutos.produtosSet);

        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }

}
