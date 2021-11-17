package rajesh.springframework.BasicApp.AuthorBookDemo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rajesh.springframework.BasicApp.AuthorBookDemo.Repositories.AuthorRepository;
import rajesh.springframework.BasicApp.AuthorBookDemo.Repositories.BookRepository;
import rajesh.springframework.BasicApp.AuthorBookDemo.domain.Author;
import rajesh.springframework.BasicApp.AuthorBookDemo.domain.Book;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author premchand = new Author("Munshi", "Premchand");
        Book godan = new Book("Godan", "123456");

        premchand.getBooks().add(godan);
        godan.getAuthors().add(premchand);

        authorRepository.save(premchand);
        bookRepository.save(godan);

        Author dinkar = new Author("Ramdhari Singh", "Dinkar");
        Book rashmirathi = new Book("Rashmirathi", "987456");

        dinkar.getBooks().add(rashmirathi);
        rashmirathi.getAuthors().add(dinkar);

        authorRepository.save(dinkar);
        bookRepository.save(rashmirathi);

        System.out.println("No. of Authors :" + authorRepository.count());
        System.out.println("No. of Books : " + bookRepository.count());

    }
}
