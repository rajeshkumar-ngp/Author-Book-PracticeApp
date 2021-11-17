package rajesh.springframework.BasicApp.AuthorBookDemo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rajesh.springframework.BasicApp.AuthorBookDemo.Repositories.AuthorRepository;
import rajesh.springframework.BasicApp.AuthorBookDemo.Repositories.BookRepository;
import rajesh.springframework.BasicApp.AuthorBookDemo.Repositories.PublisherRepository;
import rajesh.springframework.BasicApp.AuthorBookDemo.domain.Author;
import rajesh.springframework.BasicApp.AuthorBookDemo.domain.Book;
import rajesh.springframework.BasicApp.AuthorBookDemo.domain.Publisher;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("Running in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Dhanpatrai & Sons");
        publisher.setAddress("New Delhi");
        publisher.setZip("100100");

       publisherRepository.save(publisher);

        System.out.println("No of Publisher : " + publisherRepository.count());

        Author premchand = new Author("Munshi", "Premchand");
        Book godan = new Book("Godan", "123456");

        premchand.getBooks().add(godan);
        godan.getAuthors().add(premchand);

        godan.setPublisher(publisher);
        publisher.getBooks().add(godan);

        authorRepository.save(premchand);
        bookRepository.save(godan);
        publisherRepository.save(publisher);

        Author dinkar = new Author("Ramdhari Singh", "Dinkar");
        Book rashmirathi = new Book("Rashmirathi", "987456");

        dinkar.getBooks().add(rashmirathi);
        rashmirathi.getAuthors().add(dinkar);

        rashmirathi.setPublisher(publisher);
        publisher.getBooks().add(rashmirathi);

        authorRepository.save(dinkar);
        bookRepository.save(rashmirathi);
        publisherRepository.save(publisher);


        System.out.println("No. of Authors :" + authorRepository.count());
        System.out.println("No. of Books : " + bookRepository.count());
        System.out.println("Publisher No. of Books : " + publisher.getBooks().size());

    }
}
