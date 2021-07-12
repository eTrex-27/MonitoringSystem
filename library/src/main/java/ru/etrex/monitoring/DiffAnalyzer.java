package ru.etrex.monitoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Анализирует разницу между хэш-таблицами (изменение, удаление, добавление)
 */
public class DiffAnalyzer {
    /**
     * Анализирует разницу между хэш-таблицами (изменение, удаление, добавление)
     * @param map1 первая хэш-таблица
     * @param map2 вторая хэш-таблица
     * @return результат анализа
     */
    public static DiffResult run(Map<String, String> map1, Map<String, String> map2) {
        List<String> changedURLs = new ArrayList<>();
        List<String> removedURLs = new ArrayList<>();
        List<String> addedURLs = new ArrayList<>();

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String changedValue = map2.get(entry.getKey());
            if (!entry.getValue().equals(changedValue) && changedValue != null) {
                changedURLs.add(entry.getKey());
            }
            if (changedValue == null) {
                removedURLs.add(entry.getKey());
            }
        }
        for (String key: map2.keySet()) {
            if (!map1.containsKey(key)) {
                addedURLs.add(key);
            }
        }
        Collections.sort(changedURLs);
        Collections.sort(removedURLs);
        Collections.sort(addedURLs);
        return new DiffResult(changedURLs, removedURLs, addedURLs);
    }
}
