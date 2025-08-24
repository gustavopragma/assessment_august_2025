package com.pragma.tournament.domain.models;

public class Ticket {
    private String id;
    private String type;
    private Double price;
    private Integer saleComission;
    private String stage;
    private Boolean active;
    private String tournament;
    private String user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSaleComission() {
        return saleComission;
    }

    public void setSaleComission(Integer saleComission) {
        this.saleComission = saleComission;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", saleComission=" + saleComission +
                ", stage='" + stage + '\'' +
                ", active=" + active +
                ", tournament='" + tournament + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}