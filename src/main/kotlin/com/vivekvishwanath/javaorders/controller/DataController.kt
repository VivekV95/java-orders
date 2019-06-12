package com.vivekvishwanath.javaorders.controller

import com.vivekvishwanath.javaorders.model.Customer
import com.vivekvishwanath.javaorders.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/data")
class DataController {

    @Autowired
    private lateinit var customerService: CustomerService

    @PostMapping(value = ["/customer/new"],
            consumes = ["application/json"],
            produces = ["application/json"])
    fun addNewCustomer(@Valid @RequestBody customer: Customer): ResponseEntity<*> {
        val newCustomer = customerService.addCustomer(customer)
        return ResponseEntity(newCustomer, HttpStatus.OK)
    }
}