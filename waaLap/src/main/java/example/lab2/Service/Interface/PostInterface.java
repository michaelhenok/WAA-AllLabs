package example.lab2.Service.Interface;

import example.lab2.Model.Post;

import java.util.List;

public interface PostInterface{

    List<Post> getAll();
    public Post findviaId(Long id);
    Post addNew(Post post);

}
