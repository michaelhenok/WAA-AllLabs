package lab1.com.Repostory;

import lab1.com.Model.Post;
import lab1.com.Model.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostDtoRepostory extends JpaRepository<PostDto, Long> {
}
