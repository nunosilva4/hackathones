package org.academiadecodigo.onegitwonders.model;

public class Avatar {

    private String filePath;

    public Avatar() {
    }

    public Avatar(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
