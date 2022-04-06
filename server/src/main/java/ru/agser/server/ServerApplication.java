package ru.agser.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.agser.server.model.Child;
import ru.agser.server.model.Squad;
import ru.agser.server.repo.ChildRepository;
import ru.agser.server.repo.SquadRepository;

import java.time.LocalDate;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ChildRepository childRepository,
						  SquadRepository squadRepository
	) {
		return args -> {
			childRepository.save(new Child(null, null, 1L, "Иван", "Иванов", "Иванович", LocalDate.of(2013, 11, 2), 654321, "Егорьевск", 9));
			childRepository.save(new Child(null, null, 1L, "Мария", "Дубнова", "Александровна", LocalDate.of(2013, 7, 29), 654321, "Москва", 9));
			childRepository.save(new Child(null, null, 2L, "Максим", "Ситро", "Викторович", LocalDate.of(2010, 3, 4), 654321, "Воронеж", 12));

			squadRepository.save(new Squad(1L, 1, 12));
			squadRepository.save(new Squad(2L, 2, 13));
			squadRepository.save(new Squad(3L, 3, 13));

		};


	}
}
