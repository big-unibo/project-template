import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.github.ngbinh.scalastyle.ScalaStyleTask

plugins {
    java
    scala
    idea // eclipse
    id("com.github.johnrengelman.shadow") version "5.2.0"
    checkstyle
}

apply(plugin = "scalaStyle")

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("com.github.jengelman.gradle.plugins", "shadow", "5.2.0")
        classpath("org.github.ngbinh.scalastyle", "gradle-scalastyle-plugin_2.11", "1.0.1")
    }
}

tasks.named<ShadowJar>("shadowJar") {
    isZip64 = true
}

tasks.named<Javadoc>("javadoc") {
    isFailOnError = true
}

tasks.named<ScalaStyleTask>("scalaStyle") {
    configLocation = "config/scalastyle_config.xml"
    includeTestSourceDirectory = true
    source("src/main/scala")
    testSource = "src/test/scala"
    verbose = true
    failOnViolation = true
    failOnWarning = true
}

// In this section you declare where to find the dependencies of your project
repositories {
    jcenter()
    mavenCentral()
    maven("https://repository.cloudera.com/artifactory/cloudera-repos/")
}

// To download sources and javadoc
/*eclipse {
    classpath {
        isDownloadJavadoc = true
        isDownloadSources =true
    }
}*/

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

dependencies {
    implementation("com.google.guava", "guava", "21.0")
    implementation("org.apache.commons", "commons-math3", "3.6.1")
    implementation("org.scala-lang", "scala-library", "2.11.12")
    implementation("org.scala-lang", "scala-reflect", "2.11.12")
    implementation("org.scala-lang", "scala-compiler", "2.11.12")
    implementation("org.slf4j", "slf4j-api", "1.7.30")
    testCompileOnly("org.slf4j", "slf4j-simple", "1.7.30")
    // Uncomment these dependencies only if you are working with Spark
    // implementation("org.apache.spark", "park-core_2.11", ".4.0-cdh6.2.0")
    // implementation("org.apache.spark", "park-sql_2.11", ".4.0-cdh6.2.0")
    // implementation("org.apache.spark", "park-hive_2.11", ".4.0-cdh6.2.0")
    // implementation("org.apache.spark", "park-mllib_2.11", ".4.0-cdh6.2.0")
    // implementation("org.datasyslab", "eospark", ".2.0")
    // implementation("org.datasyslab", "eospark-sql_2.3", ".2.0")
    // implementation("org.datasyslab", "eospark-viz_2.3", ".2.0")
    testImplementation("junit", "junit", "4.12")
}

// tasks to run by executing ./gradlew
defaultTasks("clean", "build", "check", "javadoc", "scalaStyle", "shadowJar")
