package larionov.API.services;

import larionov.API.entities.Author;
import larionov.API.entities.BlogPost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class BlogPostService {


    private List<BlogPost> blogPost = new ArrayList<>();

    public List<BlogPost> getBlogPosts() {
        return this.blogPost;
    }

    public BlogPost saveBlogPost(BlogPost body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1, 20000));
        this.blogPost.add(body);
        return body;
    }

    public BlogPost findById(Long id) {
        BlogPost found = null;
        for (BlogPost author : this.blogPost) {
            if (author.getId() == id) {
                found = author;
            }
        }
        if (found == null) {
            log.info("per la peppa");
        }
        return found;
    }

    public void delete(Long id) {
        Iterator<BlogPost> iterator = this.blogPost.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public BlogPost findByIdAndUpdate(Long id, BlogPost body) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPost) {
            if (blogPost.getId() == id) {
                found = blogPost;
                found.setId(id);
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setCover(blogPost.getCover());
                found.setContenuto(blogPost.getContenuto());
                found.setTempoDiLettura(blogPost.getTempoDiLettura());

            }
        }
        if (found == null) {
            log.info("error");
        }
        return found;
    }
}

