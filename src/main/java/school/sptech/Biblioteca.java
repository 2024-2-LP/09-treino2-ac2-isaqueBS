package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro){
        if(livro == null || livro.getTitulo() == null || livro.getTitulo().isBlank()
        || livro.getAutor() == null || livro.getAutor().isBlank() || livro.getDataPublicacao() == null){
            throw new ArgumentoInvalidoException("Alguma informação sobre o livro é Invalida");

        }
        livros.add(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo){
        if (titulo == null || titulo.isEmpty() || titulo.equals(" ")) {
            throw new ArgumentoInvalidoException("Argumento invalido");
        }

        Integer livroPorTitulo = 0;
        Livro livroCerto = null;

        for (int i = 0; i < livros.size(); i++) {
            if(titulo.equalsIgnoreCase(livros.get(i).getTitulo())){
                livroPorTitulo = 1;
                livroCerto = livros.get(i);
            }
        }
        if (livroPorTitulo == 0){
            throw new LivroNaoEncontradoException("nao encontrado");
        }
        return livroCerto;
    }

    public void removerLivroPorTitulo(String titulo){
        Livro RemoverLivro = buscarLivroPorTitulo(titulo);
        livros.remove(RemoverLivro);
    }

    public Integer contarLivros(){
        return (int) livros.stream().count();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> AnoDoLivro = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                AnoDoLivro.add(livro);
            }
        }
        return AnoDoLivro;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }




}
