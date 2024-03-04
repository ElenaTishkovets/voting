package by.it_academy.jd2.service;

import by.it_academy.jd2.service.api.dto.AllStatDto;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.api.IVoteService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatServletServiceTest {
    @Test
    public void test() {
        IStatService statService = new StatService(new TestVoteService());
        AllStatDto allStatDto = statService.get();

        int maxScore = -1;
        for (Map.Entry<String, Integer> entry : allStatDto.getArtistStat().getScore()) {

            if (maxScore == -1) {
                maxScore = entry.getValue();
            } else {
                if (maxScore >= entry.getValue()) {
                    maxScore = entry.getValue();
                } else {
                    Assertions.fail("Статистика вернулась в неправильном порядке");
                }
            }
        }
    }

    public static class TestVoteService implements IVoteService {

        @Override
        public void save(String artist, String[] genres, String about) {
        }

        @Override
        public Map<String, Integer> getArtist() {
            return new HashMap<>() {{
                put("Леонтьев", 3);
                put("Пугачева", 1000000);
                put("ДДТ", 99);
                put("Кино", 2);
            }};
        }

        @Override
        public Map<String, Integer> getGenre() {
            return null;
        }

        @Override
        public List<String> getAbout() {
            return Arrays.asList("Это я", "Второй голос", "люблю потяжелее");
        }
    }
}
