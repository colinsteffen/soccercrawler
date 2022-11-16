package de.colinsteffen.actions;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

import static de.colinsteffen.actions.Arguments.HELP_ARGUMENT;

public abstract class CommandAction {
    abstract void printInformationText();
    abstract void getArgumentsAndExecuteCommand(List<String> arguments) throws GeneralSecurityException, IOException;

    public Optional<Exception> handleExecuteAction(List<String> arguments) {
        if(ArgumentsHelper.containsArgument(arguments, HELP_ARGUMENT)) {
            printInformationText();
        } else {
            try {
                getArgumentsAndExecuteCommand(arguments);
            } catch(Exception e) {
                System.out.println(e);
            }
        }

        return Optional.empty();
    }
}
