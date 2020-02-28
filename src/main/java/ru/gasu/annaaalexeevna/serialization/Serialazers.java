package ru.gasu.annaaalexeevna.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Serialazers {

    public static void serialize(List<Animal> listOfAnimals, Path path) throws IOException {

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(listOfAnimals);
        }
    }

    public static List<Animal> deserialize(Path path) throws IOException, ClassNotFoundException {
        List<Animal> newAnimalList;
        try (ObjectInputStream inputStream =
                     new ObjectInputStream(Files.newInputStream(path))) {
            newAnimalList = (List<Animal>) inputStream.readObject();
        }
        return newAnimalList;
    }
}
