package br.com.guismeiram.aula04.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logHistory;

    private Logger() {
        logHistory = new ArrayList<>();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        String logEntry = "LOG: " + new Date() + " - " + message;
        logHistory.add(logEntry);
        System.out.println(logEntry);
    }

    public void printLogHistory() {
        System.out.println("\n=== Histórico de Log ===");
        for (String log : logHistory) {
            System.out.println(log);
        }
    }

    public void clearLog() {
        logHistory.clear();
        System.out.println("Log limpo.");
    }
}
