package de.colinsteffen;

import com.google.common.collect.ImmutableMap;
import de.colinsteffen.actions.CommandAction;
import de.colinsteffen.actions.MatchdayAction;
import de.colinsteffen.actions.ResultsAction;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class CommandClient {
    private final Map<Command, Function<List<String>, Optional<Exception>>> actionHandlers;
    CommandAction matchdayAction;
    CommandAction resultsAction;

    public CommandClient() {
        this.matchdayAction = new MatchdayAction();
        this.resultsAction = new ResultsAction();

        actionHandlers = ImmutableMap.<Command, Function<List<String>, Optional<Exception>>>builder()
                .put(Command.MATCHDAY, matchdayAction::handleExecuteAction)
                .put(Command.RESULTS, resultsAction::handleExecuteAction)
                .build();
    }

    public void execute(Command action, List<String> arguments) {
        actionHandlers.getOrDefault(action, this::handleUnknownCommand)
                .apply(arguments)
                .ifPresent(Throwable::printStackTrace);
    }

    private Optional<Exception> handleUnknownCommand(List<String> arguments) {
        System.out.println("Command not found. Please use ohne of the following commands: " + Command.names() + ".");
        return Optional.empty();
    }
}
