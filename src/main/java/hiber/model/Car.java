package hiber.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="series")
    private int series;
    @Column(name = "model")
    private String model;

    @OneToOne(mappedBy = "car", fetch = FetchType.EAGER)
    private User user;

    public Car(String model,int series){
        this.model = model;
        this.series = series;
    }
}
