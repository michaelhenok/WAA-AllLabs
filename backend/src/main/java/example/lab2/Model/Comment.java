package example.lab2.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    Long id;


    String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Post post;


}
