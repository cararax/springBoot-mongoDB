package xyz.carara.workshopmongo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import xyz.carara.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}