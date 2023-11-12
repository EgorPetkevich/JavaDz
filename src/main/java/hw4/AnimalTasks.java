package hw4;

import java.util.*;
import java.util.stream.Collectors;
public class AnimalTasks {
    public static List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    public static List<Animal> sortAnimalsByWeight(int k, List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    public static Map<Animal.Type, Integer> countAnimalsByType(List<Animal> animals) {
        Map<Animal.Type, Integer> typeCount = new HashMap<>();
        for (Animal animal : animals) {
            typeCount.put(animal.type(), typeCount.getOrDefault(animal.type(), 0) + 1);
        }
        return typeCount;
    }

    public static Animal findAnimalWithLongestName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);
    }

    public static Animal.Sex findMoreCommonSex(List<Animal> animals) {
        long maleCount = animals.stream().filter(a -> a.sex() == Animal.Sex.M).count();
        long femaleCount = animals.stream().filter(a -> a.sex() == Animal.Sex.F).count();
        return maleCount > femaleCount ? Animal.Sex.M : Animal.Sex.F;
    }


    public static Map<Animal.Type, Animal> findHeaviestAnimalOfEachType(List<Animal> animals) {
        Map<Animal.Type, Animal> heaviestAnimals = new HashMap<>();
        for (Animal animal : animals) {
            if (!heaviestAnimals.containsKey(animal.type()) ||
                heaviestAnimals.get(animal.type()).weight() < animal.weight()) {
                heaviestAnimals.put(animal.type(), animal);
            }
        }
        return heaviestAnimals;
    }

    public static Animal findKthOldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age))
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    public static Optional<Animal> findHeaviestAnimalBelowHeight(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static int sumOfPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> findAnimalsWithAgeNotMatchingPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .collect(Collectors.toList());
    }

    public static List<Animal> findBitingAnimalsWithHeightOver100(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .collect(Collectors.toList());
    } public static int countAnimalsWithWeightExceedingHeight(List<Animal> animals) {
        return (int) animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    public static List<Animal> findAnimalsWithMultiWordNames(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }

    public static boolean hasBigDog(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> sumWeightsOfAnimalsInAgeRange(List<Animal> animals, int k, int l) {
        Map<Animal.Type, Integer> sumWeights = new HashMap<>();
        for (Animal animal : animals) {
            if (animal.age() >= k && animal.age() <= l) {
                sumWeights.put(animal.type(), sumWeights.getOrDefault(animal.type(), 0) + animal.weight());
            }
        }
        return sumWeights;
    }

    public static List<Animal> sortAnimalsByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    public static boolean doSpidersBiteMoreThanDogs(List<Animal> animals) {
        long spiderCount = animals.stream().filter(animal -> animal.type() == Animal.Type.SPIDER).count();
        long dogCount = animals.stream().filter(animal -> animal.type() == Animal.Type.DOG).count();
        if (spiderCount == 0 || dogCount == 0) {
            return false;
        }

        long spiderBiteCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER)
            .filter(Animal::bites)
            .count();
        long dogBiteCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .filter(Animal::bites)
            .count();

        return (double) spiderBiteCount / spiderCount > (double) dogBiteCount / dogCount;
    }

    public static Animal findHeaviestFishInLists(List<List<Animal>> animalLists) {
        return animalLists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }


    public static Map<String, Set<ValidationError>> findAnimalsWithErrors(List<Animal> animals) {
        Map<String, Set<ValidationError>> animalsWithErrors = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = new HashSet<>();
            if (animal.name().isEmpty()) {
                errors.add(new ValidationError("Name is empty"));
            }
            if (animal.age() < 0) {
                errors.add(new ValidationError("Negative age"));
            }
            if (animal.weight() < 0) {
                errors.add(new ValidationError("Negative weight"));
            }
            animalsWithErrors.put(animal.name(), errors);
        }
        return animalsWithErrors;
    }


    public static Map<String, String> readableErrors(Map<String, Set<ValidationError>> animalsWithErrors) {
        Map<String, String> readableErrors = new HashMap<>();

        for (Map.Entry<String, Set<ValidationError>> entry : animalsWithErrors.entrySet()) {
            String animalName = entry.getKey();
            Set<ValidationError> errors = entry.getValue();

            String errorString = errors.stream()
                .map(ValidationError::getErrorDescription)
                .collect(Collectors.joining(", "));

            readableErrors.put(animalName, errorString);
        }
        return readableErrors;
    }




    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false));
        animals.add(new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 8, true));
        animals.add(new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 15, 2, false));


        Map<Animal.Type, Integer> typeCount = countAnimalsByType(animals);
        System.out.println("Количество животных каждого вида: " + typeCount);

        Animal animalWithLongestName = findAnimalWithLongestName(animals);
        System.out.println("Животное с самым длинным именем: " + animalWithLongestName.name());
    }
}
