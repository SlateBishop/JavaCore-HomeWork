package ru.geekbrains.makulin.three;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> box = new ArrayList<>();
    private T fruit;

    public Box(T fruit) {
        this.fruit = fruit;
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        return box.size() * fruit.getWeight();
    }

    public boolean compare(Box box) {
        return  (getWeight() == box.getWeight());
    }

    public void fruitTransfer(Box<T> fillingBox) {
//не уверен, на сколько правильно такое с точки зрения инкапсуляции, но мне это решение показалось наиболее верным
        fillingBox.box.addAll(this.box);
        this.box.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "box=" + box +
                '}' +
                " Весом " + getWeight();
    }
}
