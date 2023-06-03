package com.ialeksic.ecommerce.dto;

import com.ialeksic.ecommerce.entity.Address;
import com.ialeksic.ecommerce.entity.Customer;
import com.ialeksic.ecommerce.entity.Order;
import com.ialeksic.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
