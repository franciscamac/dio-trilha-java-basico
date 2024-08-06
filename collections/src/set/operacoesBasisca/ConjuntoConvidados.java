package set.operacoesBasisca;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoset;

    public ConjuntoConvidados() {
        this.convidadoset = new HashSet<>();
    }
    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoset.add(new Convidado(nome, codigoConvite));

    }

    public void removerConvidadoPorCodigo(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        for (Convidado convidado : convidadoset) {
            if(convidado.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = convidado;
                break;
            }
        }
        convidadoset.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return convidadoset.size();
    }
    public void exibirConvidados() {
        if (!convidadoset.isEmpty()) {
            System.out.println(convidadoset);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ConjuntoConvidados
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        // Exibindo o número de convidados no conjunto (deve ser zero)
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        // Adicionando convidados ao conjunto
        conjuntoConvidados.adicionarConvidado("Olga", 1234);
        conjuntoConvidados.adicionarConvidado("Fran", 1235);
        conjuntoConvidados.adicionarConvidado("Olavo", 1235);
        conjuntoConvidados.adicionarConvidado("David", 1236);

        // Exibindo os convidados no conjunto
        System.out.println("Convidados no conjunto:");
        conjuntoConvidados.exibirConvidados();

        // Exibindo o número atualizado de convidados no conjunto
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        // Removendo um convidado do conjunto por código de convite
        conjuntoConvidados.removerConvidadoPorCodigo(1236);
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados após a remoção");

        // Exibindo os convidados atualizados no conjunto
        System.out.println("Convidados no conjunto após a remoção:");
        conjuntoConvidados.exibirConvidados();
    }
}
