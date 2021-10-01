package design.boilerplate.springboot.response;

import design.boilerplate.springboot.model.Student;
import lombok.Data;

@Data
public class StudentResponse {

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private AddressResponse addressResponse;
}
