package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Было профилировано приложение Tracker, используя утилиту jconsole.
 * 1) Обычный запуск приложения (без изменения кода и без ключей запуска VM):
 * память запоняется пилообразно до 80мб, каждый спад обусловлен работой minor GC,
 * нагрузка на CPU была 3% на старте и крайне близка к 0.01% в течении всей работы,
 * 2) Запуск с циклом (при выводе каждого пункта меню 1000 раз создавался "мусорный" объект Tracker)
 * Заполнение памяти больше не выглядит системно (колебания вплоть до 400мб),
 * количество загружаемых классов не выросла (что ожидаемо),
 * нагрузка на CPU возрасла до 30%
 * 3) Запуск с циклом в цикле (при выводе элемента меню вызывался цикл в цикле на создание "мусорного" Tracker, 1kkk итераций в каждом)
 * память заполняется ступеньчато (с частыми колебаниями, крайняя тупень вплоть до 1.1gb),
 * нагрузка на процессор колебалась вплоть до 35%, но в среднем была 25%
 * Во всех трех запусках не удалось выйти за пределы памяти.
 * Однако приложение с ключами -Xms3m -Xmx5m, ограничивающие максимальный размер кучи быстро выходит за пределы с модифицированным кодом.
 */

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        boolean run = true;
        while (run) {
            menu.show();
            run = menu.select(input.askInt("Select: ", menu.size()));
        }
    }

    public static void main(String[] args) {
       new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}