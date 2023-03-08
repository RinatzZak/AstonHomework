package org.rinatzzak;

public class MyArrayListTestData {

    public static CatForTest maxCat = new CatForTest(5, "Max");
    public static final CatForTest lisaCat = new CatForTest(4, "Lisa");
    public static final CatForTest kittyCat = new CatForTest(7, "Kitty");

    public static final CatForTest barsikCat = new CatForTest(8, "Barsik");
    public static MyArrayList<CatForTest> expected = new MyArrayList<>();

    static {
        expected.add(maxCat);
        expected.add(lisaCat);
        expected.add(kittyCat);
    }
}
