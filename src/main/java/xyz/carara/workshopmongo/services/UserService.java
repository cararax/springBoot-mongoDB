package xyz.carara.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.carara.workshopmongo.domain.User;
import xyz.carara.workshopmongo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}