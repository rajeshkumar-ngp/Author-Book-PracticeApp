package rajesh.springframework.BasicApp.AuthorBookDemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import rajesh.springframework.BasicApp.AuthorBookDemo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
