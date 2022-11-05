package example.lab2.Model;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString

public class User {


    @Id
    @GeneratedValue
    Long id;


    String name;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
            @JoinColumn(name = "User_id")
    List<Post> posts;

    public User(Long id, String name, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }
    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
