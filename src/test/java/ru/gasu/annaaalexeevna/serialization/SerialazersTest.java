package ru.gasu.annaaalexeevna.serialization;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SerialazersTest {

    @Test
    public void serializeObject() throws IOException, ClassNotFoundException {
        List<Animal> animalList = new ArrayList<Animal>();
        animalList.add(new Animal("Zebra", TypeOfAnimals.WILD, 12,
                Arrays.asList(new Food("grass", 4))));
        animalList.add(new Animal("Bug", TypeOfAnimals.HOME, 1,
                Arrays.asList(new Food("Leaf", 10))));
        animalList.add(new Animal("Lion", TypeOfAnimals.WILD, 20,
                Arrays.asList(new Food("Zebra", 9))));

        Serialazers.serialize(animalList, Paths.get("object.bin1"));

        assertEquals(animalList, Serialazers.deserialize(Paths.get("object.bin")));
    }

    @Test
    public void serializeObjectEmpty() throws IOException, ClassNotFoundException {
        Serialazers.serialize(Collections.emptyList(), Paths.get("object.bin"));
        assertEquals(Collections.emptyList(), Serialazers.deserialize(Paths.get("object.bin")));
    }

    @Test
    public void serializeObjectTwoLists() throws IOException, ClassNotFoundException {
        List<Animal> animalList1 = new ArrayList<Animal>();
        animalList1.add(new Animal("Zebra", TypeOfAnimals.WILD, 12,
                Arrays.asList(new Food("grass", 4))));
        animalList1.add(new Animal("Bug", TypeOfAnimals.HOME, 1,
                Arrays.asList(new Food("Leaf", 10))));
        animalList1.add(new Animal("Lion", TypeOfAnimals.WILD, 20,
                Arrays.asList(new Food("Zebra", 9))));

        List<Animal> animalList2 = new ArrayList<Animal>();
        animalList2.add(new Animal("Lion", TypeOfAnimals.WILD, 21,
                Arrays.asList(new Food("Leaf", 4))));
        animalList2.add(new Animal("Zebra", TypeOfAnimals.HOME, 1,
                Arrays.asList(new Food("Bug", 10))));
        animalList2.add(new Animal("Lion", TypeOfAnimals.WILD, 20,
                Arrays.asList(new Food("Zebra", 9))));
        Serialazers.serialize(animalList1, Paths.get("object.animal1"));
        Serialazers.serialize(animalList2, Paths.get("object.animal2"));
        assertNotEquals(animalList1, Serialazers.deserialize(Paths.get("object.animal2")));
        assertNotEquals(animalList2, Serialazers.deserialize(Paths.get("object.animal1")));
    }

    @Test
    public void serializeObjectError() throws ClassNotFoundException{
        try {
            Serialazers.deserialize(Paths.get("emptytest"));
            fail();
        } catch (NoSuchFileException e) {

        } catch (IOException e) {
            fail();
        }
    }
}