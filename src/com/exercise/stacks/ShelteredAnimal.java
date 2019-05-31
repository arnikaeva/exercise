package com.exercise.stacks;

import java.util.Date;

public class ShelteredAnimal {
  private Animal animal;

  private Date shelteredDate;

  public ShelteredAnimal(Animal animal) {
    this.animal = animal;
    this.shelteredDate = new Date();
  }

  public Animal getAnimal() {
    return animal;
  }

  public Date getShelteredDate() {
    return shelteredDate;
  }
}
