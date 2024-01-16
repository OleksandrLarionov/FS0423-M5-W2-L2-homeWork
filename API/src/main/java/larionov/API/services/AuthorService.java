package larionov.API.services;

import larionov.API.entities.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return this.authors;
    }

    public Author saveAuthor(Author body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1, 20000));
        body.setAvatar("https://ui-avatar.com/api/?name=" + body.getName() + body.getSurname());
//        body.setEmail(body.getName() + "." + body.getSurname() + "@mail.com");
        this.authors.add(body);
        return body;
    }

    public Author findById(Long id) {
        return authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    log.info("per la peppa");
                    return null;
                });
    }

    public void delete(Long id) {
      authors.removeIf(author -> author.getId().equals(id));
    }

    public Author findByIdAndUpdate(Long id, Author body) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
                found.setId(id);
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setEmail(body.getEmail());
                found.setDataDiNascita(body.getDataDiNascita());
                found.setAvatar(body.getAvatar());

            }
        }
        if (found == null) {
            log.info("error");
        }
        return found;
    }
}