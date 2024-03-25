import Models.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class helloworld {
    public static void main(String [] args ) throws ParseException, IOException {
        Filme filme = new Filme();
        Scanner ler = new Scanner(System.in);
        System.out.println("Bem vindo!");
        System.out.println("Cadastro CX filme");
        filme = createfilme(ler);
        int tamanho = filme.getListaAtores().size();
        System.out.println("Informações filme Nome: " + filme.getNome() +
                "\nGenero: " + filme.getGenero() +
                "\nNome do Diretor: " +filme.getDiretor().getNome() +
                "\nIdade do diretor: " + filme.getDiretor().getIdade() +
                "\nNome atores: ");
        for(int x = 0; x < tamanho; x++ ){
            System.out.println(filme.getListaAtores().get(x).getNome());
        }
        System.out.println("Endereco da filmagem: " + filme.getFilmagem().getEndereco());
        System.out.println("Data de inicio das filmagens: " + filme.getFilmagem().getInicio());
        System.out.println("Finalização das filmagens: " +filme.getFilmagem().getFim());
        System.out.println("As filmagens duraram " +filme.getFilmagem().getDuracao() + " Dias");
    }
    public static Filme createfilme(Scanner ler) throws ParseException{
        String resp;
        int sair = 0;
        Filme filme = new Filme();
        System.out.println("Digite o nome do filme: ");
        filme.setNome(ler.next());
        System.out.println("Digite o genero do filme");
        filme.setGenero(ler.next());
        List<Ator> actor = new ArrayList<>();
        while(sair == 0){
            actor.add(createator(ler));
            System.out.println("Deseja criar outro ator? S/N");
            resp = ler.next();
            if(resp.equals("N")|| resp.equals("n")){
                sair = 1;
            }
        }
        filme.setDiretor(createdirector(ler));
        filme.setListaAtores(actor);
        filme.setFilmagem(createfilmagem(ler));
        return filme;
    }
    public static Ator createator(Scanner ler){
        Ator ator = new Ator();
        System.out.println("Digite o nome do ator");
        ator.setNome(ler.next());
        System.out.println("Digite o estudio do ator");
        ator.setEstudioAssociado(ler.next());
        return ator;
    }
    public static Diretor createdirector(Scanner ler){
        Diretor diretor = new Diretor();

        System.out.println("Digite o nome do diretor: ");
        diretor.setNome(ler.next());
        System.out.println("Digite a idade do diretor");
        diretor.setIdade(ler.nextInt());
        return diretor;
    }
    public static Filmagem createfilmagem(Scanner ler) throws ParseException {
        Filmagem filmagem = new Filmagem();
        String data;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Digite a rua da filmagem: ");
        filmagem.setEndereco(ler.next());
        System.out.println("Digite a data de inicio da filmagem ");
        System.out.println("Use o formato dd/MM/yyyy");
        data = (ler.next());
        filmagem.setInicio(formatter.parse(data));
        System.out.println("Digite a data do final da filmagem ");
        System.out.println("Use o formato dd/MM/yyyy");
        data = (ler.next());
        filmagem.setFim(formatter.parse(data));
        long difference_In_Time = filmagem.getFim().getTime() -filmagem.getInicio().getTime() ;
        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
        filmagem.setDuracao(difference_In_Days);
        return filmagem;
    }
}
