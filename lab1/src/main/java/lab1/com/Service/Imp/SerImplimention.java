package lab1.com.Service.Imp;

import lab1.com.Model.Post;
import lab1.com.Model.PostDto;
import lab1.com.Repostory.PostDtoRepostory;
import lab1.com.Repostory.PostRepostory;
import lab1.com.Service.PostSerInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SerImplimention implements PostSerInt {

    @Autowired
   private PostRepostory repostory;
    @Autowired
    private PostDtoRepostory repostoryDto;


    @Override
    public List<Post> findAll() {
        return repostory.findAll();
    }

    @Override
    public PostDto findById(Long id) {
        return repostoryDto.findById(id).orElse(null);
    }

    @Override
    public Post save(@RequestBody  Post post) {
        return repostory.save(post);
    }

    @Override
    public void DeleteById(Long id) {
        repostory.deleteById(id);

    }

    @Override
    public Post UpdateById(Long id , Post post) {

    return repostory.save(post);
    }
}
