package xyz.carara.workshopmongo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.carara.workshopmongo.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria", "maria@maria.com");
        User joao = new User("2", "joao", "joao@marijoao.com");

        List<User> list = new ArrayList<>(Arrays.asList(maria, joao));
        return ResponseEntity.ok().body(list);
    }

}
