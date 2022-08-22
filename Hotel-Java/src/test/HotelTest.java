package test;

import HotelService.HotelService;
import dao.config.ConfigJDBC;
import dao.impl.HotelDaoH2;
import entities.Hotel;
import org.apache.log4j.Logger;
import org.junit.Test;


public class HotelTest {


    final static Logger LOGGER = Logger.getLogger(HotelTest.class);

    Hotel h1, h2, h3, h4, h5;

    private HotelService hotelService = new HotelService(new HotelDaoH2(new ConfigJDBC()));

    @Test
        public void guardarHotel(){
        LOGGER.info("Criando os hotéis em memória.");
        h1 = new Hotel("Recife Mar Hotel", "av.boa viagem", "132546", "Recife", "Pernambuco", "5");
        h2 = new Hotel("Salvador Mar Hotel", "av. salvador", "12000", "Salvador", "Bahia", "2");
        h3 = new Hotel("Natal Mar Hotel", "av. potiguar", "648564", "Natal", "Rio Grande do Norte", "4");
        h4 = new Hotel("Joao Pessoa Mar Hotel", "av. paraiba", "8796789", "Joao Pessoa", "paraiba", "4");
        h5 = new Hotel("Fortaleza Mar Hotel", "av. Ceara", "648564", "Fortaleza", "Ceara", "4");
        LOGGER.info("Hotéis em memória sem o ID.");

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        System.out.println(h5);


        System.out.println("");

        LOGGER.info("Recebendo do BD o registro criado com ID.");
        Hotel r1 = hotelService.salvar(h1);
        Hotel r2 = hotelService.salvar(h2);
        Hotel r3 = hotelService.salvar(h3);
        Hotel r4 = hotelService.salvar(h4);
        Hotel r5 = hotelService.salvar(h5);

        LOGGER.info("Hotel recebido do H2 com ID.");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);

    }

}

