package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    /**
     * Метод add присваивает ячейке массива items новое значение.
     * Происхоит генерация уникального id и сдвигается счетчик position.
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод replace проверяет возможность замены ячейки массива items.
     * А так же заменяет ее на новый элемент типа Item.
     * False возможен при неподходящем id.
     * 38 строчка присваивает старой ячейке имя новой.
     * 39 строчка почему-то не может присвоить имя.
     * Почему 39 строчка не работает?
     * @param id
     * @param newItem
     * @return
     */
    public boolean replace(String id, Item newItem) {
        boolean result = false;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = true;
                newItem.setId(item.getId());
                item.setName(newItem.getName());
                //item = newItem;
                break;
            }
        }
        return result;
    }

    /**
     *Метод находит по Id выбранную пользователем ячейку.
     *Считает ее положение в массиве items.
     *Удаляет ячейку и сдвигает null в конец массива.
     *False возможен при неподходящем id.
     * @param id
     * @return
     */
    public  boolean delete(String id) {
        boolean result = false;
        int delIndex = 0;
        for (Item item : items) {
            delIndex++;
            if (item != null && item.getId().equals(id)) {
                result = true;
                break;
            }
        }
        if (result) {
            items[delIndex - 1] = null;
            for (int i = 0; i < items.length - 1; i++) {
                items[i] = items[i + 1];
            }
            items[items.length - 1] = null;
        }
        return result;
    }

    /**
     * Находит массив ячеек с ненулевыми ссылками.
     * @return
     */
    public  Item[] findAll() {
        int indexNotNull = 0;
        int i = 0;
        for (Item item : items)  {
            if (item != null) {
                indexNotNull++;
            }
        }
        Item[] result = new Item[indexNotNull];
        for (Item item : items) {
            if (item != null) {
                result[i++] = item;
            }
        }
        return result;
    }

    /**
     * Находит массив ячеек с одинаковым именем
     * @param key
     * @return
     */
    public  Item[] findByName(String key) {
        int indexKey = 0;
        int i = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                indexKey++;
            }
        }
        Item[] result = new Item[indexKey];
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[i++] = item;
            }
        }
        return result;
    }

    /**
     * Находит элемент массива items, соответствующий ункальному id.
     * @param id
     * @return
     */
    public  Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Генерирует уникальное число через сумму случайного числа и текущей даты.
     * @return
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}