package rafael.literatura.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import rafael.literatura.model.Book;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleContainingIgnoreCase(String nomeLivro);

}
