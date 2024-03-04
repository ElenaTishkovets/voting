package by.it_academy.jd2.service.api.dto;

import java.util.List;

public class AllStatDto {
    StatDto artistStat;

    StatDto genreStat;

    List<String> abouts;

    public AllStatDto() {
    }

    public AllStatDto(StatDto artistStat, StatDto genreStat, List<String> abouts) {
        this.artistStat = artistStat;
        this.genreStat = genreStat;
        this.abouts = abouts;
    }

    public StatDto getArtistStat() {
        return artistStat;
    }

    public void setArtistStat(StatDto artistStat) {
        this.artistStat = artistStat;
    }

    public StatDto getGenreStat() {
        return genreStat;
    }

    public void setGenreStat(StatDto genreStat) {
        this.genreStat = genreStat;
    }

    public List<String> getAbouts() {
        return abouts;
    }

    public void setAbouts(List<String> abouts) {
        this.abouts = abouts;
    }
}
