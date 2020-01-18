package com.aurora.resource.controllers;

import com.aurora.resource.dtos.UserDetailsDTO;
import com.aurora.resource.feignService.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResourceController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @PostMapping("/saveUpdate")
    public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser){
        return userServiceFeign.saveUpdate(inputUser);
    }
    @GetMapping("/getById/{id}")
    public UserDetailsDTO getById(@PathVariable Long id){ return userServiceFeign.getUserById(id);}

    @GetMapping("/getByName/{name}")
    public List<UserDetailsDTO> getByName(@PathVariable String name){ return userServiceFeign.getUserByName(name);}
}
