package ru.etrex.monitoring;

import java.util.List;

/**
 * Генерирует сообщение пользователю об изменениях урлов
 */
public class TextRenderer {

    private static final String Template = "Здравствуйте, дорогая и.о. секретаря\r\n" +
            "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\r\n" +
            "\r\n" +
            "Исчезли следующие страницы: {REMOVED}\r\n" +
            "Появились следующие новые страницы: {ADDED}\r\n" +
            "Изменились следующие страницы: {CHANGED}\r\n" +
            "\r\n" +
            "С уважением,\r\n" +
            "автоматизированная система\r\n" +
            "мониторинга.";

    public static String run(DiffResult result) {
        String message = Template;
        message = replaceText(result.getRemoved(), "{REMOVED}", "нет исчезнувших урлов", message);
        message = replaceText(result.getAdded(), "{ADDED}", "нет добавленных урлов", message);
        message = replaceText(result.getChanged(), "{CHANGED}", "нет изменённых урлов", message);
        return message;
    }

    private static String replaceText(List<String> result, String placeholder, String nullMessage, String newMessage) {
        if (result.size() != 0) {
            newMessage = newMessage.replace(placeholder, result.toString());
        }
        else {
            newMessage = newMessage.replace(placeholder, nullMessage);
        }
        return newMessage;
    }
}
