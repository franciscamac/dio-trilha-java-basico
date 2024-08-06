package comparableXcomparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<Livro>(){
            {
                add(new Livro("A Game of Thrones","George R. R. Martin", 1996));
                add(new Livro("A Clash of Kings","George R. R. Martin",1998));
                add(new Livro("A Storm of Swords","George R. R. Martin",2003));
            }
        };


        System.out.println("Livros após a ordenação natural (Título): ");
        Collections.sort(livros);
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo() + " - " +
                    livro.getAutor() + " - " +
                    livro.getAno());
        }

        System.out.println("---------------------------------------");

        System.out.println("Livros após a ordenação por autor: ");
        Collections.sort(livros, new CompararAutor());
        for (Livro livro : livros) {
            System.out.println(livro.getAutor() + " - " +
                    livro.getTitulo() + " - " +
                    livro.getAno());
        }

        System.out.println("---------------------------------------");

        System.out.println("Livros após a ordenação por Ano: ");
        Collections.sort(livros, new CompararAno());
        for (Livro livro : livros) {
            System.out.println(livro.getAno()+ " - " +
                    livro.getTitulo() + " - " +
                    livro.getAutor());
        }
    }
}
