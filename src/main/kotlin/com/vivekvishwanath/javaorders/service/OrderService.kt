package com.vivekvishwanath.javaorders.service

import com.vivekvishwanath.javaorders.model.Order

interface OrderService {
    fun getAllOrdersFromCustomer(name: String): MutableList<Order>
}