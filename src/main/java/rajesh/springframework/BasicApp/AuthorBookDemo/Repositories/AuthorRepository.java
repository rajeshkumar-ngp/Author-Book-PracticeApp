package rajesh.springframework.BasicApp.AuthorBookDemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import rajesh.springframework.BasicApp.AuthorBookDemo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
