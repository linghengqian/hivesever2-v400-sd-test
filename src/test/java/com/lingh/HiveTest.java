package com.lingh;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings({"SqlDialectInspection", "SqlNoDataSourceInspection"})
public class HiveTest {

    @Test
    void test() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:hive2://localhost:2181/;serviceDiscoveryMode=zooKeeper;zooKeeperNamespace=hiveserver2;");
        config.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
        try (HikariDataSource hikariDataSource = new HikariDataSource(config);
             Connection connection = hikariDataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE DATABASE demo_ds_0");
        }
    }
}
