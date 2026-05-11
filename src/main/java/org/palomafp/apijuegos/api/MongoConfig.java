package org.palomafp.apijuegos.api;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    // Spring inyectará automáticamente los valores de tu .env o GitHub Secrets aquí
    @Value("${MONGO_USER}")
    private String dbUser;

    @Value("${MONGO_PASS}")
    private String dbPass;

    @Value("${MONGO_DB}")
    private String dbName;

    @Override
    protected String getDatabaseName() {
        return dbName; // Usamos la variable para el nombre de la BD
    }

    @Override
    public MongoClient mongoClient() {
        System.out.println("🚀 IGNORANDO AUTO-CONFIGURACIÓN - FORZANDO CONEXIÓN MANUAL A ATLAS CON VARIABLES 🚀");

        // Construimos la URL usando las variables inyectadas por Spring
        String uri = "mongodb+srv://" + dbUser + ":" + dbPass + "@bd-apijuegos.v0ynuuf.mongodb.net/" + dbName + "?retryWrites=true&w=majority&appName=bd-apiJuegos";

        ConnectionString connectionString = new ConnectionString(uri);

        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}