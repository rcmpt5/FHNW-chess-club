package ch.fhnw.chessclub.data.domain.repository;

import ch.fhnw.chessclub.data.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByUsername(String username);
    boolean existsByUsername(String username);
    void deleteByUsername(String username); // shouldn't be void check pizza example
}
