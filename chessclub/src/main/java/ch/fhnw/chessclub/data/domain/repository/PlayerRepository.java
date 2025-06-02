package ch.fhnw.chessclub.data.domain.repository;

import ch.fhnw.chessclub.data.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByUsername(String username);
    boolean existsByUsername(String username);

    @Modifying
    @Transactional
    void deleteByUsername(String username);
}
