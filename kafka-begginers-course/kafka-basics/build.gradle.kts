plugins {
    kotlin("jvm") version "2.0.21"
}

group = "br.com.edu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.apache.kafka:kafka-clients:3.9.0")

    implementation("org.slf4j:slf4j-api:2.0.16")

    implementation("org.slf4j:slf4j-simple:2.0.16")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}