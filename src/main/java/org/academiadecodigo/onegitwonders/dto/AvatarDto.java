package org.academiadecodigo.onegitwonders.dto;

import org.academiadecodigo.onegitwonders.model.Crew;

public class AvatarDto {

    private String imageUrl;
    private Crew crew;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }
}
