package spring_web_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_web_api.model.User;
import spring_web_api.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(Integer id){
        return repository.findById(id);
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable("username") String username){

        return repository.findByUsername(username);
    }

    @PostMapping
    public void create(@RequestBody User user){
        repository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
