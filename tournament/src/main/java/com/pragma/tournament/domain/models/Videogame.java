package com.pragma.tournament.domain.models;

public class Videogame {
    private String id;
    private String name;
    private String genre;
    private Integer numberPlayers;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNumberPlayers() {
        return numberPlayers;
    }

    public void setNumberPlayers(Integer number_players) {
        this.numberPlayers = number_players;
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", number_players=" + numberPlayers +
                '}';
    }
}