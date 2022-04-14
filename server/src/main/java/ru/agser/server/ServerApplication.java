package ru.agser.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.agser.server.controller.WorkerController;
import ru.agser.server.enumeration.Position;
import ru.agser.server.model.Child;
import ru.agser.server.model.Squad;
import ru.agser.server.model.Worker;
import ru.agser.server.repo.ChildRepository;
import ru.agser.server.repo.SquadRepository;
import ru.agser.server.repo.WorkerRepository;
import ru.agser.server.service.WorkerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ChildRepository childRepository,
						  SquadRepository squadRepository,
						  WorkerRepository workerRepository,
						  WorkerService workerService

	) {
		return args -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

			fillChildRepository(childRepository);

			childRepository.save(new Child(null, null, null, "Иван", "Иванов", "Иванович", LocalDate.parse("11/02/2013", formatter), 654321, "Егорьевск", 9));
			childRepository.save(new Child(null, null, null, "Мария", "Дубнова", "Александровна", LocalDate.parse("07/29/2013", formatter), 654321, "Москва", 9));
			childRepository.save(new Child(null, null, null, "Максим", "Ситро", "Викторович", LocalDate.parse("03/04/2010", formatter), 654321, "Воронеж", 12));

//			List<Child> children = childRepository.findAll();
//			Squad squad = new Squad(null, null, null, 1, 12);
//			for (Child child : children) {
//				child.setSquad(squad);
//			}
//			squad.setChildren(children);
//
//			squadRepository.save(squad);
//			childRepository.saveAll(children);

			Worker worker = new Worker(null, "John", "Dao", "Dadao", "Moscow", "11 22 33 665544", Position.COUNSELOR, "1234", "Moscow");
			workerService.save(worker);

		};
	}

		void fillChildRepository(ChildRepository childRepository) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			childRepository.save(new Child(null, null, null, "Lynn", "Debra", "Dillon", LocalDate.parse("07/11/2011", formatter), 8775579, "Valencia", 10));
			childRepository.save(new Child(null, null, null, "Karina", "Chloe", "Alana", LocalDate.parse("03/29/2012", formatter), 185596, "Pachuca", 10));
			childRepository.save(new Child(null, null, null, "Len", "Sophia", "Lucy", LocalDate.parse("05/02/2012", formatter), 6789948, "Guizhou", 9));
			childRepository.save(new Child(null, null, null, "Troy", "Adele", "Hayfa", LocalDate.parse("03/12/2012", formatter), 5650266, "San Juan de Girón", 14));
			childRepository.save(new Child(null, null, null, "Caleb", "Joshua", "Cheyenne", LocalDate.parse("01/05/2012", formatter), 10950523, "Shimla", 13));
			childRepository.save(new Child(null, null, null, "Yael", "Mufutau", "Lila", LocalDate.parse("04/15/2012", formatter), 1093899, "Siverek", 11));
			childRepository.save(new Child(null, null, null, "Wyatt", "Berk", "Lacy", LocalDate.parse("02/12/2012", formatter), 11884926, "Central Water Catchment", 8));
			childRepository.save(new Child(null, null, null, "Aristotle", "Stuart", "Vincent", LocalDate.parse("11/20/2011", formatter), 8295354, "Abeokuta", 15));
			childRepository.save(new Child(null, null, null, "August", "Graiden", "Baxter", LocalDate.parse("01/25/2012", formatter), 4454761, "Wageningen", 8));
			childRepository.save(new Child(null, null, null, "Omar", "Grady", "Holly", LocalDate.parse("03/02/2012", formatter), 5249753, "Alsemberg", 12));
			childRepository.save(new Child(null, null, null, "Nayda", "Gage", "Kevyn", LocalDate.parse("05/29/2012", formatter), 11177529, "Cumaribo", 9));
			childRepository.save(new Child(null, null, null, "Tate", "Harding", "Lara", LocalDate.parse("01/22/2012", formatter), 1056002, "Siquirres", 11));
			childRepository.save(new Child(null, null, null, "Quail", "Halla", "Sydney", LocalDate.parse("07/13/2011", formatter), 11384529, "Kadiyivka", 12));
			childRepository.save(new Child(null, null, null, "Brian", "Lael", "Dai", LocalDate.parse("04/16/2012", formatter), 901076, "Jackson", 12));
			childRepository.save(new Child(null, null, null, "Camden", "Charde", "Noel", LocalDate.parse("08/05/2011", formatter), 5278871, "Museum", 8));
			childRepository.save(new Child(null, null, null, "Patience", "Tashya", "Alfonso", LocalDate.parse("10/23/2011", formatter), 3706651, "Sichuan", 9));
			childRepository.save(new Child(null, null, null, "Jesse", "Brent", "Vladimir", LocalDate.parse("09/11/2011", formatter), 3000696, "Daly", 10));
			childRepository.save(new Child(null, null, null, "Yvette", "Emi", "Tara", LocalDate.parse("10/05/2011", formatter), 2122214, "Matamata", 13));
			childRepository.save(new Child(null, null, null, "Cyrus", "Hu", "Nelle", LocalDate.parse("10/24/2011", formatter), 6144288, "Grobbendonk", 9));
			childRepository.save(new Child(null, null, null, "Miriam", "Carl", "Joan", LocalDate.parse("08/28/2011", formatter), 2060845, "San Diego", 14));
			childRepository.save(new Child(null, null, null, "Hyatt", "Upton", "Jorden", LocalDate.parse("05/13/2012", formatter), 9114284, "Bacoor", 15));
			childRepository.save(new Child(null, null, null, "Trevor", "Rahim", "Thane", LocalDate.parse("04/18/2012", formatter), 11331341, "Phan Rang–Tháp Chàm", 8));
			childRepository.save(new Child(null, null, null, "Keane", "Dalton", "Murphy", LocalDate.parse("03/17/2012", formatter), 2033887, "Bacolod", 12));
			childRepository.save(new Child(null, null, null, "Keely", "Denton", "Ryan", LocalDate.parse("03/13/2012", formatter), 7641392, "Wolfenbüttel", 7));
			childRepository.save(new Child(null, null, null, "Griffith", "Joelle", "Christine", LocalDate.parse("08/27/2011", formatter), 4972755, "Sousa", 15));
			childRepository.save(new Child(null, null, null, "Evelyn", "Keefe", "Angelica", LocalDate.parse("10/22/2011", formatter), 8158699, "Lambayeque", 12));
			childRepository.save(new Child(null, null, null, "Orla", "Hayfa", "Ginger", LocalDate.parse("05/05/2012", formatter), 8801105, "Abbotsford", 14));
			childRepository.save(new Child(null, null, null, "Germane", "Dexter", "Josiah", LocalDate.parse("08/04/2011", formatter), 10579612, "La Magdeleine", 10));
			childRepository.save(new Child(null, null, null, "Eliana", "Jaime", "Kevyn", LocalDate.parse("12/06/2011", formatter), 7806257, "Onitsha", 12));
			childRepository.save(new Child(null, null, null, "Alisa", "Paki", "Lewis", LocalDate.parse("09/07/2011", formatter), 10446592, "Wilmington", 14));
			childRepository.save(new Child(null, null, null, "Athena", "Reese", "Felix", LocalDate.parse("02/27/2012", formatter), 9961768, "Sahagún", 12));
			childRepository.save(new Child(null, null, null, "Avram", "Leroy", "Carissa", LocalDate.parse("04/03/2012", formatter), 3872183, "Tehuacán", 13));
			childRepository.save(new Child(null, null, null, "Abra", "Jorden", "Channing", LocalDate.parse("12/15/2011", formatter), 3819273, "Hainan", 9));
			childRepository.save(new Child(null, null, null, "Faith", "Maisie", "Holly", LocalDate.parse("12/22/2011", formatter), 8696037, "Iksan", 12));
			childRepository.save(new Child(null, null, null, "John", "Mechelle", "Madison", LocalDate.parse("01/05/2012", formatter), 8546123, "Sabanalarga", 9));
			childRepository.save(new Child(null, null, null, "Igor", "Garrison", "Hedwig", LocalDate.parse("03/03/2012", formatter), 8354085, "Chepén", 10));
			childRepository.save(new Child(null, null, null, "Wilma", "Whitney", "Alan", LocalDate.parse("10/15/2011", formatter), 11265116, "Jodhpur", 12));
			childRepository.save(new Child(null, null, null, "Justina", "Hilel", "Stuart", LocalDate.parse("09/11/2011", formatter), 2270782, "Okigwe", 12));
			childRepository.save(new Child(null, null, null, "Caryn", "Frances", "Sylvester", LocalDate.parse("12/29/2011", formatter), 11672323, "Cedar Rapids", 11));
			childRepository.save(new Child(null, null, null, "Dustin", "Karina", "Allistair", LocalDate.parse("04/04/2012", formatter), 2129710, "Ried im Innkreis", 15));
			childRepository.save(new Child(null, null, null, "Kimberly", "Laith", "Wade", LocalDate.parse("11/25/2011", formatter), 5459598, "Kovel", 14));
			childRepository.save(new Child(null, null, null, "Griffin", "Slade", "Leila", LocalDate.parse("09/13/2011", formatter), 5373816, "Santander", 15));
			childRepository.save(new Child(null, null, null, "Kiayada", "Gary", "Damon", LocalDate.parse("04/14/2012", formatter), 10616881, "Antipolo", 14));
			childRepository.save(new Child(null, null, null, "Dylan", "Anthony", "Shelley", LocalDate.parse("05/18/2012", formatter), 2705397, "Nässjö", 7));
			childRepository.save(new Child(null, null, null, "Guinevere", "Ishmael", "Julie", LocalDate.parse("12/05/2011", formatter), 796152, "Deventer", 11));
			childRepository.save(new Child(null, null, null, "Whitney", "Emerson", "Shaine", LocalDate.parse("04/02/2012", formatter), 5778366, "Blenheim", 14));
			childRepository.save(new Child(null, null, null, "Quon", "Caleb", "Nadine", LocalDate.parse("01/21/2012", formatter), 4908445, "Arequipa", 10));
			childRepository.save(new Child(null, null, null, "Tanya", "Gloria", "Brielle", LocalDate.parse("08/19/2011", formatter), 11757434, "Binjai", 12));
			childRepository.save(new Child(null, null, null, "Levi", "Flynn", "Hu", LocalDate.parse("01/30/2012", formatter), 9433392, "Okara", 14));
			childRepository.save(new Child(null, null, null, "Timothy", "Tarik", "Neve", LocalDate.parse("07/23/2011", formatter), 1078593, "Sacheon", 11));
			childRepository.save(new Child(null, null, null, "Jesse", "Jonah", "Shellie", LocalDate.parse("11/01/2011", formatter), 1463640, "Dieppe", 10));
			childRepository.save(new Child(null, null, null, "Olga", "Asher", "Kirk", LocalDate.parse("08/04/2011", formatter), 3719931, "Long Xuyên", 14));
			childRepository.save(new Child(null, null, null, "Clark", "India", "Gregory", LocalDate.parse("11/25/2011", formatter), 11177207, "Palma de Mallorca", 11));
			childRepository.save(new Child(null, null, null, "Avram", "Dorothy", "Brendan", LocalDate.parse("04/01/2012", formatter), 7672381, "Cusco", 10));
			childRepository.save(new Child(null, null, null, "Ivor", "Chiquita", "Dennis", LocalDate.parse("02/14/2012", formatter), 3048065, "Bloemfontein", 13));
			childRepository.save(new Child(null, null, null, "Shay", "Zahir", "Preston", LocalDate.parse("08/24/2011", formatter), 8233648, "Santa María", 8));
			childRepository.save(new Child(null, null, null, "Neil", "Bruno", "Carson", LocalDate.parse("03/04/2012", formatter), 7596352, "Subiaco", 8));
			childRepository.save(new Child(null, null, null, "Rowan", "Clayton", "Ignacia", LocalDate.parse("12/30/2011", formatter), 8499509, "Destelbergen", 9));
			childRepository.save(new Child(null, null, null, "Geraldine", "Kristen", "Oscar", LocalDate.parse("10/04/2011", formatter), 6022520, "Canberra", 13));
			childRepository.save(new Child(null, null, null, "Veda", "Lois", "Rudyard", LocalDate.parse("08/31/2011", formatter), 10158205, "Verkhneuralsk", 15));
			childRepository.save(new Child(null, null, null, "Keaton", "Christian", "Jada", LocalDate.parse("10/19/2011", formatter), 2484832, "Henan", 10));
			childRepository.save(new Child(null, null, null, "Ainsley", "Faith", "Kirestin", LocalDate.parse("05/12/2012", formatter), 8360100, "Thames", 8));
			childRepository.save(new Child(null, null, null, "Nicholas", "Brynn", "Phoebe", LocalDate.parse("03/03/2012", formatter), 1686226, "Hondelange", 10));
			childRepository.save(new Child(null, null, null, "Olga", "Sandra", "Rafael", LocalDate.parse("11/28/2011", formatter), 12227607, "Kamianets-Podilskyi", 12));
			childRepository.save(new Child(null, null, null, "Mariko", "Perry", "Logan", LocalDate.parse("01/29/2012", formatter), 11461646, "Bogotá", 15));
			childRepository.save(new Child(null, null, null, "Benedict", "Xavier", "Carson", LocalDate.parse("02/21/2012", formatter), 2182287, "Telfs", 11));
			childRepository.save(new Child(null, null, null, "Blake", "Delilah", "Acton", LocalDate.parse("12/24/2011", formatter), 4241028, "Ternate", 14));
			childRepository.save(new Child(null, null, null, "Hayfa", "Akeem", "Bianca", LocalDate.parse("07/12/2011", formatter), 2899205, "Southend", 14));
			childRepository.save(new Child(null, null, null, "Dante", "Ursa", "Ethan", LocalDate.parse("11/08/2011", formatter), 10165748, "El Retorno", 13));
			childRepository.save(new Child(null, null, null, "Armando", "Claire", "Geraldine", LocalDate.parse("01/30/2012", formatter), 11133131, "Oudtshoorn", 13));
			childRepository.save(new Child(null, null, null, "Hedley", "Brendan", "Virginia", LocalDate.parse("07/11/2011", formatter), 666141, "Saint-Herblain", 8));
			childRepository.save(new Child(null, null, null, "Dustin", "Ann", "Linus", LocalDate.parse("10/10/2011", formatter), 3413998, "Hoa Sơn", 8));
			childRepository.save(new Child(null, null, null, "Urielle", "Chelsea", "Aiko", LocalDate.parse("07/23/2011", formatter), 59925, "Rostov", 9));
			childRepository.save(new Child(null, null, null, "Brock", "Jakeem", "Simone", LocalDate.parse("11/30/2011", formatter), 2877150, "Baasrode", 8));
			childRepository.save(new Child(null, null, null, "Hedley", "Kelly", "Thaddeus", LocalDate.parse("07/12/2011", formatter), 5543380, "Novo Hamburgo", 8));
			childRepository.save(new Child(null, null, null, "Hayfa", "Mufutau", "Griffin", LocalDate.parse("01/08/2012", formatter), 10695237, "Batac", 11));
			childRepository.save(new Child(null, null, null, "Ulysses", "Demetrius", "Eugenia", LocalDate.parse("01/07/2012", formatter), 7408931, "Mykolaiv", 12));
			childRepository.save(new Child(null, null, null, "Madonna", "Hall", "Brendan", LocalDate.parse("08/29/2011", formatter), 6712422, "Tengah", 11));
			childRepository.save(new Child(null, null, null, "Rose", "Selma", "Zachery", LocalDate.parse("12/25/2011", formatter), 7258910, "Uyo", 12));
			childRepository.save(new Child(null, null, null, "Herrod", "Giacomo", "Dana", LocalDate.parse("11/07/2011", formatter), 10177156, "Watson Lake", 11));
			childRepository.save(new Child(null, null, null, "Clementine", "Aidan", "Odette", LocalDate.parse("11/05/2011", formatter), 9306670, "Santander", 13));
			childRepository.save(new Child(null, null, null, "Vielka", "Nicholas", "Georgia", LocalDate.parse("09/16/2011", formatter), 12045492, "Stockerau", 8));
			childRepository.save(new Child(null, null, null, "Yolanda", "Ralph", "Tucker", LocalDate.parse("02/12/2012", formatter), 6016661, "Izmir", 11));
			childRepository.save(new Child(null, null, null, "Vivian", "Rafael", "Catherine", LocalDate.parse("01/23/2012", formatter), 424547, "Wismar", 13));
			childRepository.save(new Child(null, null, null, "Leigh", "Uriel", "Idola", LocalDate.parse("04/11/2012", formatter), 8185120, "Dieppe", 12));
			childRepository.save(new Child(null, null, null, "Kirestin", "Neve", "Beck", LocalDate.parse("10/02/2011", formatter), 9969620, "Bengkulu", 7));
			childRepository.save(new Child(null, null, null, "Noah", "Demetria", "Elton", LocalDate.parse("09/02/2011", formatter), 5538726, "Gagliano del Capo", 12));
			childRepository.save(new Child(null, null, null, "Camille", "Jescie", "Ori", LocalDate.parse("11/18/2011", formatter), 2693542, "Sóc Trăng", 14));
			childRepository.save(new Child(null, null, null, "Chastity", "Brenden", "Judith", LocalDate.parse("07/29/2011", formatter), 3715299, "Mattersburg", 8));
			childRepository.save(new Child(null, null, null, "Sydney", "Josiah", "Eleanor", LocalDate.parse("07/30/2011", formatter), 1060977, "Travo", 8));
			childRepository.save(new Child(null, null, null, "Mark", "Kiona", "Jakeem", LocalDate.parse("05/29/2012", formatter), 2258868, "Guaitecas", 12));
			childRepository.save(new Child(null, null, null, "Lunea", "Moana", "Marny", LocalDate.parse("08/18/2011", formatter), 11671065, "Singapore River", 11));
			childRepository.save(new Child(null, null, null, "Jamal", "Jael", "Lenore", LocalDate.parse("04/09/2012", formatter), 1765521, "Pachuca", 10));
			childRepository.save(new Child(null, null, null, "Raven", "Venus", "Georgia", LocalDate.parse("07/22/2011", formatter), 5074232, "Bogotá", 13));
			childRepository.save(new Child(null, null, null, "Hashim", "Macon", "Kuame", LocalDate.parse("08/04/2011", formatter), 5376802, "Isabela City", 13));
			childRepository.save(new Child(null, null, null, "Brooke", "Herrod", "Galvin", LocalDate.parse("04/15/2012", formatter), 11338290, "Siquirres", 10));
			childRepository.save(new Child(null, null, null, "Anika", "Odessa", "Kennan", LocalDate.parse("10/19/2011", formatter), 984532, "Pazarcık", 14));
			childRepository.save(new Child(null, null, null, "Burke", "Simon", "Rhea", LocalDate.parse("11/02/2011", formatter), 3035025, "Blois", 12));
			childRepository.save(new Child(null, null, null, "Deanna", "Ella", "Len", LocalDate.parse("12/08/2011", formatter), 4101075, "Boon Lay", 14));
			childRepository.save(new Child(null, null, null, "Nash", "Rajah", "Willa", LocalDate.parse("10/29/2011", formatter), 10919392, "Dunedin", 9));

		}
}
