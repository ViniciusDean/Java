package Models;

import java.util.List;

public class Ator extends pessoa{
    private List<String> filmesTrabalhados;

    private String estudioAssociado;

    public List<String> getFilmesTrabalhados() {
        return filmesTrabalhados;
    }

    public void setFilmesTrabalhados(List<String> filmesTrabalhados) {
        this.filmesTrabalhados = filmesTrabalhados;
    }

    public String getEstudioAssociado() {
        return estudioAssociado;
    }

    public void setEstudioAssociado(String estudioAssociado) {
        this.estudioAssociado = estudioAssociado;
    }
}
