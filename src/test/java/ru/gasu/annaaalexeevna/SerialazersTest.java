package ru.gasu.annaaalexeevna;

import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SerialazersTest {

    @Test
    public void serializeObject() {
        List<Animal> animalList = new ArrayList<Animal>();
        animalList.add(new Animal("Zebra", TypeOfAnimals.WILD, 12,
                Arrays.asList(new Food("grass", 4))));
        animalList.add(new Animal("Bug", TypeOfAnimals.HOME, 1,
                Arrays.asList(new Food("Leaf", 10))));
        animalList.add(new Animal("Lion", TypeOfAnimals.WILD, 20,
                Arrays.asList(new Food("Zebra", 9))));
        Serializable.serialize
    }
}