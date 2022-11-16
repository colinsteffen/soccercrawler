package de.colinsteffen.models;

import de.colinsteffen.models.enums.HomeAway;

public class Matchday {
    String team;
    String opponent;
    String address;
    String dateTimeString;
    HomeAway homeAway;

    public Matchday(String team, String opponent, String address, String dateTimeString, HomeAway homeAway) {
        this.team = team;
        this.opponent = opponent;
        this.address = address;
        this.dateTimeString = dateTimeString;
        this.homeAway = homeAway;
    }

    public String getHomeAwayMatch() {
        if(HomeAway.HOME.equals(this.homeAway)) {
            return this.team + " - " + this.opponent;
        } else {
            return this.opponent + " - " + this.team;
        }
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HomeAway getHomeAway() {
        return homeAway;
    }

    public void setHomeAway(HomeAway homeAway) {
        this.homeAway = homeAway;
    }

    public String getDateTimeString() {
        return dateTimeString;
    }

    public void setDateTimeString(String dateTimeString) {
        this.dateTimeString = dateTimeString;
    }
}
