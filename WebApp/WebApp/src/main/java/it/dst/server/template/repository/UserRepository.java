package it.dst.server.template.repository;

import it.dst.server.template.object.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "orders")
    Optional<User> findById(Long id);
}
