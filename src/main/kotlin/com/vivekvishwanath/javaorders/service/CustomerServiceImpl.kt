package com.vivekvishwanath.javaorders.service

import com.vivekvishwanath.javaorders.model.Customer
import com.vivekvishwanath.javaorders.repo.CustomerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service(value = "customerService")
class CustomerServiceImpl: CustomerService {

    @Autowired
    private lateinit var customerRepo: CustomerRepo

    override fun findAll(): MutableList<Customer> {
        val customerList = mutableListOf<Customer>()
        customerRepo.findAll().iterator().forEachRemaining{customerList.add(it)}
        return customerList
    }

    override fun addCustomer(customer: Customer): Customer {
        val newCustomer = customer.copy()
        return customerRepo.save(newCustomer)
    }
}