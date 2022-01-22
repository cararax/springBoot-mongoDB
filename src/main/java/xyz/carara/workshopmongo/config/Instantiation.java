package xyz.carara.workshopmongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import xyz.carara.workshopmongo.domain.User;
import xyz.carara.workshopmongo.repository.UserRepository;

import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repository.saveAll(Arrays.asList(maria, alex, bob));

    }
}
