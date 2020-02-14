package ru.gasu.annaaalexeevna;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Serialazers {

    public void serialize(List<Animal> listOfAnimals, Path path) throws IOException {
        path = Paths.get("object.bin");
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(listOfAnimals);
        }
    }

    public List<Animal> deserialize(Path path) throws IOException, ClassNotFoundException {
        List<Animal> newAnimalList;
        try (ObjectInputStream inputStream =
                     new ObjectInputStream(Files.newInputStream(path))) {
            newAnimalList = (List<Animal>) inputStream.readObject();
        }
        return newAnimalList;
    }
}
