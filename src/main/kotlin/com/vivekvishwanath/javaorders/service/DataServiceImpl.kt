package com.vivekvishwanath.javaorders.service

import com.vivekvishwanath.javaorders.model.Customer
import com.vivekvishwanath.javaorders.model.Order
import org.springframework.stereotype.Service

@Service(value = "dataService")
class DataServiceImpl: DataService {
    override fun getAllCustomers(): MutableList<Customer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOrdersByName(customerName: String): MutableList<Order> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addCustomer(customer: Customer): Customer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCustomer(id: Long): Customer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteCustomer(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUselessAgent(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}