package org.rinatzzak;

import java.util.Comparator;

public class MyArrayList<T> {
    private final int INIT_CAPACITY = 10;
    private int size = 0;
    private Object[] array;

    public MyArrayList() {
        this.array = new Object[INIT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.array = new Object[capacity];
    }

    /**
     * Метод для добавления элемента в MyArrayList.
     * Если количество данных больше, чем ёмкость массива, то увеличиваем ёмкость массива
     * Элемент добавляется в конец массива. Увеличиваем ёмкость на единицу.
     * @param element - элемент, который необходимо добавить в список
     */
    public void add(T element) {
        if (size >= array.length) {
            increaseCapacity();
        }
        array[size] = element;
        size++;
    }

    /**
     * Метод для получения элемента по заданному индексу.
     * Проверяем индекс на валидность и если удовлетворяет условиям, то
     * возвращаем элемент из массива.
     * @param index - позиция, занимаемая элементом, в массиве, который нужно вернуть
     * @return - возвращаем элемент массива.
     */
    public T get(int index) {
        checkIndexValid(index);
        return (T) array[index];
    }

    /**
     * Метод для получения количества элементов в MyArrayList
     * @return - int, количество элементов в списке.
     */
    public int size() {
        return size;
    }

    /**
     * Метод для удаления элемента из массива по заданному индексу.
     * Проверяем индекс на валидность и если удовлетворяет условиям, то:
     * создаем новый массив, с размером, меньшим на единицу
     * копируем левую часть массива в новый массив до указанного индекса
     * копируем правую часть массива в новый массив после указанного индекса
     * @param index - int, позиция элемента в массиве, который нужно удалить
     */
    public void remove(int index) {
        checkIndexValid(index);
        Object[] tempArray = array;
        array = new Object[tempArray.length - 1];
        System.arraycopy(tempArray, 0, array, 0, index);
        System.arraycopy(tempArray, index + 1, array, index, tempArray.length - index - 1);
        size--;
    }

    /**
     * Метод для сортировки списка.
     * Для сортировки используется кастомная quickSort. Ознакомиться с ней можно ниже.
     * Определяем нижнюю границу и верхнюю границу для сортировки и вызываем метод quickSort
     * @param arrayList - входной список для сортировки
     * @param comparator - входной Comparator для обозначения по каким параметрам нужна сортировка
     */
    public void sort(MyArrayList<T> arrayList, Comparator<T> comparator) {
        int low = 0;
        int high = arrayList.size() - 1;
        quickSort(arrayList, low, high, comparator);
    }

    /**
     * Метод для полного очищения списка
     * Проходим по всему массиву через цикл for и каждому элементу присваиваем значение null
     * Размер массива устанавливаем 0.
     */
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
            size = 0;
        }
    }

    /**
     * Метод для замены элемента в указанной позиции в этом списке указанным элементом.
     * Проверяем индекс на валидность и если удовлетворяет условиям, то:
     * присваиваем место в массиве с указанным индексом входному элементу.
     * @param e - входной элемент, который необходимо вставить в массив
     * @param index - входная позиция в массив, которую нужно заменить в массиве входным элементом.
     */
    public void set(T e, int index) {
        checkIndexValid(index);
        array[index] = e;
    }

    /**
     * Приватный метод для увеличения ёмкости массива
     * Создаем новый массив с ёмкостью, увеличенной в 2 раза от необходимого массива
     * Копируем все элементы в новый массив
     */
    private void increaseCapacity() {
        Object[] increasedArray = new Object[(array.length * 2)];
        System.arraycopy(array, 0, increasedArray, 0, array.length);
        array = increasedArray;
    }

    /**
     * Приватный метод для проверки входного индекса
     * Если индекс больше размера массива или меньше нуля, то выбрасывается исключение.
     * @param index - входной индекс для проверки
     */
    private void checkIndexValid(int index) {
        if (index >= array.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Метод быстрой сортировки для MyArrayList<T>, который принимает и сортирует MyArrayList любого типа.
     * В данной реализации используется Comparator<T> comparator для сравнивания различных типов.
     * @param arrayList - входной список для сортировки
     * @param low - нижняя граница массива
     * @param high - верхняя граница массива
     * @param comparator - Comparator<T> comparator, для обозначения, по какому признаку проводить сортировку
     * @param <T> - тип элементов, входящих в список для сортировки
     */
    private static <T> void quickSort(MyArrayList<T> arrayList, int low, int high, Comparator<T> comparator) {
        //создаем две переменные для обозначения индекса, leftIndex ставится на начало массива,
        // rightIndex ставится на конец массива
        int leftIndex = low;
        int rightIndex = high;

        // Завершаем выполнение, если длина массива равна 0
        if (arrayList.size == 0) {
            return;
        }

        // Завершаем выполнение, если начальный элемент больше или равен конечному элементу.
        if (low >= high) {
            return;
        }

        // Находим опорный элемент (pivot) для того, чтобы разделить массив на две части.
        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        T pivot = arrayList.get(mid);

        // Делим массив на две части, используя pivot. Одна часть меньше pivot, вторая больше.
        while (leftIndex <= rightIndex) {
            //Идём сначала массива, сравнивая чем comparator, пока не найдем элемент больше опорного
            while (comparator.compare(arrayList.get(leftIndex), pivot) < 0) {
                leftIndex++;
            }
            //Идём с конца массива, сравнивая через comparator, пока не найдем элемент меньше опорного
            while (comparator.compare(arrayList.get(rightIndex), pivot) > 0) {
                rightIndex--;
            }
            // После того как найдены 2 элемента, которые больше и меньше опоры(pivot) соответственно, меняем их местами
            if (leftIndex <= rightIndex) {
                T temp = arrayList.get(leftIndex);
                arrayList.set(arrayList.get(rightIndex), leftIndex);
                arrayList.set(temp, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }

        // Рекурсивно вызываем метод для сортировки полученных подмассивов
        if (low < rightIndex) {
            quickSort(arrayList, low, rightIndex, comparator);
        }
        if (high > leftIndex) {
            quickSort(arrayList, leftIndex, high, comparator);
        }
    }
}
