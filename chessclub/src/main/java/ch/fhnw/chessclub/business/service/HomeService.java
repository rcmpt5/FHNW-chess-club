package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.HomeInfo;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private HomeInfo info = new HomeInfo("FHNW Chess Club", "Welcome to our club platform!", "v1.0");

    public HomeInfo getInfo() {
        return info;
    }

    public HomeInfo updateInfo(HomeInfo updatedInfo) {
        info.setTitle(updatedInfo.getTitle());
        info.setDescription(updatedInfo.getDescription());
        info.setVersion(updatedInfo.getVersion());
        return info;
    }

    public void resetInfo() {
        info = new HomeInfo("FHNW Chess Club", "Welcome to our club platform!", "v1.0");
    }
}
