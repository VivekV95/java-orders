package com.vivekvishwanath.javaorders.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "agents")
data class Agent(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var agentCode: Long? = null,

        var agentName: String? = null,
        var workingArea: String? = null,
        var commission: Double? = null,
        var phone: String? = null,
        var country: String? = null,

        @OneToMany(mappedBy = "agent",
                cascade = [CascadeType.ALL],
                orphanRemoval = true)
        @JsonIgnoreProperties("agents")
        var customers: MutableList<Customer>? = null,

        @OneToMany(mappedBy = "agent",
                cascade = [CascadeType.ALL],
                orphanRemoval = true)
        @JsonIgnoreProperties("agents")
        var orders: MutableList<Order>? = null
)
