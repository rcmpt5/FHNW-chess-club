package ch.fhnw.chessclub.controller;

import ch.fhnw.chessclub.business.service.HomeService;
import ch.fhnw.chessclub.data.domain.HomeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping(path="/info", produces = "application/json")
    public ResponseEntity<HomeInfo> getInfo() {
        return ResponseEntity.ok(homeService.getInfo());
    }

    @PutMapping(path="/info", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HomeInfo> updateInfo(@RequestBody HomeInfo info) {
        try {
            HomeInfo updated = homeService.updateInfo(info);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @DeleteMapping(path="/info")
    public ResponseEntity<String> resetInfo() {
        try {
            homeService.resetInfo();
            return ResponseEntity.ok("Home info reset to default.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not reset home info.");
        }
    }
}
