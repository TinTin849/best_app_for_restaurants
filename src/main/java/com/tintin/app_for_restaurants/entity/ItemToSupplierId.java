package com.tintin.app_for_restaurants.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemToSupplierId implements Serializable {
    private static final long serialVersionUID = -7698946738158614405L;
    @Column(name = "goods_id", nullable = false)
    private Integer goodsId;
    @Column(name = "supplier_id", nullable = false)
    private Integer supplierId;

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, goodsId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItemToSupplierId entity = (ItemToSupplierId) o;
        return Objects.equals(this.supplierId, entity.supplierId) &&
                Objects.equals(this.goodsId, entity.goodsId);
    }
}