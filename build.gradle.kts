import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
  kotlin("jvm") version "1.5.31"
  idea
}

idea {
  project {
    jdkName = "1.8"
    languageLevel = IdeaLanguageLevel("1.8")
  }
  module.name = "KotlinFramework"
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.junit.jupiter:junit-jupiter:5.7.0")
  implementation("org.accidia:protoserver:0.0.24")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
  testImplementation("io.github.bonigarcia:webdrivermanager:5.0.3")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")
  implementation("org.apache.logging.log4j:log4j-api:2.14.1")
  implementation("org.apache.logging.log4j:log4j-core:2.14.1")
//  implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
//  implementation("org.seleniumhq.selenium:selenium-api:3.141.59")
//  implementation("ru.yandex.qatools.htmlelements:htmlelements-java:1.20.0")
//  implementation("ru.sbtqa.htmlelements:htmlelements-matchers:1.17-JAVA7")
//  implementation("net.lightbody.bmp:browsermob-proxy:2.1.5")

//  implementation("com.google.inject:guice:5.0.1")
  implementation ("com.codeborne:selenide:6.0.3")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}