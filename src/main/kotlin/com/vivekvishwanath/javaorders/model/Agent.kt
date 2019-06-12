package com.vivekvishwanath.javaorders.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "agents")
data class Agent(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var agentCode: Long,

        var agentName: String? = null,
        var workingArea: String? = null,
        var commission: Double? = null,
        var phone: String? = null,
        var country: String? = null,

        @OneToMany(mappedBy = "agent",
                cascade = [CascadeType.ALL],
                orphanRemoval = true)
        @JsonIgnoreProperties("agent")
        var customers: MutableList<Customer>? = mutableListOf(),

        @OneToMany(mappedBy = "agent",
                cascade = [CascadeType.ALL],
                orphanRemoval = true)
        @JsonIgnoreProperties("agent")
        var orders: MutableList<Order>? = mutableListOf()) {
        constructor(agentName: String?,
                    workingArea: String?,
                    commission: Double?,
                    phone: String?,
                    country: String?):
                this(0,
                        agentName,
                        workingArea,
                        commission,
                        phone,
                        country)
}
