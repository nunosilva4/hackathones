package org.academiadecodigo.onegitwonders.model;

import java.util.List;

public class Crew {

    private String name;
    private List<Gangster> members;
    private String logo; //filepath
    private String tag; //filepath

    public Crew() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gangster> getMembers() {
        return members;
    }

    public void setMembers(List<Gangster> members) {
        this.members = members;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
