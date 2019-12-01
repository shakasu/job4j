package ru.job4j.tracker.singleton;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SingletonTest {
    @Test
    public void trackerEnum() {
        TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum newTracker = TrackerSingleEnum.INSTANCE;
        assertThat(tracker, sameInstance(newTracker));
    }

    @Test
    public void trackerStaticField() {
        TrackerSingleStaticField tracker =TrackerSingleStaticField.getInstance();
        TrackerSingleStaticField newTracker =TrackerSingleStaticField.getInstance();
        assertThat(tracker, sameInstance(newTracker));
    }

    @Test
    public void trackerStaticFinalField() {
        TrackerSingleStaticFinalField tracker =TrackerSingleStaticFinalField.getInstance();
        TrackerSingleStaticFinalField newTracker =TrackerSingleStaticFinalField.getInstance();
        assertThat(tracker, sameInstance(newTracker));
    }

    @Test
    public void trackerPrivateStaticFinalClass() {
        TrackerSinglePrivateStaticFinalClass tracker =TrackerSinglePrivateStaticFinalClass.getInstance();
        TrackerSinglePrivateStaticFinalClass newTracker =TrackerSinglePrivateStaticFinalClass.getInstance();
        assertThat(tracker, sameInstance(newTracker));
    }
}