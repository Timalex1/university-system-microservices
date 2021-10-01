package design.boilerplate.springboot.controller;

import design.boilerplate.springboot.request.AddressRequest;
import design.boilerplate.springboot.response.AddressResponse;
import design.boilerplate.springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;


    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody AddressRequest addressRequest){
        return addressService.createAddress(addressRequest);
    }

}
