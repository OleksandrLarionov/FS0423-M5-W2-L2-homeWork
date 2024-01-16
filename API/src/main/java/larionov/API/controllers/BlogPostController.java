package larionov.API.controllers;

import larionov.API.entities.Author;
import larionov.API.entities.BlogPost;
import larionov.API.services.AuthorService;
import larionov.API.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getBlogPosts() {
        return blogPostService.getBlogPosts();
    }

    @PostMapping
    public BlogPost saveBlogpost(@RequestBody BlogPost body) {
        return blogPostService.saveBlogPost(body);
    }

    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable Long id) {
        return blogPostService.findById(id);

    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable Long id, @RequestBody BlogPost body) {
        return blogPostService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    public void findByIdAndDelete(@PathVariable Long id) {
        blogPostService.delete(id);
    }
}
