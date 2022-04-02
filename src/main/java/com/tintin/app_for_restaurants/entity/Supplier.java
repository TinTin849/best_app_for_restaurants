package com.tintin.app_for_restaurants.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Supplier() {
    }

    public Supplier(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getGoods() {
        return goods;
    }

    public void setGoods(List<Item> goods) {
        this.goods = goods;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "goods_supplier"
            , joinColumns = @JoinColumn(name = "supplier_id")
            , inverseJoinColumns = @JoinColumn(name = "goods_id"))
    private List<Item> goods;
}
