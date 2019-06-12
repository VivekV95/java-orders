package com.vivekvishwanath.javaorders.repo

import com.vivekvishwanath.javaorders.model.Agent
import com.vivekvishwanath.javaorders.model.Customer
import com.vivekvishwanath.javaorders.model.Order
import org.springframework.data.repository.CrudRepository

interface AgentRepo: CrudRepository<Agent, Long>

interface CustomerRepo: CrudRepository<Customer, Long>

interface OrderRepo: CrudRepository<Order, Long> {
    fun findAllByCustomer_CustName(custName: String): MutableList<Order>
}