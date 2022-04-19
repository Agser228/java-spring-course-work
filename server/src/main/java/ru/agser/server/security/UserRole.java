package ru.agser.server.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static ru.agser.server.security.UserPermission.CHILD_READ;
import static ru.agser.server.security.UserPermission.CHILD_WRITE;
import static ru.agser.server.security.UserPermission.SQUAD_READ;
import static ru.agser.server.security.UserPermission.SQUAD_WRITE;

public enum UserRole {
    ADMIN(Sets.newHashSet(CHILD_READ, CHILD_WRITE, SQUAD_WRITE, SQUAD_READ)),
    WORKER(Sets.newHashSet(CHILD_READ)),
    PARENT(Sets.newHashSet(CHILD_READ, SQUAD_READ));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        Set<GrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROlE_" + this.name()));
        return permissions;
    }
}
