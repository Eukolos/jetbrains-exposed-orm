package com.eukolos.jetbrainsexposedorm.configuration

import com.eukolos.jetbrainsexposedorm.model.Customers
import com.eukolos.jetbrainsexposedorm.model.Orders
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.deleteAll

class SchemaInitializer private constructor() {
    companion object {
        fun init() {
            SchemaUtils.create(Orders, Customers)
            Orders.deleteAll()
            Customers.deleteAll()
        }
    }
}