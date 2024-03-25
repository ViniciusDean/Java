package Models;

import java.util.List;

public class Filme {
    private String nome;
    private String genero;
    private List<Ator> listaAtores;
    private Diretor diretor;
    private Filmagem filmagem;

    public Filmagem getFilmagem() {
        return filmagem;
    }

    public void setFilmagem(Filmagem filmagem) {
        this.filmagem = filmagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Ator> getListaAtores() {
        return listaAtores;
    }

    public void setListaAtores(List<Ator> listaAtores) {
        this.listaAtores = listaAtores;
    }
}
