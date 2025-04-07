package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfileService {

    private Map<Long, Profile> profiles = new HashMap<>();
    private long nextId = 1;

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfileById(Long id) {
        return profiles.get(id);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(nextId++);
        profiles.put(profile.getId(), profile);
        return profile;
    }

    public Profile updateProfile(Long id, Profile updated) {
        updated.setId(id);
        profiles.put(id, updated);
        return updated;
    }

    public void deleteProfile(Long id) {
        profiles.remove(id);
    }
}
