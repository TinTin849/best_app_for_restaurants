package com.tintin.app_for_restaurants.entity;

import javax.persistence.*;

@Entity
@Table(name = "goods_supplier", indexes = {
        @Index(name = "supplier_id", columnList = "supplier_id")
})
public class ItemToSupplier {
    @EmbeddedId
    private ItemToSupplierId id;

    @MapsId("goodsId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goods_id", nullable = false)
    private Item item;

    @MapsId("supplierId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(name = "price")
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemToSupplierId getId() {
        return id;
    }

    public void setId(ItemToSupplierId id) {
        this.id = id;
    }
}