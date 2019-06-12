package com.vivekvishwanath.javaorders.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "customers")
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var custCode: Long,

        @Column(nullable = false)
        var custName: String? = null,

        var custCity: String? = null,
        var workingArea: String? = null,
        var custCountry: String? = null,
        var grade: String? = null,
        var openingAmt: Double? = null,
        var receiveAmt: Double? = null,
        var paymentAmt: Double? = null,
        var outstandingAmt: Double? = null,
        var phone: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "agentCode", nullable = false)
        @JsonIgnoreProperties("customers", "hibernateLazyInitializer")
        var agent: Agent? = null,

        @OneToMany(mappedBy = "customer",
                cascade = [CascadeType.ALL],
                orphanRemoval = true)
        @JsonIgnoreProperties("customer")
        var orders: MutableList<Order>? = null) {

    constructor(custName: String?,
                custCity: String?,
                workingArea: String?,
                custCountry: String?,
                grade: String?,
                openingAmt: Double?,
                receiveAmt: Double?,
                paymentAmt: Double?,
                outstandingAmt: Double?,
                phone: String?,
                agent: Agent?) :
            this(0,
                    custName,
                    custCity,
                    workingArea,
                    custCountry,
                    grade,
                    openingAmt,
                    receiveAmt, paymentAmt,
                    outstandingAmt, phone, agent)
}
