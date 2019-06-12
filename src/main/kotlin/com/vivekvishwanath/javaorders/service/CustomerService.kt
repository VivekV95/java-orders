package com.vivekvishwanath.javaorders.service

import com.vivekvishwanath.javaorders.model.Customer

interface CustomerService {

    fun findAll(): MutableList<Customer>

    fun addCustomer(customer: Customer): Customer

    /* fun updateCustomer(id: Long): Customer

    fun deleteCustomer(id: Long)*/
}