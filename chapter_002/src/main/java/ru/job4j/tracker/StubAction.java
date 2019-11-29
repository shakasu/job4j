package ru.job4j.tracker;

public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public int key() {
        return 0;
    }

    @Override
    public String info() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}