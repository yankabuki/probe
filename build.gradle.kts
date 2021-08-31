plugins {
    java
    application
}

group = "com.github"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

sourceSets.main {
    java.srcDirs("src/main/java")
}

tasks.compileJava {
    options.release.set(16)
}

application {
    mainClass.set("com.github.operation.Main")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}