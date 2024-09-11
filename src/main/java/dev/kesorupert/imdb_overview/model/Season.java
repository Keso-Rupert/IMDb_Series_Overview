package dev.kesorupert.imdb_overview.model;

import java.util.List;

public class Season {
    private final List<Episode> episodes;

    public Season(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
