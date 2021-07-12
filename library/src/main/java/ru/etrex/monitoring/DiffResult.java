package ru.etrex.monitoring;

import java.util.List;

/**
 * Класс, содержащий в себе результаты анализа
 */
public class DiffResult {
    private final List<String> changed;
    private final List<String> removed;
    private final List<String> added;

    public DiffResult(List<String> changed, List<String> removed, List<String> added) {
        this.changed = changed;
        this.removed = removed;
        this.added = added;
    }

    public List<String> getChanged() {
        return changed;
    }

    public List<String> getRemoved() {
        return removed;
    }

    public List<String> getAdded() {
        return added;
    }
}
