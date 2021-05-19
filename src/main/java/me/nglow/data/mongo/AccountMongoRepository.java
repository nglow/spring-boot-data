package me.nglow.data.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountMongoRepository extends MongoRepository<Account, String> {

    Optional<Account> findByEmail(String email);
}
