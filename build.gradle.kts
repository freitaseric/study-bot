plugins {
    id("java")
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

application.mainClass = "me.freitaseric.studybot.Bot"
group = "me.freitaseric"
version = "1.0-SNAPSHOT"

val jdaVersion = "5.0.0-beta.22"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
    implementation("ch.qos.logback:logback-classic:1.2.8")
    implementation("net.dv8tion:JDA:$jdaVersion")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.isIncremental = true

    sourceCompatibility = "1.8"
}

tasks.test {
    useJUnitPlatform()
}