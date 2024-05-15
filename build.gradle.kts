plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.h2database:h2:2.2.224")

    implementation ("com.zaxxer:HikariCP:5.0.0")

    implementation("org.slf4j:slf4j-nop:2.0.6")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}