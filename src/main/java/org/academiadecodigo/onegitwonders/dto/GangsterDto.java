package org.academiadecodigo.onegitwonders.dto;

import org.academiadecodigo.onegitwonders.model.Crew;

import javax.validation.constraints.NotNull;

public class GangsterDto {

    private Integer id;
    @NotNull
    private String streetName;
    private Integer streetRep;
    private String avatar;
    private String realName;
    private String email;
    private String password;
    private Crew crew;
    private Boolean busted;

    public GangsterDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getBusted() {
        return busted;
    }

    public void setBusted(Boolean busted) {
        this.busted = busted;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetRep() {
        return streetRep;
    }

    public void setStreetRep(Integer streetRep) {
        this.streetRep = streetRep;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
