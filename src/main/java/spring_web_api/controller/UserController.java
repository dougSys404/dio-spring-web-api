package spring_web_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_web_api.model.User;
import spring_web_api.repository.UserRepository_old;
import spring_web_api.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    public UserController(UserService service){this.service = service;}

    @GetMapping
    public List<User> getUsers(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        return service.findById(id);
    }

    @GetMapping("/logins/{login}")
    public User findByLogin(@PathVariable String login){

        return service.findByUsername(login);
    }

    @PostMapping
    public void create(@RequestBody User user){
        service.create(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody User user){
        service.replace(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
