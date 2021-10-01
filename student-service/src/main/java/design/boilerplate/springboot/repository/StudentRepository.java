package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
