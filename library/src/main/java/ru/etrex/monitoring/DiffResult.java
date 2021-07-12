package ru.etrex.monitoring;

import lombok.Value;

import java.util.List;

/**
 * Класс, содержащий в себе результаты анализа
 */
@Value
public class DiffResult {
    List<String> changed;
    List<String> removed;
    List<String> added;
}
