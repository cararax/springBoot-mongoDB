package xyz.carara.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.carara.workshopmongo.domain.Post;
import xyz.carara.workshopmongo.domain.User;
import xyz.carara.workshopmongo.dto.UserDTO;
import xyz.carara.workshopmongo.repository.PostRepository;
import xyz.carara.workshopmongo.repository.UserRepository;
import xyz.carara.workshopmongo.services.exception.ObjectNotFoundException;

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

    public List<Post> findByTitle(String title){
        return repository.findByTitleContainingIgnoreCase(title);

    }

}