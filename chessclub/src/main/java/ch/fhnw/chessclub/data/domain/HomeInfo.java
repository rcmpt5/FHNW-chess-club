package ch.fhnw.chessclub.data.domain;

public class HomeInfo {
    private String title;
    private String description;
    private String version;

    public HomeInfo() {}

    public HomeInfo(String title, String description, String version) {
        this.title = title;
        this.description = description;
        this.version = version;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
