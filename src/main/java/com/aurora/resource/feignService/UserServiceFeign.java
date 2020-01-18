package com.aurora.resource.feignService;

import com.aurora.resource.dtos.UserDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient("user-service")
public interface UserServiceFeign {

    @PostMapping("/api/saveUpdate")
    public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser);
    @GetMapping("/api/getById/{id}")
    public UserDetailsDTO getUserById(@PathVariable Long id);
    @GetMapping("/api/getByName/{name}")
    public List<UserDetailsDTO> getUserByName(@PathVariable String name);
}
