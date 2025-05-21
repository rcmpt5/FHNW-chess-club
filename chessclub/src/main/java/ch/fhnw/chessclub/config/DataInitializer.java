package ch.fhnw.chessclub.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import ch.fhnw.chessclub.business.service.ProfileService;
import ch.fhnw.chessclub.data.domain.Profile;

@Component
public class DataInitializer {

    private final ProfileService profileService;

    public DataInitializer(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostConstruct
    public void init() {
        // Example demo profiles
        Profile alice = new Profile();
        alice.setUsername("alice");
        alice.setFullName("Alice Example");
        alice.setRating(1500);
        profileService.addProfile(alice);

        Profile bob = new Profile();
        bob.setUsername("bob");
        bob.setFullName("Bob Example");
        bob.setRating(1450);
        profileService.addProfile(bob);

        System.out.println("Demo profiles initialized.");
    }
}
