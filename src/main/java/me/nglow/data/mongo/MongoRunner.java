//package me.nglow.data.mongo;
//
//import com.mongodb.client.FindIterable;
//import org.bson.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//@Profile("mongo")
//@Component
//public class MongoRunner implements ApplicationRunner {
//
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    @Autowired
//    AccountRepository accountRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Account account = new Account();
//        account.setEmail("aaa@bb");
//        account.setUsername("aaa");
//
//        // Use Mongo Template
//        System.out.println("Mongo Template");
//
//        mongoTemplate.insert(account);
//
//        FindIterable<Document> accounts = mongoTemplate.getCollection("accounts").find();
//        accounts.forEach(document -> System.out.println(document + "\n"));
//
//        // Use Mongo Repository
//        Account account1 = new Account();
//        account.setId("abcdefg");
//        account.setEmail("ccc@dd");
//        account.setUsername("ccc");
//
//        System.out.println("Mongo Repository");
//        Account inserted = accountRepository.insert(account);
//        accounts.forEach(document -> System.out.println(document + "\n"));
//        System.out.println(accountRepository.findById(inserted.getId()).get().getUsername());
//    }
//}
