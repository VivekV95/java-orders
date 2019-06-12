package com.vivekvishwanath.javaorders.controller

import com.vivekvishwanath.javaorders.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping(value = ["/order"], produces = ["application/json"])
    fun listAllCustomers(): ResponseEntity<*> {
        val customerList = customerService.findAll()
        return ResponseEntity(customerList, HttpStatus.OK)
    }
}