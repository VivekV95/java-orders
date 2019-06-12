package com.vivekvishwanath.javaorders.service

import com.vivekvishwanath.javaorders.model.Order
import com.vivekvishwanath.javaorders.repo.OrderRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service(value = "orderService")
class OrderServiceImpl: OrderService {

    @Autowired
    private lateinit var orderRepo: OrderRepo

    override fun findAllByCustName(name: String): MutableList<Order> {
        val orderList = mutableListOf<Order>()
        orderRepo.findAllByCustomer_CustName(name).iterator().forEachRemaining{orderList.add(it)}
        return orderList
    }
}

