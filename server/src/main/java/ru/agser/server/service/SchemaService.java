package ru.agser.server.service;

import java.util.List;

public interface SchemaService {
    List<String> getSchema(String entity);
}
