package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private List<Item> items = new ArrayList<>();

    /**
     * Метод add присваивает ячейке массива items новое значение.
     * Происхоит генерация уникального id и сдвигается счетчик position.
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
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
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                result = true;
                newItem.setId(id);
                items.set(i, newItem);
                break;
            }
        }
        return result;
    }

    /**
     *Метод находит по Id выбранную пользователем ячейку.
     *Считает ее положение в массиве items.
     *Удаляет ячейку и копирует часть массива после удаленного
     *элемента на место удаленного.
     *в методе System.arraycopy последний параметр отвечает за
     *колличество скопированных элементов и "+ 1" необходим,
     *чтобы заменить нулевой ссылкой последний элемент переноса.
     *False возможен при неподходящем id.
     * @param id
     * @return
     */
    public  boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                result = true;
                items.remove(i);
                break;
            }
        }
        return result;
    }

    /**
     * Находит массив ячеек с ненулевыми ссылками.
     * @return
     */
    public  List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            result.add(item);
        }
        return result;
    }

    /**
     * Находит массив ячеек с одинаковым именем
     * @param key
     * @return
     */
    public  List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
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
            if (item.getId().equals(id)) {
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