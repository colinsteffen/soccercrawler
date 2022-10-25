package de.colinsteffen;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Command {

    MATCHDAY("matchday"),
    RESULTS("results");

    private final String name;

    Command (final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String names() {
        return Arrays.stream(values())
                .map(Command::getName)
                .collect(Collectors.toList())
                .toString();
    }

    public static Command fromString(String name) {
        if(name != null) {
            for(Command c : Command.values()) {
                if (name.equalsIgnoreCase(c.name)) {
                    return c;
                }
            }
        }

        return null;
    }
}
