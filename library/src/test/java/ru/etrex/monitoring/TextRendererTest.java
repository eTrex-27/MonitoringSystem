package ru.etrex.monitoring;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextRendererTest {
    @Test
    void testRunRemoved() {
        DiffResult result = new DiffResult(Collections.emptyList(), Collections.singletonList("url1"), Collections.emptyList());

        String textResult = TextRenderer.run(result);
        assertTrue(textResult.contains("Исчезли следующие страницы: [url1]"));
    }

    @Test
    void testRunAdded() {
        DiffResult result = new DiffResult(Collections.emptyList(), Collections.emptyList(), Collections.singletonList("url3"));

        String textResult = TextRenderer.run(result);
        assertTrue(textResult.contains("Появились следующие новые страницы: [url3]"));
    }

    @Test
    void testRunChanged() {
        DiffResult result = new DiffResult(Collections.singletonList("url2"), Collections.emptyList(), Collections.emptyList());

        String textResult = TextRenderer.run(result);
        assertTrue(textResult.contains("Изменились следующие страницы: [url2]"));
    }
}
