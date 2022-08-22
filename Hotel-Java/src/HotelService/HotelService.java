package HotelService;

import dao.IDao;
import entities.Hotel;

public class HotelService {
    private IDao<Hotel> hotelDao;

    public HotelService(IDao<Hotel> hotelDao){

        this.hotelDao =  hotelDao;
    }

    public Hotel salvar(Hotel hotel) {
        return hotelDao.salvar(hotel);
    }
}
