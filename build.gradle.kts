plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.4.1"
    id("org.liquibase.gradle") version "2.0.3"
}

version = "0.1"
group = "com.datapublisher"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.rxjava2:micronaut-rxjava2")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    // reactor http
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.5")
    implementation("io.micronaut.reactor:micronaut-reactor")
    implementation("io.micronaut.reactor:micronaut-reactor-http-client")
    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation("io.micronaut.liquibase:micronaut-liquibase")
    implementation("io.micronaut.sql:micronaut-vertx-pg-client")
    implementation("io.micronaut.liquibase:micronaut-liquibase")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.sql:micronaut-vertx-pg-client")
    runtimeOnly("org.postgresql:postgresql")


    liquibaseRuntime("org.liquibase:liquibase-core:3.8.1")
    liquibaseRuntime("jakarta.xml.bind:jakarta.xml.bind-api:2.3.2")
    liquibaseRuntime("org.postgresql:postgresql:42.2.24")

    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:testcontainers")

    implementation("com.ongres.scram:client:2.1")
    implementation("javax.annotation:javax.annotation-api")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}


application {
    mainClass.set("com.datapublisher.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}


micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("com.datapublisher.*")
    }
}





