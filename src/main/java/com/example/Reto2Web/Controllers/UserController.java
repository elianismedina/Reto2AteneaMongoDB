package com.example.Reto2Web.Controllers;

import com.example.Reto2Web.Model.User;
import com.example.Reto2Web.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping("/zone/{zone}")
    public List<User> getUsersByZone(@PathVariable("zone") String zone){
        return userServices.getUsersByZone(zone);
    }

    @GetMapping("/type/{type}")
    public List<User> getUsersByType(@PathVariable("type") String type){
        return userServices.getUsersByType(type);
    }



    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") Integer userId){
        return userServices.getUserById(userId);
    }

    @GetMapping("/emailexist/{email}")
    public Boolean getUserByEmail(@PathVariable("email") String email){
        return userServices.getUserByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public Optional<User> validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userServices.validateUserLogin(email, password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User insertUser(@RequestBody User user){
        return userServices.insertUser(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user){
        return userServices.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId") Integer userId){
        userServices.deleteUser(userId);
    }

}
