package lab1.com.Service;


import lab1.com.Model.Post;
import lab1.com.Model.PostDto;


import java.util.List;

public interface PostSerInt {

     List<Post> findAll();
     public PostDto findById(Long id);
     Post save(Post post);
     public void DeleteById(Long id);
     public Post UpdateById(Long id , Post post);


}
