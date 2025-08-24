package com.pragma.tournament.domain.models;

public class Category {
    private String id;
    private String name;
    private Integer maxParticipants;
    private Integer maxSpectators;
    private Boolean free;

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

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Integer getMaxSpectators() {
        return maxSpectators;
    }

    public void setMaxSpectators(Integer maxSpectators) {
        this.maxSpectators = maxSpectators;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", max_participants=" + maxParticipants +
                ", max_spectators=" + maxSpectators +
                '}';
    }
}