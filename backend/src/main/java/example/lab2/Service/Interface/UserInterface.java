package example.lab2.Service.Interface;

import example.lab2.Model.AppUser;
import example.lab2.Model.Post;

import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserInterface {
    List<AppUser> getAll();
    public AppUser findviaId(Long id);
    AppUser savenew(AppUser appUser);
    List<Post> findviaById (Long id);
    public void deleteViaId(Long id);
}
