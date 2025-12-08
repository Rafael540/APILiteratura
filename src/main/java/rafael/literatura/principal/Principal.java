package rafael.literatura.principal;

import rafael.literatura.model.Book;
import rafael.literatura.model.DadosLivros;
import rafael.literatura.repository.LivroRepository;
import rafael.literatura.service.ConsumoApi;
import rafael.literatura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private final LivroRepository repositorio;
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books?";
    private List<DadosLivros> dadosLivros = new ArrayList<>();

    private List<Book> livros = new ArrayList<>();

    public Principal(LivroRepository repositorio) {
        this.repositorio = repositorio;
    }


    public void exibeMenu(){
        var opcao = -1;
        while(opcao != 0){
            var menu = """
                        -----------------------------
                        Escolha o número de sua opção:
                        1 - buscar livvro por título
                        2 - listar livros registrados
                        3 - listar autores registrados
                        4 - listar autores vivos em um determinado ano
                        5 - listar livros em um determinado idioma
                        0 - sair
                    
                    """;

            System.out.println(menu);
            System.out.print("Digite a opção desejada: ");
            opcao = leitura.nextInt();
            leitura.nextLine();
            
            switch (opcao){
                case 1:
                    buscaLivro();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

                            
            }
        }
    }

    private void buscaLivro() {
        DadosLivros dados = getDadosLivros();
        Book book = new Book(dados);
        repositorio.save(book);
        System.out.println(dados);

    }

    private DadosLivros getDadosLivros(){
        System.out.println("Digite o nome do título para busca");
        var tituloLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO +"search="+ tituloLivro);
        DadosLivros dados = conversor.obterDados(json, DadosLivros.class);
        return dados;
    }
}
