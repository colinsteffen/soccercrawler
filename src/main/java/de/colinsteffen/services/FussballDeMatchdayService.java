package de.colinsteffen.services;

import de.colinsteffen.helpers.StringHelper;
import de.colinsteffen.models.Matchday;
import de.colinsteffen.models.enums.HomeAway;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FussballDeMatchdayService {

    private final String teamUrl;
    private final String team;

    public FussballDeMatchdayService(String teamUrl, String team) {
        this.teamUrl = teamUrl;
        this.team = team;
    }

    public Matchday load() {
        try {
            Document doc = Jsoup.connect(teamUrl).get();
            Elements elements = doc.getElementsByClass("team-home");

            String homeTeam = StringHelper.removeEncoding(elements.get(1).text());
            String awayTeam = StringHelper.removeEncoding(elements.get(0).text());
            String matchdayLink = getMatchdayLink(doc);
            String matchdayDateTimeString = getMatchdayDateTimeString(matchdayLink);
            String matchdayAddress = getMatchdayAddress(matchdayLink);
            if(homeTeam.trim().equalsIgnoreCase(team.trim())) {
                return new Matchday(team, awayTeam, matchdayAddress, matchdayDateTimeString, HomeAway.HOME);
            } else {
                return new Matchday(team, homeTeam, matchdayAddress, matchdayDateTimeString, HomeAway.AWAY);
            }
        } catch(Exception e) {
            System.out.println("Could not load matchday: " + e);
            return null;
        }
    }

    private String getMatchdayDateTimeString(String matchdayLink) {
        try {
            Document docMatch = Jsoup.connect(matchdayLink).get();
            Element elements = docMatch.getElementsByClass("container contact-form form-small").get(0);
            Element element12 = elements.child(0).child(3).getElementsByAttribute("value").get(0);
            String s = element12.attr("value");
            return s.substring(s.length() - 16);
        } catch(Exception e) {
            return "";
        }
    }

    private String getMatchdayAddress(String matchdayLink) {
        try {
            Document docMatch = Jsoup.connect(matchdayLink).get();
            Elements elements = docMatch.getElementsByClass("match-stage");
            Element elements1 = elements.get(0).getElementsByAttribute("href").get(3);
            return elements1.text();
        } catch(Exception e) {
            return "";
        }
    }

    private String getMatchdayLink(Document baseDoc) {
        Element element = baseDoc.getElementById("id-team-matchplan-table");
        Elements elementsDetail = element.getElementsByClass("column-detail");
        return elementsDetail.get(0).child(0).attr("href");
    }
}
