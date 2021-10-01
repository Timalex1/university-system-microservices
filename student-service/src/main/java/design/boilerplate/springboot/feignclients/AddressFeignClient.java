package design.boilerplate.springboot.feignclients;

import design.boilerplate.springboot.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "address-service", path = "/api/address")
public interface AddressFeignClient {
    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable Long id);
}
 