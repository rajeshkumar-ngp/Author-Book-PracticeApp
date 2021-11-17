package rajesh.springframework.BasicApp.AuthorBookDemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import rajesh.springframework.BasicApp.AuthorBookDemo.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
