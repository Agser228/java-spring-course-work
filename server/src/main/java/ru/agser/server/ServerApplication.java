package ru.agser.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.agser.server.model.Child;
import ru.agser.server.repo.ChildRepository;

import java.time.LocalDate;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ChildRepository childRepository) {
		return args -> {
			childRepository.save(new Child(null, null, null, "Иван", "Иванов", "Иванович", LocalDate.of(2013, 11, 2), 654321, "Егорьевск", 9));
			childRepository.save(new Child(null, null, null, "Мария", "Дубнова", "Александровна", LocalDate.of(2013, 7, 29), 654321, "Москва", 9));
			childRepository.save(new Child(null, null, null, "Максим", "Ситро", "Викторович", LocalDate.of(2010, 3, 4), 654321, "Воронеж", 12));
		};
	}
}
