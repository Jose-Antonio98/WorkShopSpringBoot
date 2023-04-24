package edu.joseph.course.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity //anotação JPA Entity transforma campos da entidade em uma tabela SQL automaticamente
@Table(name = "tb_order")  //anotação JPA Table cria uma tabela, é possivel adicionar um nome diferente caso necessario
public class Order implements Serializable {

    @Id // anotações JPA Id Identifica PK para o BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) // anotação JPA auto incrementa o ID
    private Long id;
    private Instant moment;

    @ManyToOne // anotação JPA cria um relacionamento de muito para um ex(muito pedidos para um cliente)
    @JoinColumn(name = "client_Id") // adiciona um nome uma locuna para a FK
    private User client;


    public Order(){
    }

    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getId(), order.getId()) && Objects.equals(getClient(), order.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClient());
    }
}
