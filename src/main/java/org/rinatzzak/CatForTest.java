package org.rinatzzak;


/**
 * Класс CatForTest создан для тестирования методов и быстрой сортировки класса MyArrayList,
 * созданы поля int age и String name, так же геттеры, переопределен метод @ToString
 * и метод интерфейса Comparable - compareTo
 * Класс имплементирует интерфейс Comparable для использования быстрой сортировки.
 * Указан Comparable<CatForTest>, так как интерфейс Comparable является типизированным
 */
public class CatForTest implements Comparable<CatForTest> {
    private final int age;
    private final String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public CatForTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat: " + "age = " + age +
                ", name = " + name;
    }

    @Override
    public int compareTo(CatForTest o) {
        return this.age - o.getAge();
    }
}
