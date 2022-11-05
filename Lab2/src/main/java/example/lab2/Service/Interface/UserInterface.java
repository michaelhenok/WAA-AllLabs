package example.lab2.Service.Interface;

import example.lab2.Model.Post;
import example.lab2.Model.User;

import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserInterface {
    List<User> getAll();
    public User findviaId(Long id);
    User savenew(User user);
    List<Post> findviaById (Long id);
    public void deleteViaId(Long id);
}
