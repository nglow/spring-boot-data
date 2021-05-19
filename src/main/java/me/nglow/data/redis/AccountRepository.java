package me.nglow.data.redis;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("redis")
public interface AccountRepository extends CrudRepository<Account, String> {
}
