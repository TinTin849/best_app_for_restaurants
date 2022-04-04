package com.tintin.app_for_restaurants.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    private Item orderItem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private Supplier orderSupplier;

    @Column(name = "quantity_of_goods")
    private int quantityOfGoods;

    @Column(name = "full_price")
    private double price;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    public Order() {
    }

    public Order(Item orderItem, Supplier orderSupplier, int quantityOfGoods, double price, LocalDate creationDate) {
        this.orderItem = orderItem;
        this.orderSupplier = orderSupplier;
        this.quantityOfGoods = quantityOfGoods;
        this.price = price;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Item orderItem) {
        this.orderItem = orderItem;
    }

    public Supplier getOrderSupplier() {
        return orderSupplier;
    }

    public void setOrderSupplier(Supplier orderSupplier) {
        this.orderSupplier = orderSupplier;
    }

    public int getQuantityOfGoods() {
        return quantityOfGoods;
    }

    public void setQuantityOfGoods(int quantityOfGoods) {
        this.quantityOfGoods = quantityOfGoods;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderItem=" + orderItem +
                ", orderSupplier=" + orderSupplier +
                ", quantityOfGoods=" + quantityOfGoods +
                ", price=" + price +
                ", creationDate=" + creationDate +
                '}';
    }
}
