package spring_web_api.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import spring_web_api.model.User;
import spring_web_api.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService (UserRepository repository){
        this.repository = repository;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Integer id){
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "User not found!"
                        )
                );
    }

    public User findByUsername(String username){
        return repository.findByLogin(username)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "User not found!"
                        )
                );
    }

    public User create(User user){
       return repository.save(user);
    }

    public User replace(Integer id, User user){
       User userToBeReplaced = this.findById(id);

       userToBeReplaced.setLogin(user.getLogin());
       userToBeReplaced.setPassword(user.getPassword());

       return repository.save(userToBeReplaced);

    }

    public void delete(Integer id){
        User userToBeDeleted = this.findById(id);

        repository.delete(userToBeDeleted);

    }
}
