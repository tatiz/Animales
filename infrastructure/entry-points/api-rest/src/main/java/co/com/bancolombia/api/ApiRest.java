package co.com.bancolombia.api;
import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.usecase.animales.AnimalesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    @GetMapping(path = "/path")
    public String commandName() {
//      return useCase.doAction();
        return "Hello World";
    }

    private final AnimalesUseCase animalesUseCase;

    @GetMapping(path = "/animal/{nombre}")
    public Animales read(@PathVariable String nombre) {
        return animalesUseCase.read(nombre);
    }

    @PostMapping(path = "/animal")
    public void create(@RequestBody Animales animal) {
        animalesUseCase.create(animal);
    }

    @PutMapping(path = "/animal/{nombre}")
    public void update(@PathVariable String nombre, @RequestBody Animales animal) {
        try {
            animalesUseCase.update(nombre, animal);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping(path = "/animal/{nombre}")
    public void delete(@PathVariable String nombre) {
        animalesUseCase.delete(nombre);
    }

    @GetMapping(path = "/animal")
    public List<Animales> getAll() {
        return animalesUseCase.getAll();
    }
}
