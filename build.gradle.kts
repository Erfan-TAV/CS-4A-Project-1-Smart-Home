//i was apple to get it to run when i added the application parts.
//although i use linux so idk if its different for you guys.
//id comment out the application parts if ur on windows and it doesnt work.
plugins {
    id("java")
    id("application")
}

group = "org.cs4a.project1"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.cs4a.project1.Main") // Correct property for Kotlin DSL
}