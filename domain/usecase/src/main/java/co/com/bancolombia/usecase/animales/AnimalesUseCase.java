package co.com.bancolombia.usecase.animales;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AnimalesUseCase {
    private AnimalesRepository animalRepository;

    public void create(Animales animal){
        animalRepository.create(animal);
    }
    public Animales read(String nombre){
        return animalRepository.read(nombre);
    }
    public void update(String nombre, Animales animal) throws Exception{
        animalRepository.update(nombre, animal);
    }
    public void delete(String nombre){
        animalRepository.delete(nombre);
    }
    public List<Animales> getAll(){
        return animalRepository.getAll();
    }

}
