package by.it_academy.jd2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    public final static Object lock = new Object();
    private Map<String, Integer> artistsContainer = new HashMap<>();
    private Map<String, Integer> genreContainer = new HashMap<>();
    private  List<String> aboutContainer = new ArrayList<>();

    public Map<String, Integer> getArtistsContainer() {
        return artistsContainer;
    }

    public Map<String, Integer> getGenreContainer() {
        return genreContainer;
    }

    public List<String> getAboutContainer() {
        return aboutContainer;
    }

    public static void saveToContainer (Map<String, Integer> data, String key){
        synchronized (Data.class) {
            data.compute(key, (k, v) -> v != null ? v + 1 : 1);
        }
    }
}
