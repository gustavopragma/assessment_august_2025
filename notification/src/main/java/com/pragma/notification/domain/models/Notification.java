package com.pragma.notification.domain.models;

public class Notification {
    private String id;
    private String type;
    private String message;
    private String tournament;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", tournament='" + tournament + '\'' +
                '}';
    }
}