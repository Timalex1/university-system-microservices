package design.boilerplate.springboot.request;

import lombok.Data;

@Data
public class AddressRequest {

    private String street;

    private String city;
}
