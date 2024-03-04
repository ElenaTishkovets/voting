package by.it_academy.jd2.service.api;

import java.util.List;
import java.util.Map;

public interface IVoteService {

    /** Сохранение голоса
     * @param artist  артист, за которого голосуют
     * @param genres выбранные жанры
     * @param about о себе
     * @throws IllegalArgumentException в случае ошибки валидации
     */
    void save(String artist, String[] genres, String about);

    Map<String, Integer> getArtist();
    Map<String, Integer> getGenre();
    List<String> getAbout();
}
