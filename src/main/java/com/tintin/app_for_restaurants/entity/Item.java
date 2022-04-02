package com.tintin.app_for_restaurants.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "goods")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_items")
    private int numberOfItems;

    public Item() {
    }

    public Item(String name, int numberOfItems) {
        this.name = name;
        this.numberOfItems = numberOfItems;
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

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "goods_supplier"
            , joinColumns = @JoinColumn(name = "goods_id")
            , inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private List<Supplier> suppliers;
}
