package de.colinsteffen.models.enums;

public enum HomeAway {
    HOME,
    AWAY;

    public String toGermanString() {
        switch (this) {
            case HOME:
                return "Heim";
            case AWAY:
                return "Auswärts";
            default:
                return "UNDEFINED";
        }
    }
}
