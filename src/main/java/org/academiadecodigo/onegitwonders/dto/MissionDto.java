package org.academiadecodigo.onegitwonders.dto;

public class MissionDto {

    private Integer id;
    private String title;
    private String description;
    private Integer repCost;
    private Double successRate;
    private Integer repReward;

    public MissionDto() {
    }

    public Integer getRepReward() {
        return repReward;
    }

    public void setRepReward(Integer repReward) {
        this.repReward = repReward;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getRepCost() {
        return repCost;
    }

    public void setRepCost(Integer repCost) {
        this.repCost = repCost;
    }

    public Double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Double successRate) {
        this.successRate = successRate;
    }
}
