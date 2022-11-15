package example.lab2.Service;

import example.lab2.Model.AppUser;


import example.lab2.Model.Post;
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
    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findviaId(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public AppUser savenew(AppUser appUser) {
        return userRepository.save(appUser);
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
