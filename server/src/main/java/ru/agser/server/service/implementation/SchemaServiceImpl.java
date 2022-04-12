package ru.agser.server.service.implementation;

import org.springframework.stereotype.Service;
import ru.agser.server.model.Child;
import ru.agser.server.model.Parent;
import ru.agser.server.model.Shift;
import ru.agser.server.model.Squad;
import ru.agser.server.model.Worker;
import ru.agser.server.service.SchemaService;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class SchemaServiceImpl implements SchemaService {


    final Map<String, Class<?>> entities = new HashMap<>() {{
        put(Parent.class.getSimpleName().toLowerCase(), Parent.class);
        put(Child.class.getSimpleName().toLowerCase(), Child.class);
        put(Squad.class.getSimpleName().toLowerCase(), Squad.class);
        put(Worker.class.getSimpleName().toLowerCase(), Worker.class);
        put(Shift.class.getSimpleName().toLowerCase(), Shift.class);
    }};

    @Override
    public List<String> getSchema(String entityName) {
        List<Field> fields = Arrays.asList(entities.get(entityName).getDeclaredFields());
        return fields.stream()
                .map(Field::getName)
                .collect(Collectors.toList());
    }
}
