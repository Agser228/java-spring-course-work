package ru.agser.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.agser.server.model.Child;
import ru.agser.server.model.Parent;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    private Child child;
    private Parent parent;
}
