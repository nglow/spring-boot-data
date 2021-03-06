package me.nglow.data.redis;

import com.sun.org.glassfish.external.probe.provider.annotations.Probe;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Profile("redis")
@RedisHash("accounts")
public class Account {

    @Id
    private String id;

    private String username;

    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
