package services;

import dao.AnimalDao;
import entities.AnimalEntity;
import jakarta.servlet.http.HttpServletResponse;
import util.ApiException;

import java.util.List;

public class AnimalService {

    private AnimalDao animalDao = new AnimalDao();

    public List<AnimalEntity> getAnimals() {
        return animalDao.getAnimals();
    }

    public AnimalEntity getAnimalById(Integer id) throws ApiException{
        if( id == null ) {
            throw ApiException.builder()
                    .code(HttpServletResponse.SC_BAD_REQUEST)
                    .message("Id is required")
                    .build();
        }

        AnimalEntity animal = animalDao.getById(id);
        if( animal == null ) {
            throw ApiException.builder()
                    .code(HttpServletResponse.SC_NOT_FOUND)
                    .message("Animal not found")
                    .build();
        }
        return animal;
    }

    public AnimalEntity insertAnimal(AnimalEntity animalEntity) throws ApiException {
        if (animalEntity.getName() == null || animalEntity.getFamily() == null) {
            throw ApiException.builder()
                    .code(HttpServletResponse.SC_BAD_REQUEST)
                    .message("Required fields are missing.")
                    .build();

        }
        return animalDao.insert(animalEntity);
    }

    public AnimalEntity updateAnimal(AnimalEntity animalEntity) {
        //Metodo no implementado
        return animalDao.update(animalEntity);
    }

    public void deleteAnimal(int id) {
        animalDao.delete(id);
    }
}
