package design.boilerplate.springboot.response;

import lombok.Data;

@Data
public class AddressResponse {

    private Long id;

    private String street;

    private String city;
}
