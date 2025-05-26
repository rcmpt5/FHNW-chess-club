package ch.fhnw.chessclub.data.domain.repository;

import ch.fhnw.chessclub.data.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByName(String name);
    List<Tournament> findByLocation(String location);
    List<Tournament> findByDate(String date);
}
