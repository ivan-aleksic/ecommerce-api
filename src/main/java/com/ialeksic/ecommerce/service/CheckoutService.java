package com.ialeksic.ecommerce.service;

import com.ialeksic.ecommerce.dto.Purchase;
import com.ialeksic.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
