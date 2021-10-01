package design.boilerplate.springboot.response;

import design.boilerplate.springboot.model.Address;
import lombok.Data;

@Data
public class AddressResponse {

    public AddressResponse(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();

    }

    private Long id;

    private String street;

    private String city;
}
