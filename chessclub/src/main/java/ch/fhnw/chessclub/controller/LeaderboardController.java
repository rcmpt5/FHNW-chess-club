// package ch.fhnw.chessclub.controller;

// import ch.fhnw.chessclub.business.service.LeaderboardService;
// import ch.fhnw.chessclub.data.domain.LeaderboardEntry;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/leaderboard")
// public class LeaderboardController {

//     @Autowired
//     private LeaderboardService leaderboardService;

//     @GetMapping
//     public List<LeaderboardEntry> getLeaderboard() {
//         return leaderboardService.getLeaderboard();
//     }

//     @PostMapping
//     public ResponseEntity<LeaderboardEntry> addEntry(@RequestBody LeaderboardEntry entry) {
//         return ResponseEntity.ok(leaderboardService.addEntry(entry));
//     }
// }
