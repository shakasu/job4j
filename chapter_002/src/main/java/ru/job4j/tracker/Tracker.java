package ru.job4j.tracker;

import java.util.Arrays;
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
        for (int i = 0; i <= position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = true;
                newItem.setId(items[i].getId());
                items[i] = newItem;
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
        int delIndex = 0;
        for (int i = 0; i <= position; i++) {
            delIndex++;
            if (items[i] != null && items[i].getId().equals(id)) {
                result = true;
                break;
            }
        }
        System.arraycopy(items, delIndex, items, delIndex - 1, position + 1 - delIndex);
        return result;
    }

    /**
     * Находит массив ячеек с ненулевыми ссылками.
     * @return
     */
    public  Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Находит массив ячеек с одинаковым именем
     * @param key
     * @return
     */
    public  Item[] findByName(String key) {
        Item[] result = new Item[position];
        int i = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[i++] = item;
            }
        }
        return Arrays.copyOf(result, i);
    }

    /**
     * Находит элемент массива items, соответствующий ункальному id.
     * @param id
     * @return
     */
    public  Item findById(String id) {
        Item result = null;
        for (int i = 0; i <= position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
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