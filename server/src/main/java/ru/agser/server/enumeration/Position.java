package ru.agser.server.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Position {
    CLEANER("Уборщик"),
    DIRECTOR("Директор"),
    COUNSELOR("Вожатый"),
    ANIMATOR("Аниматор");

    private static final Map<String, Position> positions;

    public static Map<String, Position> getPositions() {
        return positions;
    }

    static {
        positions = new HashMap<>();
        for (Position position : Position.values()) {
            positions.put(position.name, position);
        }
    }
    private final String name;

    Position(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Position fromPositionName(String positionName) {
        return positions.get(positionName);
    }
}
