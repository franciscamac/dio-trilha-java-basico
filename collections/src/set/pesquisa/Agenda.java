package set.pesquisa;

import set.operacoesBasisca.Convidado;

import java.util.HashSet;
import java.util.Set;

public class Agenda {
    private Set<Contato> contatoSet;

    public Agenda() {
        contatoSet = new HashSet<>();
    }
    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));

    }
    public void exibirContatos() {
        if(!contatoSet.isEmpty()){
            System.out.println(contatoSet);
        }else{
            System.out.println("Contato nao encontrado");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (c.getNome().startsWith(nome)) {
                    contatosPorNome.add(c);
                }
            }
            return contatosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }
    public Contato atualizarContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.adicionarContato("Fran da goiaba", 12345);
        agenda.adicionarContato("Fran da Ciriguela", 56789);
        agenda.adicionarContato("Olga da Manga", 32121);

        agenda.exibirContatos();
        System.out.println("Atualizar numero ");
        agenda.atualizarContato("Olga da Manga", 1000000);

        agenda.exibirContatos();

        System.out.println( agenda.pesquisarPorNome("Olga"));
       // agenda.exibirContatos();
    }

}
