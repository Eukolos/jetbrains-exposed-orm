package com.eukolos.jetbrainsexposedorm.model

import org.jetbrains.exposed.sql.SchemaUtils

class SchemaInitializer private constructor() {
    companion object {
        fun init() {
            SchemaUtils.create(Orders, Customers)
        }
    }
}