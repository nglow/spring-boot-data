package me.nglow.data.neo4j;

import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

@Profile("neo4j")
public interface AccountNeo4jRepository extends Neo4jRepository<Account, Long> {
}
