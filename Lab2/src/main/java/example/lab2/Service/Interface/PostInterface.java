package example.lab2.Service.Interface;

import example.lab2.Model.Post;
import example.lab2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostInterface{

    List<Post> getAll();
    public Post findviaId(Long id);
    Post addNew(Post post);

}
