package spring_web_api.repository;

import org.springframework.stereotype.Repository;
import spring_web_api.handler.RequiredFieldException;
import spring_web_api.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public void save(User user){
        if (user.getLogin() == null) throw new RequiredFieldException("login");
        if (user.getPassword() == null) throw new RequiredFieldException("password");

        if (user.getId() == null){
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        } else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        }

        System.out.println(user);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("Delete/id - Recebendo o id: %d para excluir um recurso", id));
        System.out.println(id);
    }

    public List<User> findAll(){
        System.out.println("Listando os usuários do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("john", "agesune1"));
        users.add(new User("maria", "mudar123"));

        return users;
    }

    public User findById(Integer id){
        System.out.println(String.format("Find/ID - Recebendo o id: %d para localizar um usuário", id));
        return new User("john", "agesune1");

    }

    public User findByUsername(String username){
        System.out.println(String.format("FIND/USERNAME - Recebendo o username: %s para localizar um usuário", username));
        return new User("john", "agesune1");
    }
}
