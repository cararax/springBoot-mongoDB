package xyz.carara.workshopmongo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import xyz.carara.workshopmongo.domain.Post;
import xyz.carara.workshopmongo.domain.User;
import xyz.carara.workshopmongo.repository.PostRepository;
import xyz.carara.workshopmongo.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/01/2022"),"Partiu viajar", "Vou  viajar para São Paulo, abraços a todos!", maria);
        Post post2 = new Post(null, sdf.parse("23/01/2022"),"Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
