package example.lab2.Service;

import org.springframework.context.annotation.ComponentScan;


import example.lab2.Model.Post;
import example.lab2.Model.User;
import example.lab2.Repostory.UserRepository;
import example.lab2.Service.Interface.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserClass implements UserInterface {



    private UserRepository userRepository;


    @Autowired
    public UserClass(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findviaId(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User savenew(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Post> findviaById(Long id) {
        var temp = userRepository.findById(id).get();
        var temp2= temp.getPosts();
        return temp2;
    }

    @Override
    public void deleteViaId(Long id) {
        userRepository.deleteById(id);
    }
}
