package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> lista;

    public CarrinhoDeCompras() {
        this.lista = new ArrayList<>();
    }

    public void adicionaItem(String nome, double preco, int quantidade) {
        lista.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> listaParaRemover = new ArrayList<>();
        for (Item item : lista) {
            if (item.getNome().equals(nome)) {
                listaParaRemover.add(item);
            }
        }
        lista.removeAll(listaParaRemover);
    }
    public void imprimeLista() {
        for (Item item : lista) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionaItem("Caneta", 1.99, 2);
        carrinho.adicionaItem("mousse", 2.99, 3);
        carrinho.adicionaItem("teclado", 3.99, 3);
        carrinho.imprimeLista();

        System.out.println("----------------------------");
        System.out.println("Removendo item: ");
        carrinho.removerItem("Caneta");
        carrinho.imprimeLista();

    }
}

