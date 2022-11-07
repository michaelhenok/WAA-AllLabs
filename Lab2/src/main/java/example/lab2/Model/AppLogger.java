package example.lab2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppLogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private LocalDate date;
    private long time;
    private String principle;
    private String operation;
}
