package Models;

import java.util.List;

public class Diretor extends pessoa {


    private List<String> filmesdirigidos;
    private List<Ator> atoresfavoritos;

    public List<String> getFilmesdirigidos() {
        return filmesdirigidos;
    }

    public void setFilmesdirigidos(List<String> filmesdirigidos) {
        this.filmesdirigidos = filmesdirigidos;
    }

    public List<Ator> getAtoresfavoritos() {
        return atoresfavoritos;
    }

    public void setAtoresfavoritos(List<Ator> atoresfavoritos) {
        this.atoresfavoritos = atoresfavoritos;
    }
}
