package comparableXcomparator;

import java.util.Comparator;

public class Livro implements Comparable<Livro>{

    private String titulo;
    private String autor;
    private int ano;


    public Livro() {
    }

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    //Usado para ordenar livros por titulo
    @Override
    public int compareTo(Livro l) {
        return titulo.compareTo(l.titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
class CompararAutor implements Comparator<Livro> {

    @Override
    public int compare(Livro l1, Livro l2) {
        return l1.getAutor().compareTo(l2.getAutor());
    }
}
class CompararAno implements Comparator<Livro> {

    @Override
    public int compare(Livro l1, Livro l2) {
        return Integer.compare(l1.getAno(), l2.getAno());
    }
}
