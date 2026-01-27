package hiber.model;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

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

    public Car(){

    }
    public Car(String model,int series){
        this.model = model;
        this.series = series;
    }
    public int getSeries(){
        return series;
    }
    public String getModel(){
        return model;
    }
    public Long getId(){
        return id;
    }
    public User getUser(){return user;}
    public void setUser(User user){this.user=user;}
    public void setId(Long id){this.id=id;}
    public void setSeries(int series){
        this.series = series;
    }
    public void setModel(String model){
        this.model=model;
    }

    @Override
    public String toString(){
        return String.format(
                "Car{id=%d, model=%s, series=%d}",
                id,model,series
        );
    }
}
