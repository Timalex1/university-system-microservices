package design.boilerplate.springboot.service;

import design.boilerplate.springboot.model.Address;
import design.boilerplate.springboot.repository.AddressRepository;
import design.boilerplate.springboot.request.AddressRequest;
import design.boilerplate.springboot.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(AddressRequest addressRequest){

        Address address = new Address();
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getById(Long id){

        Address address = addressRepository.findById(id).get();

        return new AddressResponse(address); 
    }

}
