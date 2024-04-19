package com.whoelse.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.SQLException
import javax.sql.DataSource

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
class HikariPoolConfig : HikariConfig() {

    @Bean
    @Throws(SQLException::class)
    fun dataSource(): DataSource = HikariDataSource(this)
}