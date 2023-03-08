package org.rinatzzak;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.rinatzzak.MyArrayListTestData.*;

class MyArrayListTest {
    @Test
    void add() {
        MyArrayList<CatForTest> cats = new MyArrayList<>();
        cats.add(maxCat);
        cats.add(lisaCat);
        cats.add(kittyCat);

        CatForTest one = cats.get(0);
        CatForTest two = cats.get(1);
        CatForTest three = cats.get(2);
        assertThat(cats.size(), equalTo(expected.size()));
        assertThat(one, hasProperty("name", equalTo("Max")));
        assertThat(two, hasProperty("name", equalTo("Lisa")));
        assertThat(three, hasProperty("name", equalTo("Kitty")));

    }

    @Test
    void testAddWithIndex() {
        MyArrayList<CatForTest> catsForAdd = new MyArrayList<>();
        catsForAdd.add(maxCat);
        catsForAdd.add(lisaCat);
        catsForAdd.add(0, barsikCat);
        CatForTest barsik = catsForAdd.get(0);
        CatForTest max = catsForAdd.get(1);
        CatForTest lisa = catsForAdd.get(2);
        assertThat(barsik, hasProperty("name", equalTo("Barsik")));
        assertThat(max, hasProperty("name", equalTo("Max")));
        assertThat(lisa, hasProperty("name", equalTo("Lisa")));
    }

    @Test
    void get() {
        CatForTest cat = expected.get(1);
        assertThat(cat, hasProperty("name", equalTo("Lisa")));
    }

    @Test
    void size() {
        assertThat(expected.size(), equalTo(3));
    }

    @Test
    void remove() {
        MyArrayList<CatForTest> catsTest = new MyArrayList<>();
        catsTest.add(maxCat);
        catsTest.add(lisaCat);
        catsTest.add(kittyCat);

        catsTest.remove(0);

        CatForTest one = catsTest.get(0);
        CatForTest two = catsTest.get(1);
        CatForTest three = catsTest.get(2);

        assertThat(catsTest.size(), equalTo(2));
        assertThat(one, hasProperty("name", equalTo("Lisa")));
        assertThat(two, hasProperty("name", equalTo("Kitty")));
    }

    @Test
    void sort() {
        MyArrayList<CatForTest> catsTestSort = new MyArrayList<>();
        catsTestSort.add(maxCat);
        catsTestSort.add(lisaCat);
        catsTestSort.add(kittyCat);

        catsTestSort.sort(catsTestSort, Comparator.comparingInt(CatForTest::getAge));
        CatForTest one = catsTestSort.get(0);
        CatForTest two = catsTestSort.get(1);
        CatForTest three = catsTestSort.get(2);
        assertThat(one, hasProperty("name", equalTo("Lisa")));
        assertThat(two, hasProperty("name", equalTo("Max")));
        assertThat(three, hasProperty("name", equalTo("Kitty")));
    }

    @Test
    void clear() {
        expected.clear();
        assertThat(expected.size(), equalTo(0));
    }

    @Test
    void set() {
        MyArrayList<CatForTest> catsTestSet = new MyArrayList<>();
        catsTestSet.add(maxCat);
        catsTestSet.add(lisaCat);
        catsTestSet.set(barsikCat, 0);
        CatForTest cat = catsTestSet.get(0);
        assertThat(cat, hasProperty("name", equalTo("Barsik")));
    }
}