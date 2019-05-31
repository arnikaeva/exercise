package com.exercise.stacks;

public abstract class Animal {

  private String name;
  private AnimalType animalType;

  public Animal(String name, AnimalType animalType) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public AnimalType getAnimalType() {
    return animalType;
  }
}
