package com.pragma.tournament.domain.models;

public class Streaming {
    private String id;
    private String name;
    private String platform;
    private String url;

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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Streaming{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}