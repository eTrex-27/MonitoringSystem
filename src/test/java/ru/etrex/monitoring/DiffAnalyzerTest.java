package ru.etrex.monitoring;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiffAnalyzerTest {
    @Test
    void testRunChangedExist() {
        Map<String, String> yesterday = new HashMap<>();
        Map<String, String> today = new HashMap<>();

        yesterday.put("url1", "html1");
        today.put("url1", "html2");
        DiffResult result = DiffAnalyzer.run(yesterday, today);

        assertEquals(1, result.getChanged().size());
        assertEquals(0, result.getRemoved().size());
        assertEquals(0, result.getAdded().size());
        assertEquals("url1", result.getChanged().get(0));
    }

    @Test
    void testRunChangedEmpty() {
        Map<String, String> yesterday = new HashMap<>();
        Map<String, String> today = new HashMap<>();

        yesterday.put("url1", "html1");
        today.put("url1", "html1");
        DiffResult result = DiffAnalyzer.run(yesterday, today);

        assertEquals(0, result.getChanged().size());
        assertEquals(0, result.getRemoved().size());
        assertEquals(0, result.getAdded().size());
    }

    @Test
    void testRunRemoved() {
        Map<String, String> yesterday = new HashMap<>();
        Map<String, String> today = new HashMap<>();

        yesterday.put("url1", "html1");
        yesterday.put("url2", "html2");
        today.put("url1", "html1");

        DiffResult result = DiffAnalyzer.run(yesterday, today);

        assertEquals(0, result.getChanged().size());
        assertEquals(1, result.getRemoved().size());
        assertEquals(0, result.getAdded().size());
        assertEquals("url2", result.getRemoved().get(0));
    }

    @Test
    void testRunAdded() {
        Map<String, String> yesterday = new HashMap<>();
        Map<String, String> today = new HashMap<>();

        yesterday.put("url1", "html1");
        yesterday.put("url2", "html2");
        today.put("url1", "html1");
        today.put("url2", "html2");
        today.put("url3", "html3");

        DiffResult result = DiffAnalyzer.run(yesterday, today);

        assertEquals(0, result.getChanged().size());
        assertEquals(0, result.getRemoved().size());
        assertEquals(1, result.getAdded().size());
        assertEquals("url3", result.getAdded().get(0));
    }
}
