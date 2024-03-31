package dao;

import entities.AnimalEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {

    public List<AnimalEntity> getAnimals(){
        List<AnimalEntity> animals = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM animal;");
            while (rs.next()) {
                AnimalEntity animal = new AnimalEntity();
                animal.setId(rs.getInt("id"));
                animal.setName(rs.getString("name"));
                animal.setFamily(rs.getString("family"));
                animals.add(animal);
            }
            return animals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AnimalEntity getById(int id){
        try {
            PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM animal WHERE id = ?;");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                AnimalEntity animal = new AnimalEntity();
                animal.setId(rs.getInt("id"));
                animal.setName(rs.getString("name"));
                animal.setFamily(rs.getString("family"));
                return animal;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AnimalEntity insert(AnimalEntity animal){
        try {
            PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(
                    "INSERT INTO  animal (name, family) VALUES (?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmt.setString(1, animal.getName());
            stmt.setString(2, animal.getFamily());
            stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                animal.setId(generatedKeys.getInt(1));
                return animal;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AnimalEntity update(AnimalEntity animalEntity){
        //Metodo no implementado
        return null;
    }

    public void delete(int id){
        try {
            PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM animal WHERE id = ?;");
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
