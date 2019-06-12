package com.vivekvishwanath.javaorders.service

import com.vivekvishwanath.javaorders.model.Customer
import com.vivekvishwanath.javaorders.model.Order

interface DataService {
    fun getAllCustomers(): MutableList<Customer>

    fun getOrdersByName(customerName: String): MutableList<Order>

    fun addCustomer(customer: Customer): Customer

    fun updateCustomer(id: Long): Customer

    fun deleteCustomer(id: Long)

    fun deleteUselessAgent(id: Long)
}