package de.colinsteffen.actions;

import java.util.List;
import java.util.Optional;

public class ArgumentsHelper {
    public static Optional<String> getArgument(List<String> arguments, String getArgument) {
        for(int i = 0; i < arguments.size(); i++) {
            if(arguments.get(i).equals(getArgument)) {
                if((i + 1) < arguments.size()) {
                    return Optional.of(arguments.get(i + 1));
                }
            }
        }

        return Optional.empty();
    }

    public static boolean containsArgument(List<String> arguments, String getArgument) {
        for(String argument : arguments) {
            if(argument.equals(getArgument)) {
                return true;
            }
        }

        return false;
    }
}
