package me.nglow.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Profile("redis")
@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    AccountRepository accountRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = stringRedisTemplate.opsForValue();
        values.set("th", "nglow");
        values.set("springboot", "2.0");
        values.set("hello", "world");

        System.out.println(values.get("th"));
        System.out.println(values.get("springboot"));
        System.out.println(values.get("hello"));

        Account account = new Account();
        account.setEmail("aa@bbb");
        account.setUsername("nglow");
        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println(byId.get().getUsername());
        System.out.println(byId.get().getEmail());


    }
}
