package by.it_academy.jd2.service.factory;

import by.it_academy.jd2.dao.factory.DaoFactory;
import by.it_academy.jd2.service.StatService;
import by.it_academy.jd2.service.VoteService;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.api.IVoteService;

public class ServiceFactorySingleton {
    private volatile static IStatService statService;
    private volatile static IVoteService voteService;

    public static IStatService getStatService (){
        if (statService == null) {
            synchronized (ServiceFactorySingleton.class) {//синхронайзд не делаем выше, чтобы обеспечить высокую скорость работы
                //если его разместить выше, то каждый поток который придет за методом гетИнстанс (то есть за объектом с
                //статСервайс - синхронизируется, но если поле уже не налл, значит оно уже создано с помощью синглтона
                // и синхронизация не нужна, поле защищено синглтоном
                if (statService == null) {
                    //делаем внутри синхронайзд еще один иф, потому что в самам начале в метод могут зайти несколько
                    //потоков, поэтому опять проверяем что инстанс  нал, инициализируем его, или наоборот инстанс -
                    //не нал, тогда делать уже ничего не надо
                    statService = new StatService(getVoteService());
                }
            }
        }
        return statService;
    }

    public static IVoteService getVoteService() {
        if (voteService == null) {
            synchronized (ServiceFactorySingleton.class) {//синхронайзд не делаем выше, чтобы обеспечить высокую скорость работы
                //если его разместить выше, то каждый поток который придет за методом гетИнстанс (то есть за объектом с
                //статСервайс - синхронизируется, но если поле уже не налл, значит оно уже создано с помощью синглтона
                // и синхронизация не нужна, поле защищено синглтоном
                if (voteService == null) {
                    //делаем внутри синхронайзд еще один иф, потому что в самам начале в метод могут зайти несколько
                    //потоков, поэтому опять проверяем что инстанс  нал, инициализируем его, или наоборот инстанс -
                    //не нал, тогда делать уже ничего не надо
                    voteService = new VoteService(DaoFactory.getVoteDao());
                }
            }
        }return voteService;
    }

}
