package com.eukolos.jetbrainsexposedorm.model

import org.jetbrains.exposed.dao.id.IntIdTable

object Orders : IntIdTable("orders") {
    val sku = varchar("sku", 50)
    val customerId = reference("customer_id", Customers)
}