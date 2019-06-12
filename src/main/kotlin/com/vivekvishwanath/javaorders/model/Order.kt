package com.vivekvishwanath.javaorders.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var ordNum: Long,

        var ordAmount: Double,
        var advanceAmount: Double,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "custCode", nullable = false)
        @JsonIgnore
        var customer: Customer? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "agentCode", nullable = false)
        @JsonIgnore
        var agent: Agent? = null,

        var ordDescription: String? = null) {

    constructor(ordAmount: Double,
                advanceAmount: Double,
                customer: Customer?,
                agent: Agent?,
                ordDescription: String?) : this(0,
            ordAmount, advanceAmount, customer, agent, ordDescription)
}