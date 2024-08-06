package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> listaTarefa;

    public ListaTarefa() {
        this.listaTarefa = new ArrayList<>();
    }
    public void adicionarTarefa(String descricao) {
        listaTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa tarefa : listaTarefa) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(tarefa);
            }
        }
        listaTarefa.removeAll(tarefasParaRemover);
    }

    public int obterTarefa() {
        return listaTarefa.size();
    }
    public void obterDescricao() {
        System.out.println(listaTarefa);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();
        listaTarefa.adicionarTarefa("Tarefa A");
        listaTarefa.adicionarTarefa("Tarefa B");
        listaTarefa.adicionarTarefa("Tarefa C");
        listaTarefa.adicionarTarefa("Tarefa D");
        listaTarefa.adicionarTarefa("Tarefa D");
        System.out.println("O numero total de elemento na lista é: " + listaTarefa.obterTarefa());

        listaTarefa.removerTarefa("Tarefa B");
        System.out.println("O numero total de elemento na lista é: " + listaTarefa.obterTarefa());

        listaTarefa.obterDescricao();

    }
}
