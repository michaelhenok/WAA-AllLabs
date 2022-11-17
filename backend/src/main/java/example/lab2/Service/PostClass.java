package example.lab2.Service;

import example.lab2.Model.Post;
import example.lab2.Repostory.PostRepostory;
import example.lab2.Service.Interface.PostInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostClass implements PostInterface {

    private PostRepostory postRepostory;


    @Autowired
    public PostClass(PostRepostory postRepostory) {
        this.postRepostory = postRepostory;
    }
    @Override
    public List<Post> getAll() {
        return postRepostory.findAll();
    }

    @Override
    public Post findviaId(Long id) {
        return postRepostory.findById(id).get();
    }

    @Override
    public Post addNew(Post post) {
        return postRepostory.save(post);
    }


}
