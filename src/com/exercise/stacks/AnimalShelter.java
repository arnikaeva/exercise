package com.exercise.stacks;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.exercise.stacks.AnimalType.CAT;
import static com.exercise.stacks.AnimalType.DOG;

public class AnimalShelter {

  List<ShelteredAnimal> cats;
  List<ShelteredAnimal> dogs;

  public AnimalShelter() {
    this.cats = new LinkedList<>();
    this.dogs = new LinkedList<>();
  }

  public void enqueue(Animal animal) {
    switch (animal.getAnimalType()) {
      case CAT:
        this.cats.add(new ShelteredAnimal(animal));
        break;
      case DOG:
        this.dogs.add(new ShelteredAnimal(animal));
        break;
      default:
        throw new UnsupportedOperationException();
    }
  }

  public Animal dequeAny() {
    Animal nextAnimal = null;

    if (this.dogs.isEmpty() && this.cats.isEmpty()) {
      throw new NoSuchElementException();
    } else if (this.dogs.isEmpty()) {
      nextAnimal = dequeueCat();
    } else if (this.cats.isEmpty()) {
      nextAnimal = dequeueDog();
    } else {
      nextAnimal = getOldest();
    }

    return nextAnimal;
  }

  public Animal dequeueDog() {
    Animal nextAnimal = getOldestByType(DOG).getAnimal();
    this.dogs.remove(0);

    return nextAnimal;
  }

  public Animal dequeueCat() {
    Animal nextAnimal = getOldestByType(CAT).getAnimal();
    this.cats.remove(0);

    return nextAnimal;
  }

  private Animal getOldest(){
    ShelteredAnimal oldestDog = getOldestByType(DOG);
    ShelteredAnimal oldestCat = getOldestByType(CAT);

    if (oldestDog.getShelteredDate().before(oldestCat.getShelteredDate())) {
      return dequeueDog();
    } else {
      return dequeueCat();
    }
  }

  private ShelteredAnimal getOldestByType(AnimalType type) {
    switch (type) {
      case CAT:
        return this.cats.get(0);
      case DOG:
        return this.dogs.get(0);
      default:
        throw new UnsupportedOperationException();
    }
  }
}
