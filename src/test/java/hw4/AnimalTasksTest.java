package hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AnimalTasksTest {

    private List<Animal> animals;
    @BeforeEach
    void setUp() {
        animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 8, true));
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 15, 2, false));
    }

    @Test
    void testSortAnimalsByHeight() {
        List<Animal> sortedAnimals = AnimalTasks.sortAnimalsByHeight(animals);
        assertEquals("Bird", sortedAnimals.get(0).name());
        assertEquals("Cat", sortedAnimals.get(1).name());
        assertEquals("Dog", sortedAnimals.get(2).name());
    }

    @Test
    void testSortAnimalsByWeight() {
        List<Animal> sortedAnimals = AnimalTasks.sortAnimalsByWeight(2, animals);
        assertEquals("Dog", sortedAnimals.get(0).name());
        assertEquals("Cat", sortedAnimals.get(1).name());
    }

    @Test
    void testCountAnimalsByType() {
        Map<Animal.Type, Integer> typeCount = AnimalTasks.countAnimalsByType(animals);
        assertEquals(1, typeCount.get(Animal.Type.CAT));
        assertEquals(1, typeCount.get(Animal.Type.DOG));
        assertEquals(1, typeCount.get(Animal.Type.BIRD));
    }

    @Test
    void testFindAnimalWithLongestName() {
        Animal animal = AnimalTasks.findAnimalWithLongestName(animals);
        assertEquals("Bird", animal.name());
    }

    @Test
    void testFindMoreCommonSex() {
        Animal.Sex sex = AnimalTasks.findMoreCommonSex(animals);
        assertEquals(Animal.Sex.M, sex);
    }

    @Test
    void testFindHeaviestAnimalOfEachType() {
        Map<Animal.Type, Animal> heaviestAnimals = AnimalTasks.findHeaviestAnimalOfEachType(animals);
        assertEquals("Dog", heaviestAnimals.get(Animal.Type.DOG).name());
        assertEquals("Bird", heaviestAnimals.get(Animal.Type.BIRD).name());
        assertEquals("Cat", heaviestAnimals.get(Animal.Type.CAT).name());
    }

    @Test
    void testFindKthOldestAnimal() {
        Animal animal = AnimalTasks.findKthOldestAnimal(animals, 2);
        assertEquals("Dog", animal.name());
    }

    @Test
    void testFindHeaviestAnimalBelowHeight() {
        Optional<Animal> animal = AnimalTasks.findHeaviestAnimalBelowHeight(animals, 20);
        assertTrue(animal.isPresent());
        assertEquals("Bird", animal.get().name());
    }

    @Test
    void testSumOfPaws() {
        int sum = AnimalTasks.sumOfPaws(animals);
        assertEquals(10, sum);
    }

    @Test
    void testFindAnimalsWithAgeNotMatchingPaws() {
        List<Animal> mismatchedAnimals = AnimalTasks.findAnimalsWithAgeNotMatchingPaws(animals);
        assertEquals(2, mismatchedAnimals.size());
        assertEquals("Cat", mismatchedAnimals.get(0).name());
    }



    @Test
    void testCountAnimalsWithWeightExceedingHeight() {
        int count = AnimalTasks.countAnimalsWithWeightExceedingHeight(animals);
        assertEquals(0, count);
    }

    @Test
    void testFindAnimalsWithMultiWordNames() {
        List<Animal> multiWordNames = AnimalTasks.findAnimalsWithMultiWordNames(animals);
        assertEquals(0, multiWordNames.size());
    }

    @Test
    void testHasBigDog() {
        boolean hasBigDog = AnimalTasks.hasBigDog(animals, 35);
        assertTrue(hasBigDog);
    }

    @Test
    void testSumWeightsOfAnimalsInAgeRange() {
        Map<Animal.Type, Integer> sumWeights = AnimalTasks.sumWeightsOfAnimalsInAgeRange(animals, 2, 5);
        assertEquals(5, sumWeights.get(Animal.Type.CAT));
        assertEquals(8, sumWeights.get(Animal.Type.DOG));
        assertEquals(2, sumWeights.get(Animal.Type.BIRD));
    }

    @Test
    void testSortAnimalsByTypeSexName() {
        List<Animal> sortedAnimals = AnimalTasks.sortAnimalsByTypeSexName(animals);
        assertEquals("Cat", sortedAnimals.get(0).name());
        assertEquals("Dog", sortedAnimals.get(1).name());
        assertEquals("Bird", sortedAnimals.get(2).name());
    }
    @Test
    void testFindHeaviestFishInLists() {
        List<List<Animal>> animalLists = new ArrayList<>();
        animalLists.add(Arrays.asList(
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 2, 5, 3, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 1, 6, 4, false)
        ));
        animalLists.add(Arrays.asList(
            new Animal("Fish3", Animal.Type.FISH, Animal.Sex.M, 3, 7, 5, false)
        ));
        Animal heaviestFish = AnimalTasks.findHeaviestFishInLists(animalLists);
        assertEquals("Fish3", heaviestFish.name());
    }


    @Test
    void testReadableErrors() {
        Map<String, Set<ValidationError>> errors = new HashMap<>();
        errors.put("Dog", new HashSet<>(Arrays.asList(new ValidationError("Name is empty"), new ValidationError("Negative age"))));
        errors.put("Fish", new HashSet<>(Collections.singleton(new ValidationError("Negative weight"))));
        Map<String, String> readableErrors = AnimalTasks.readableErrors(errors);

        assertTrue(readableErrors.containsKey("Dog"));
        assertEquals("Name is empty, Negative age", readableErrors.get("Dog"));

        assertTrue(readableErrors.containsKey("Fish"));
        assertEquals("Negative weight", readableErrors.get("Fish"));
    }

}
