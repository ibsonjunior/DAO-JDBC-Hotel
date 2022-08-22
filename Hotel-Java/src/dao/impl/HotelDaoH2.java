package dao.impl;

import dao.IDao;
import dao.config.ConfigJDBC;
import entities.Hotel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelDaoH2 implements IDao<Hotel> {
    private ConfigJDBC configJDBC;

    public HotelDaoH2(ConfigJDBC configBD){
        this.configJDBC = configBD;
    }


    @Override
    public Hotel salvar(Hotel hotel) {

        Connection conecxao = configJDBC.conectarComBancoDeDados();

        Statement statement = null;

        String queryInsert = String.format("INSERT INTO hotel(nomeFilial, rua, numero, cidade, estado,  avaliacao) VALUES ('%s','%s','%s','%s','%s','%s')", hotel.getNomeFilial(), hotel.getRua(), hotel.getNumero(), hotel.getCidade(), hotel.getEstado(), hotel.getAvaliacao());

        try{
            statement = conecxao.createStatement();
            statement.executeUpdate(queryInsert, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()){
                hotel.setId(rs.getInt(1));
            }

            statement.close();
            conecxao.close();


        }catch (SQLException e){
            e.printStackTrace();
        }


        return hotel;
    }
}
