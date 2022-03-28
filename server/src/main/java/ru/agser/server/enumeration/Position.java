package ru.agser.server.enumeration;

public enum Position {
    CLEANER("CLEANER"),
    DIRECTOR("DIRECTOR"),
    COUNSELOR("COUNSELOR"),
    ANIMATOR("ANIMATOR");

    private final String position;

    Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }
}
