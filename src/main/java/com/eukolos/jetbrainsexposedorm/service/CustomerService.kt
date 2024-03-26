package com.eukolos.jetbrainsexposedorm.service

import com.eukolos.jetbrainsexposedorm.dto.CustomerDto
import com.eukolos.jetbrainsexposedorm.model.Customers
import com.eukolos.jetbrainsexposedorm.model.Orders
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
open class CustomerService {
    @Transactional
    open fun createCustomer(customerDto: CustomerDto): Int {

        val customerId = Customers.insertAndGetId {
            it[name] = customerDto.name
            it[city] = customerDto.city
        }
        setOf(UUID.randomUUID(), UUID.randomUUID())
                .map { it.toString() }
                .forEach {
                    val uuid = it
                    Orders.insert {
                        it[sku] = "sku-$uuid"
                        it[Orders.customerId] = customerId.value
                    }
                }

        return customerId.value
    }

    @Transactional
    open fun getCustomerById(id: Int): CustomerDto? {
        return Customers.selectAll().where { Customers.id eq id }.map {
            CustomerDto(
                    it[Customers.name],
                    it[Customers.city],
                    ArrayList()
            )
        }.firstOrNull()
    }

    @Transactional
    open fun getCustomerWithOrders(id: Int): CustomerDto? {
        return Customers.selectAll().where { Customers.id eq id }.map {
            CustomerDto(
                    it[Customers.name],
                    it[Customers.city],
                    Orders.selectAll().where { Orders.customerId eq id }.map {
                        it[Orders.sku]
                    }
            )
        }.firstOrNull()
    }


}
