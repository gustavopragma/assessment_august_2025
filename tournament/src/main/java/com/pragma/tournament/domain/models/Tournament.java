package com.pragma.tournament.domain.models;

public class Tournament {
    private String id;
    private String name;
    private String streaming;
    private String category;
    private String videogame;
    private String owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreaming() {
        return streaming;
    }

    public void setStreaming(String streaming) {
        this.streaming = streaming;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVideogame() {
        return videogame;
    }

    public void setVideogame(String videogame) {
        this.videogame = videogame;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", streaming='" + streaming + '\'' +
                ", category='" + category + '\'' +
                ", videogame='" + videogame + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}