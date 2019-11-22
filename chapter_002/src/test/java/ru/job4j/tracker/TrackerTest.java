package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void add() {
        //данный метод так же тестирует generateId и findById
        Tracker tracker = new Tracker();
        //создаем экземпляр Item
        Item item = new Item("test1");
        //добавляем его в массив items
        tracker.add(item);
        //ищем в массиве сгенерированный id и ячейку с именем экземплярв
        Item result = tracker.findById(item.getId());
        // сравниваем их
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        // так как метод возвращает массив, то и мы создадим два экземпляра с одинаковыми именами
        Item test1 = new Item("test123");
        tracker.add(test1);
        // а так же один с отличающимся именем
        Item test2 = new Item("test2");
        tracker.add(test2);
        Item test3 = new Item("test123");
        tracker.add(test3);
        //ожидаем массив из экземпляров с одинаковыми именами
        Item[] expected = {test1, test3};
        //генерируем массив проверяемым методом
        Item[] result = tracker.findByName(test1.getName());
        //сравниваем их
        assertThat(result, is(expected));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        //тк метод вернет массив не нулевых элементов, добавим их произвольно
        Item test1 = new Item("test123");
        tracker.add(test1);
        Item test2 = new Item("test2");
        tracker.add(test2);
        Item test3 = new Item("test123");
        tracker.add(test3);
        //ожидаем такой массив
        Item[] expected = {test1, test2, test3};
        //генерируем
        Item[] result = tracker.findAll();
        //сравниваем
        assertThat(result, is(expected));
    }

    @Test
    public void replace() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        // заменяем старый элемент на недобавленный
        tracker.replace(previous.getId(), next);
        // проверяем, что элемент с данным именем и id существует в массиве
        assertThat(tracker.findById(next.getId()).getName(), is("test2"));
    }

    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test1");
        tracker.add(test1);
        Item test2 = new Item("test2");
        tracker.add(test2);
        Item test3 = new Item("test3");
        tracker.add(test3);
        tracker.delete(test2.getId());
        boolean result = tracker.delete(test2.getId());
        //так как мы ожидаем логическую переменную и уменьшения количества
        // ненулевых элементов, то сравним еще длину массива от метода findAll
        boolean expected = tracker.findAll().length == 2;
        assertThat(result, is(expected));
    }
}