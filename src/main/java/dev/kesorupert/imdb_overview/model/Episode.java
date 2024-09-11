package dev.kesorupert.imdb_overview.model;

public class Episode {
    private final int episodedNumber;
    private final Double rating;

    public Episode(int episodedNumber, Double rating) {
        this.episodedNumber = episodedNumber;
        this.rating = rating;
    }

    public int getEpisodedNumber() {
        return episodedNumber;
    }

    public Double getRating() {
        return rating;
    }
}
