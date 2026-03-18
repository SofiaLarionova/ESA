package ru.ssau.labs.config;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:db.properties"
)
public interface AppProperties extends Config {
    @Key("db.url")
    @DefaultValue("jdbc:postgresql://localhost:5438/")
    String getDatabaseUrl();

    @Key("db.user")
    @DefaultValue("postgres")
    String getDatabaseUser();

    @Key("db.password")
    @DefaultValue("postgres")
    String getDatabasePassword();

    @Key("date.format")
    @DefaultValue("yyyy-MM-dd")
    String getDateFormat();
}