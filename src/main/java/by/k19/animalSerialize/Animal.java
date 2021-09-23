package by.k19.animalSerialize;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private static final String FILE_NAME = "animals.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Animal[] animals = new Animal[]{
                new Animal("Elephant"),
                new Animal("Cat"),
                new Animal("Pig"),
                new Animal("Shark")};
        ObjectOutput oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(FILE_NAME)));
        oos.writeInt(animals.length);
        for (Animal animal : animals) {
            oos.writeObject(animal);
        }
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(FILE_NAME)));
        int sizeAnimals = ois.readInt();
        for (int i = 0; i < sizeAnimals; i++) {
            System.out.println((Animal)ois.readObject());
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            int sizeAnimals = ois.readInt();
            Animal[] animals = new Animal[sizeAnimals];
            for (int i = 0; i < sizeAnimals; i++) {
                animals[i] = (Animal) ois.readObject();
            }
            return animals;
        } catch (Exception ignored) {
            throw new IllegalArgumentException();
        }
    }
}