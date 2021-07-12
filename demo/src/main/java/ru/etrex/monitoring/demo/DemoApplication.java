package ru.etrex.monitoring.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.etrex.monitoring.DiffAnalyzer;
import ru.etrex.monitoring.DiffResult;
import ru.etrex.monitoring.TextRenderer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
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
