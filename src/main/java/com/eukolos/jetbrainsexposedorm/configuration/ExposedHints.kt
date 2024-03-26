package com.eukolos.jetbrainsexposedorm.configuration

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.api.PreparedStatementApi
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.springframework.aot.hint.MemberCategory
import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar
import org.springframework.core.io.ClassPathResource


class ExposedHints : RuntimeHintsRegistrar {

    override fun registerHints(hints: RuntimeHints, classLoader: ClassLoader?) {

        arrayOf(
                org.jetbrains.exposed.spring.DatabaseInitializer::class,
                org.jetbrains.exposed.spring.SpringTransactionManager::class,
                java.util.Collections::class,
                Column::class,
                Database::class,
                Op::class,
                Op.Companion::class,
                DdlAware::class,
                Expression::class,
                ExpressionWithColumnType::class,
                ColumnType::class,
                DatabaseConfig::class,
                IColumnType::class,
                IntegerColumnType::class,
                PreparedStatementApi::class,
                ForeignKeyConstraint::class,
                IColumnType::class,
                QueryBuilder::class,
                Table::class,
                Transaction::class,
                TransactionManager::class,
                Column::class,
                Database::class,
                kotlin.jvm.functions.Function0::class,
                kotlin.jvm.functions.Function1::class,
                kotlin.jvm.functions.Function2::class,
                kotlin.jvm.functions.Function3::class,
                kotlin.jvm.functions.Function4::class,
                kotlin.jvm.functions.Function5::class,
                kotlin.jvm.functions.Function6::class,
                kotlin.jvm.functions.Function7::class,
                kotlin.jvm.functions.Function8::class,
                kotlin.jvm.functions.Function9::class,
                kotlin.jvm.functions.Function10::class,
                kotlin.jvm.functions.Function11::class,
                kotlin.jvm.functions.Function12::class,
                kotlin.jvm.functions.Function13::class,
                kotlin.jvm.functions.Function14::class,
                kotlin.jvm.functions.Function15::class,
                kotlin.jvm.functions.Function16::class,
                kotlin.jvm.functions.Function17::class,
                kotlin.jvm.functions.Function18::class,
                kotlin.jvm.functions.Function19::class,
                kotlin.jvm.functions.Function20::class,
                kotlin.jvm.functions.Function21::class,
                kotlin.jvm.functions.Function22::class,
                kotlin.jvm.functions.FunctionN::class
        )
                .map { it.java }
                .forEach {
                    hints.reflection().registerType(it, *MemberCategory.values())
                }

        arrayOf("META-INF/services/org.jetbrains.exposed.dao.id.EntityIDFactory",
                "META-INF/services/org.jetbrains.exposed.sql.DatabaseConnectionAutoRegistration",
                "META-INF/services/org.jetbrains.exposed.sql.statements.GlobalStatementInterceptor")
                .map { ClassPathResource(it) }
                .forEach { hints.resources().registerResource(it) }
    }

}
