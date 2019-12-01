package ru.job4j.tracker.singleton;

public class TrackerSinglePrivateStaticFinalClass {

    private TrackerSinglePrivateStaticFinalClass() {
    }

    public static TrackerSinglePrivateStaticFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSinglePrivateStaticFinalClass INSTANCE = new TrackerSinglePrivateStaticFinalClass();
    }
}