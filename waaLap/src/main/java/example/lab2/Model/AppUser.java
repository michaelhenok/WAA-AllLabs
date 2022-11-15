package example.lab2.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser  {


    @Id
    @GeneratedValue
    Long id;


    String username;
    private int active;
    private String password;

    @OneToMany( )
    @JoinColumn()
    List<Post> posts;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable()
    private  List<Role> roleSet;




}
