package xyz.carara.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.carara.workshopmongo.domain.User;
import xyz.carara.workshopmongo.dto.UserDTO;
import xyz.carara.workshopmongo.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO user){
        User newUser = service.insert(service.fromDTO(user));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(("/{id}")).buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
       service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
