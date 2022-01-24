package xyz.carara.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.carara.workshopmongo.domain.Post;
import xyz.carara.workshopmongo.domain.User;
import xyz.carara.workshopmongo.dto.UserDTO;
import xyz.carara.workshopmongo.resources.util.URL;
import xyz.carara.workshopmongo.services.PostService;
import xyz.carara.workshopmongo.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
}
