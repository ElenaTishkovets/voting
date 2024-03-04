package by.it_academy.jd2.service.api;

import by.it_academy.jd2.service.api.dto.StatDto;
import by.it_academy.jd2.service.api.dto.AllStatDto;

public interface IStatService {
    /**
     * Получение всей статистики
     * @return
     */
    AllStatDto get();

    /**
     * Получение статистики по артистам
     * @return
     */
    StatDto getArtistStat(); // тут все хорошо

    /**
     * Получение статистики по конкретному артисту
     * @param artist артист, по которому нужно получить статистику
     * @return количество голосов за артиста
     */
    long getByArtist (String artist);

    /**
     * Получение статистики по жанрам
     * @return
     */
    StatDto getGenreStat();

    /**
     * Получение статистики по конкретному жанру
     * @param genre жанр, по которому нужно получить статистику
     * @return количество голосов за жанр
     */
    long getByGenre (String genre);
}
