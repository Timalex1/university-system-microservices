package design.boilerplate.springboot.repository;

import design.boilerplate.springboot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
