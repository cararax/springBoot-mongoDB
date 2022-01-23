package xyz.carara.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.carara.workshopmongo.domain.User;
import xyz.carara.workshopmongo.dto.UserDTO;
import xyz.carara.workshopmongo.repository.UserRepository;
import xyz.carara.workshopmongo.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        User userUpdated = findById(user.getId());
        updateData(userUpdated, user);
        return repository.save(userUpdated);
    }

    private void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO user){
        return new User(user.getId(), user.getName(), user.getEmail());
    }

}