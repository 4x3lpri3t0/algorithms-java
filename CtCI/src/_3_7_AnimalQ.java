import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class _3_7_AnimalQ {
    public abstract class Animal {
        private int order;
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public abstract String getName();

        public void setOrder(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    public class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        public String getName() {
            return "Cat: " + name;
        }
    }

    public class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        public String getName() {
            return "Dog: " + name;
        }
    }

    public class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        private int order = 0;

        public void enqueue(Animal a) {
            a.setOrder(order);
            order++;
            if (a instanceof Dog) {
                dogs.addLast((Dog) a);
            } else if (a instanceof Cat) {
                cats.addLast((Cat) a);
            }
        }

        public Animal dequeueAny() {
            if (dogs.size() == 0) {
                return dequeueCats();
            } else if (cats.size() == 0) {
                return dequeueDogs();
            }

            Dog dog = dogs.peek();
            Cat cat = cats.peek();
            if (dog.isOlderThan(cat)) {
                return dogs.poll();
            } else {
                return cats.poll();
            }
        }

        public Animal peek() {
            if (dogs.size() == 0) {
                return cats.peek();
            } else if (cats.size() == 0) {
                return dogs.peek();
            }

            Dog dog = dogs.peek();
            Cat cat = cats.peek();
            if (dog.isOlderThan(cat)) {
                return dog;
            } else {
                return cat;
            }
        }

        public int size() {
            return dogs.size() + cats.size();
        }

        public Dog dequeueDogs() {
            return dogs.poll();
        }

        public Dog peekDogs() {
            return dogs.poll();
        }

        public Cat dequeueCats() {
            return cats.poll();
        }

        public Cat peekCats() {
            return cats.peek();
        }
    }

    public void main() {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("A"));
        animals.enqueue(new Cat("B"));
        animals.enqueue(new Dog("C"));
        animals.enqueue(new Dog("D"));
        animals.enqueue(new Cat("E"));
        animals.enqueue(new Dog("F"));
        animals.enqueue(new Dog("G"));
        animals.enqueue(new Cat("H"));

        out.println(animals.dequeueAny().getName());
        out.println(animals.dequeueAny().getName());
        out.println(animals.dequeueAny().getName());

        animals.enqueue(new Dog("I"));
        animals.enqueue(new Cat("J"));

        while (animals.size() != 0) {
            out.println(animals.dequeueAny().getName());
        }
    }
}