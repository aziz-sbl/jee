package tn.pi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.pi.entities.Patient;
import tn.pi.repositories.PatientRepository;

import java.time.LocalDate;

@SpringBootApplication
public class HospitolWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitolWebApplication.class, args);
	}
	@Bean
	public CommandLineRunner init(PatientRepository patientRepository) {
		return args -> {
			//Methode 1
			Patient p1 = new Patient();
			p1.setNom("Hassen");
			p1.setDateNaiss(LocalDate.now());
			p1.setScore(1234);
			p1.setMalade(false);
			patientRepository.save(p1);
			//Methode 2
			Patient p2 = new Patient(null,"Mohamed",LocalDate.now(),true,3324);
			patientRepository.save(p2);
			//Methode 3 : using lombok
			Patient p3 = Patient.builder()
					.dateNaiss(LocalDate.now())
					.nom("Aicha")
					.score(5631)
					.malade(false)
					.build();
			patientRepository.save(p3);


		};
	}

}
