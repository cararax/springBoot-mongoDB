package xyz.carara.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.carara.workshopmongo.domain.Post;
import xyz.carara.workshopmongo.resources.util.URL;
import xyz.carara.workshopmongo.services.PostService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findBTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        List<Post> postList = service.findByTitle(title);
        return ResponseEntity.ok().body(postList);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date defaultMinDate = new Date(0L);
        Date min = URL.convertDate(minDate, defaultMinDate);
        Date currentDate = new Date();
        Date max = URL.convertDate(maxDate, currentDate);

        List<Post> postList = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(postList);
    }
}
