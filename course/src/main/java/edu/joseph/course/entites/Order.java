package edu.joseph.course.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.joseph.course.entites.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity //anotação JPA Entity transforma campos da entidade em uma tabela SQL automaticamente
@Table(name = "tb_order")  //anotação JPA Table cria uma tabela, é possivel adicionar um nome diferente caso necessario
public class Order implements Serializable {

    @Id // anotações JPA Id Identifica PK para o BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) // anotação JPA auto incrementa o ID
    private Long id;

    //abaixo anotação jackson para formatar um json
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne // anotação JPA cria um relacionamento de muito para um ex(muito pedidos para um cliente)
    @JoinColumn(name = "client_Id") // adiciona um nome uma locuna para a FK
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
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

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getItems() {
        return items;
    }


    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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
