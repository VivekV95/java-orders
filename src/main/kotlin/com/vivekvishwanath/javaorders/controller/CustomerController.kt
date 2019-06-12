package com.vivekvishwanath.javaorders.controller

import com.vivekvishwanath.javaorders.service.CustomerService
import com.vivekvishwanath.javaorders.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @Autowired
    private lateinit var orderService: OrderService

    @GetMapping(value = ["/order"], produces = ["application/json"])
    fun listAllCustomers(): ResponseEntity<*> {
        val customerList = customerService.findAll()
        return ResponseEntity(customerList, HttpStatus.OK)
    }

    @GetMapping(value = ["name/{custName}"], produces = ["application/json"])
    fun listOrdersByCustomerName(@PathVariable custName: String): ResponseEntity<*> {
        val orderList = orderService.findAllByCustName(custName)
        return ResponseEntity(orderList, HttpStatus.OK)
    }
}