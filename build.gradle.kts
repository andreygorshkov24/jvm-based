plugins {
  java
  id("com.github.spotbugs") version "6.0.0"
  kotlin("jvm") version "2.0.0-Beta2"
}

group = "com.andreygorshkov24"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  val junitVersion = "5.10.0"
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
  testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
}

tasks.compileKotlin {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "17"
  }
}

tasks.jar {
  manifest {
    attributes(
      "Main-Class" to "com.andreygorshkov24.Main"
    )
  }
}

tasks.spotbugsMain {
  enabled = true
  maxHeapSize.set("512m")
  reports.create("html") {
    required.set(true)
    outputLocation.set(file("$buildDir/reports/spotbugs.html"))
    setStylesheet("fancy-hist.xsl")
  }
}

tasks.spotbugsTest {
  enabled = false
}

tasks.test {
  useJUnitPlatform()
}
