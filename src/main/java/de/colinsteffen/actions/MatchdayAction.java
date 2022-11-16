package de.colinsteffen.actions;

import de.colinsteffen.models.Matchday;
import de.colinsteffen.services.FussballDeMatchdayService;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.util.List;

public class MatchdayAction extends CommandAction {

    private static final String MATCHDAY_BASE_URL = "https://www.fussball.de/mannschaft/";
    private static final ImmutablePair<String, String> MATCHDAY_TEAM_1_URL =
            new ImmutablePair<>("https://www.fussball.de/mannschaft/sg-fa-herringhs-eickum-sg-fa-herringhs-eickum-westfalen/-/saison/2223/team-id/011MIC7JCK000000VTVG0001VTR8C1K7#!/", "SG FA Herringhs./Eickum");
    private static final ImmutablePair<String, String> MATCHDAY_TEAM_2_URL =
            new ImmutablePair<>("sg-fa-herringhs-eickum-ii-sg-fa-herringhs-eickum-westfalen/-/saison/2223/team-id/011MIBN908000000VTVG0001VTR8C1K7#!/", "SG FA Herringhs./Eickum II");
    private static final ImmutablePair<String, String> MATCHDAY_TEAM_3_URL =
            new ImmutablePair<>("https://www.fussball.de/mannschaft/sg-fa-herringhs-eickum-iii-sg-fa-herringhs-eickum-westfalen/-/saison/2223/team-id/011MIBMVLG000000VTVG0001VTR8C1K7#!/", "SG FA Herringhs./Eickum III");
    private static final ImmutablePair<String, String> MATCHDAY_TEAM_WOMEN_URL =
            new ImmutablePair<>("https://www.fussball.de/mannschaft/sg-fa-herringhs-eickum-sg-fa-herringhs-eickum-westfalen/-/saison/2223/team-id/021M09HLLC000000VS548984VVV9AQPN#!/", "SG FA Herringhs./Eickum");

    @Override
    void printInformationText() {
        System.out.println();
    }

    @Override
    void getArgumentsAndExecuteCommand(List<String> arguments) throws IOException {
        Matchday matchdayErste = new FussballDeMatchdayService(MATCHDAY_BASE_URL + MATCHDAY_TEAM_1_URL.getLeft(), MATCHDAY_TEAM_1_URL.getRight())
                .load();
        printMatchday(matchdayErste);

        Matchday matchdayZweite = new FussballDeMatchdayService(MATCHDAY_BASE_URL + MATCHDAY_TEAM_2_URL.getLeft(), MATCHDAY_TEAM_2_URL.getRight())
                .load();
        printMatchday(matchdayZweite);

        Matchday matchdayDritte = new FussballDeMatchdayService(MATCHDAY_BASE_URL + MATCHDAY_TEAM_3_URL.getLeft(), MATCHDAY_TEAM_3_URL.getRight())
                .load();
        printMatchday(matchdayDritte);

        Matchday matchdayFrauen = new FussballDeMatchdayService(MATCHDAY_BASE_URL + MATCHDAY_TEAM_WOMEN_URL.getLeft(), MATCHDAY_TEAM_WOMEN_URL.getRight())
                .load();
        printMatchday(matchdayFrauen);
    }

    private void printMatchday(Matchday matchday) {
        System.out.println(matchday.getTeam());
        System.out.println("   " + matchday.getHomeAway().toGermanString() + ": " + matchday.getHomeAwayMatch());
        System.out.println("   " + matchday.getDateTimeString() + " - " + matchday.getAddress());
    }
}
