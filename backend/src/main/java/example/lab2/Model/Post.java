package example.lab2.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Post {
    @Id
    @GeneratedValue

    private Long id;
    private String title;
    private String content;
    private String author;


    @ManyToOne(cascade = CascadeType.ALL)
    private AppUser appUser;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    List<Comment> commentList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }
}

