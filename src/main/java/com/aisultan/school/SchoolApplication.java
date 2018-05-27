package com.aisultan.school;

import com.aisultan.school.components.student.mapper.StudentsMapper;
import com.aisultan.school.components.student.model.Students;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;


@MappedTypes(Students.class)
@MapperScan("com.aisultan.school.components.student.mapper")
@SpringBootApplication
public class SchoolApplication {

	@Bean
	CommandLineRunner createTable(StudentsMapper mapper) {
		return strings -> {
			mapper.createTableIfAbsent("STUDENTS");

			List<Students> studentsList = Arrays.asList(
					new Students("Aisultan", "Yerlanuly", 4, "Merarslan", "aisul@gmail.com"),
					new Students("Yerlan", "Nauryzbayev", 4, "Merarslan", "yerlan@gmail.com"),
					new Students("Nurlan", "Alkuatov", 4, "Konstantin", "nurlan@gmail.com")
			);

			for (Students students : studentsList)
				mapper.insert(students);
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
}
