package com.vivekvishwanath.javaorders.service

import com.vivekvishwanath.javaorders.model.Customer
import com.vivekvishwanath.javaorders.repo.CustomerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service(value = "customerService")
class CustomerServiceImpl: CustomerService {

    @Autowired
    private lateinit var customerRepo: CustomerRepo

    override fun findAll(): MutableList<Customer> {
        val customerList = mutableListOf<Customer>()
        customerRepo.findAll().iterator().forEachRemaining{customerList.add(it)}
        return customerList
    }

    @Transactional
    override fun addCustomer(customer: Customer): Customer {
        val newCustomer = customer.copy()
        return customerRepo.save(newCustomer)
    }

    @Transactional
    override fun updateCustomer(customer: Customer, custCode: Long): Customer {
        val currentCustomer = customerRepo.findById(custCode).
                orElseThrow {EntityNotFoundException(custCode.toString())}

        currentCustomer.custName = customer.custName
        currentCustomer.custCity = customer.custCity
        currentCustomer.workingArea = customer.workingArea
        currentCustomer.custCountry = customer.custCountry
        currentCustomer.grade = customer.grade
        currentCustomer.paymentAmt = customer.paymentAmt
        currentCustomer.openingAmt = customer.openingAmt
        currentCustomer.receiveAmt = customer.receiveAmt
        currentCustomer.outstandingAmt = customer.outstandingAmt

        for (order in customer.orders) {
            currentCustomer.orders.add(order)
        }

        return customerRepo.save(currentCustomer)
    }

    override fun deleteCustomer(custCode: Long) {
        if (customerRepo.findById(custCode).isPresent) {
            customerRepo.deleteById(custCode)
        } else {
            throw EntityNotFoundException(custCode.toString())
        }
    }
}