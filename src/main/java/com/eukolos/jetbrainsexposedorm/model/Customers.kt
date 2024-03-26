package com.eukolos.jetbrainsexposedorm.model

import org.jetbrains.exposed.dao.id.IntIdTable

object Customers : IntIdTable("customers") {
    val name = varchar("name", 50).nullable()
    val city = varchar("city", 50)
}

