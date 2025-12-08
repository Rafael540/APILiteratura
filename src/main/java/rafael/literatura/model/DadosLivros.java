package rafael.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



public record DadosLivros(@JsonAlias("title") String title,
                          @JsonAlias("authors") Author autor,
                          @JsonAlias("summaries")String sumaries,
                          @JsonAlias("editors") String editors,
                          @JsonAlias("translators")Idioma idioma,
                          @JsonAlias("subjects") String subjects,
                          @JsonAlias ("bookshelves") String bookshelves)
{
}
