package com.example;

import java.util.List;

public interface IFeline {
    int getKittens();
    List<String> getFood(String animalKind) throws Exception;
}
