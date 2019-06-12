package com.vivekvishwanath.javaorders.controller

import com.vivekvishwanath.javaorders.model.Customer
import com.vivekvishwanath.javaorders.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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

    @PutMapping (value = ["/customer/update/{custCode}"],
            consumes = ["application/json"],
            produces = ["application/json"])
    fun updateCustomerByCode(@Valid @RequestBody updateCustomer: Customer,
                             @PathVariable custCode: Long): ResponseEntity<Any> {
        customerService.updateCustomer(updateCustomer, custCode)
        return ResponseEntity(HttpStatus.OK)
    }
}