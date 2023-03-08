package org.rinatzzak;

import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        MyArrayList<CatForTest> cats = new MyArrayList<>();
        cats.add(new CatForTest(5, "Max"));
        cats.add(new CatForTest(4, "Lisa"));
        cats.add(new CatForTest(7, "Kitty"));
        cats.add(new CatForTest(1, "Barsik"));
        cats.add(new CatForTest(3, "Pushok"));

        System.out.println("Проверяем добавление элементов и выводим созданный список:");
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }

        System.out.println();

        System.out.println("Сортируем наших кошек по возрасту:");
        cats.sort(cats, Comparator.comparingInt(CatForTest::getAge));
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }

        System.out.println();

        System.out.println("Сортируем наших кошек по имени:");
        cats.sort(cats, Comparator.comparing(CatForTest::getName));
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }

        System.out.println();

        System.out.println("Проверяем удаление элемента по индексу:");
        System.out.println("Размер списка до удаления: " + cats.size());
        cats.remove(1);
        System.out.println("Размер списка после удаления элемента: " + cats.size());
        System.out.println("Выводим список для проверки, что элемент удалён:");
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }
        System.out.println();
        System.out.println("Проверяем метод замены элемента по индексу:");
        CatForTest pity = new CatForTest(22, "Vitya");
        cats.set(pity, 2);
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }

        System.out.println();

        System.out.println("Проверяем метод очищения списка");
        System.out.println("Размер списка до очищения: " + cats.size());
        cats.clear();
        System.out.println("Размер списка после очищения: " + cats.size());
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }
    }
}