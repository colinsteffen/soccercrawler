package de.colinsteffen;

import java.util.Arrays;
import java.util.List;

public class CommandRunner {
    public static void main(String[] args) {
        if(args.length == 0) {
            throw new IllegalArgumentException("Command not found. Please use one of the following: " + Command.names() + ".");
        } else {
            List<String> argumensWithoutFirst = Arrays.asList(args).subList(1, args.length);
            new CommandClient().execute(Command.fromString(args[0]), argumensWithoutFirst);
        }
    }
}
