
package com.villegas.examen_animal.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.villegas.examen_animal.entity.Animal;
import com.villegas.examen_animal.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal crear(Animal animal, String usuario) {
        animal.setCreadoPor(usuario);
        return animalRepository.save(animal);
    }

    public List<Animal> listar() {
        return animalRepository.findByEliminadoFalse();
    }

    public Animal buscarPorId(Long id) {
        return animalRepository.findByIdAndEliminadoFalse(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Animal no encontrado"));
    }

    public Animal actualizar(Long id, Animal datos, String usuario) {
        Animal animal = buscarPorId(id);

        animal.setNombre(datos.getNombre());
        animal.setEspecie(datos.getEspecie());
        animal.setRaza(datos.getRaza());
        animal.setEdad(datos.getEdad());
        animal.setPeso(datos.getPeso());
        animal.setColor(datos.getColor());
        animal.setModificadoPor(usuario);

        return animalRepository.saveAndFlush(animal);
    }

    public void eliminar(Long id, String usuario) {
        Animal animal = buscarPorId(id);

        animal.setEliminado(true);
        animal.setModificadoPor(usuario);

        animalRepository.saveAndFlush(animal);
    }
}
