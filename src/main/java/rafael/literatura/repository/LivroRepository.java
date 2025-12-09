package rafael.literatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rafael.literatura.model.Author;
import rafael.literatura.model.Book;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleContainingIgnoreCase(String nomeLivro);

    Optional<Author> findbyBirthdate(Author author, int ano);

    Optional<Author> findAuthorByYear(Author author, int anoLimite);

    List<Book> findByIdioma(String idiomaLivro);
}
