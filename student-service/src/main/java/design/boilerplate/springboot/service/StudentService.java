package design.boilerplate.springboot.service;

import design.boilerplate.springboot.feignclients.AddressFeignClient;
import design.boilerplate.springboot.model.Student;
import design.boilerplate.springboot.repository.StudentRepository;
import design.boilerplate.springboot.request.StudentRequest;
import design.boilerplate.springboot.response.AddressResponse;
import design.boilerplate.springboot.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    WebClient webClient;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressFeignClient addressFeignClient;

    public StudentResponse createStudent(StudentRequest studentRequest){

        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setAddressId(studentRequest.getAddressId());

        student = studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse(student);

//        studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

        studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

        return studentResponse;
    }

    public StudentResponse getById(Long id){

        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse(student);

//        studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

        studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

        return studentResponse;
    }

    public AddressResponse getAddressById(Long id){

        Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/" + id)
                .retrieve().bodyToMono(AddressResponse.class);

        return addressResponse.block();
    }
}
