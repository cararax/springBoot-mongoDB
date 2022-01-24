package xyz.carara.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.carara.workshopmongo.domain.Post;

import xyz.carara.workshopmongo.repository.PostRepository;
import xyz.carara.workshopmongo.services.exception.ObjectNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String title) {
        return repository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        int day = 24 * 60 * 60 * 1000;
        maxDate = new Date(maxDate.getTime() + day);
        return repository.fullSearch(text, minDate, maxDate);
    }

}