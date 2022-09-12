package com.example.springtest.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.example.springtest.model.Order} entity
 */
public class OrderDto implements Serializable {
    private final Long customerId;
    private final Set<Long> productIds;

    public OrderDto(Long customerId, Set<Long> productIds) {
        this.customerId = customerId;
        this.productIds = productIds;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Set<Long> getProductIds() {
        return productIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto entity = (OrderDto) o;
        return Objects.equals(this.customerId, entity.customerId) &&
                Objects.equals(this.productIds, entity.productIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, productIds);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "customerId = " + customerId + ", " +
                "productIds = " + productIds + ")";
    }
}