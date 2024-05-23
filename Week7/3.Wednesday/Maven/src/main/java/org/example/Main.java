package org.example;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class Main {
    public static void main(String[] args) {
        System.setProperty("jansi.passthrough", "true");

        AnsiConsole.systemInstall();

        System.out.println(ansi().fgGreen().a("Hello there!").reset());

        System.out.println(ansi().fgBrightBlue().bold().bgBrightMagenta().a("Hey this is blue bro!").reset());
    }
}