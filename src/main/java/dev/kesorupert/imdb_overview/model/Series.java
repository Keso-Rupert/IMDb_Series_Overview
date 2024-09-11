package dev.kesorupert.imdb_overview.model;

import java.util.List;

public class Series {

    private final List<Season> seasons;
    private final String title;
    private final String posterImageSource;
    private final Double overallRating;
    private final String description;
    private final String imdbUrl;

    public Series(List<Season> seasons, String title, String posterImageSource, Double overallRating, String description, String imdbUrl) {
        this.seasons = seasons;
        this.title = title;
        this.posterImageSource = posterImageSource;
        this.overallRating = overallRating;
        this.description = description;
        this.imdbUrl = imdbUrl;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterImageSource() {
        return posterImageSource;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public String getDescription() {
        return description;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }
}
