package by.it_academy.jd2.dao.api;

import java.util.List;
import java.util.Map;

public interface IVoteDao {

    /** Сохранение голоса
     * @param artist  артист, за которого голосуют
     * @param genres выбранные жанры
     * @param about о себе
     */
    void save(String artist, String[] genres, String about);

    Map<String, Integer> getArtist();

    Map<String, Integer> getGenre();

    List<String> getAbout();
}

