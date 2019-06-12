package com.vivekvishwanath.javaorders.service

import com.vivekvishwanath.javaorders.model.Order

interface OrderService {
    fun findAllByCustName(name: String): MutableList<Order>
}