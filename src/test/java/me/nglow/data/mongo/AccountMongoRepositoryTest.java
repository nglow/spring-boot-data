package me.nglow.data.mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest // 운영용디비가 아닌 임베디드 디비를 사용함
public class AccountMongoRepositoryTest {

    @Autowired
    AccountMongoRepository accountMongoRepository;

    @Test
    public void findByEmail() {
        Account account = new Account();
        account.setId("TestId");
        account.setEmail("tttt@ddd");
        account.setUsername("tttt");

        accountMongoRepository.save(account);

        Optional<Account> byId = accountMongoRepository.findById(account.getId());
        assertThat(byId).isNotEmpty();

        Optional<Account> byEmail = accountMongoRepository.findByEmail(account.getEmail());
        assertThat(byEmail).isPresent();
        assertThat(byEmail.get().getUsername()).isEqualTo("tttt");
    }
}