package org.academiadecodigo.onegitwonders.model;

import javax.persistence.*;

@Entity
@Table(name = "gangster")
public class Gangster {

    @Id
    private String streetName;
    private String realName;
    private String email;
    private String password;
    private Integer streetRep;
    private String avatar;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private Crew crew;
    @Version
    private Integer version;

    public Gangster() {
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public Integer getStreetRep() {
        return streetRep;
    }

    public void setStreetRep(Integer streetRep) {
        this.streetRep = streetRep;
    }
}
