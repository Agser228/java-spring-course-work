package ru.agser.server.security;

public enum UserPermission {
    CHILD_READ("child:read"),
    CHILD_WRITE("child:write"),
    SQUAD_READ("squad:read"),
    SQUAD_WRITE("squad_write");


    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
