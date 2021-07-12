package ru.etrex.monitoring.demo;

import ru.etrex.monitoring.DiffAnalyzer;
import ru.etrex.monitoring.DiffResult;
import ru.etrex.monitoring.TextRenderer;

import java.util.HashMap;
import java.util.Map;

public class DemoApplication {
    public static void main(String[] args) {
        Map<String, String> yesterday = new HashMap<>();
        Map<String, String> today = new HashMap<>();

        yesterday.put("url1", "html1");
        yesterday.put("url2", "html1");
        today.put("url2", "html2");
        today.put("url3", "html3");

        DiffResult result = DiffAnalyzer.run(yesterday, today);
        String body = TextRenderer.run(result);
        System.out.println(body);
    }
}
