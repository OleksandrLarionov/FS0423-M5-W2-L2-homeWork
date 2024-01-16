package larionov.API.controllers;

import larionov.API.entities.Author;
import larionov.API.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;


    @GetMapping
    public List<Author> getAuthor() {
        return authorService.getAuthors();
    }

    @PostMapping
    public Author saveAuthor(@RequestBody Author body) {
        return authorService.saveAuthor(body);
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) {
        return authorService.findById(id);

    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable Long id, @RequestBody Author body) {
        return authorService.findByIdAndUpdate(id,body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
