package co.com.bancolombia.jpa;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class JpaAnimalesImp implements AnimalesRepository {
    private JPARepositoryAdapter jpaRepositoryAdapter;
    @Override
    public void create(Animales animal) {

        jpaRepositoryAdapter.save(animal);
    }

    @Override
    public Animales read(String nombre) {
        return jpaRepositoryAdapter.findById(nombre);
    }

    @Override
    public Animales update(String nombre, Animales animal) throws Exception {
        Animales animalDb = jpaRepositoryAdapter.findById(nombre);

        if (animalDb == null) throw new Exception("Animal Not Found : " + nombre);

        animalDb.setNombre(animal.getNombre());
        animalDb.setNumPatas(animal.getNumPatas());
        animalDb.setEspecie(animal.getEspecie());
        animalDb.setHabitad(animal.getHabitad());
        if(animal.isMascota()) {
            animalDb.setMascota(true);
        }
        else {
            animalDb.setMascota(false);
        }
        jpaRepositoryAdapter.save(animalDb);
        return animalDb;
    }

    @Override
    public void delete(String nombre) {
        jpaRepositoryAdapter.deleteById(nombre);
    }

    @Override
    public List<Animales> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
}
