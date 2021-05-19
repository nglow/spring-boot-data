package me.nglow.data.neo4j;

import org.neo4j.driver.Session;
import org.neo4j.driver.internal.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("neo4j")
@Component
public class Neo4jRunner implements ApplicationRunner {

    private final static Logger log = LoggerFactory.getLogger(Neo4jRunner.class);

    @Autowired
    AccountNeo4jRepository accountNeo4jRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        accountNeo4jRepository.deleteAll();
        Account account = new Account();
        account.setEmail("aaaa@bb");
        account.setUsername("aaaa");

        Role role = new Role();
        role.setName("admin");

        account.getRoles().add(role);

        accountNeo4jRepository.save(account);
        log.info("finished");
    }
}
