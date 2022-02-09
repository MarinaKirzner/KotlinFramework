import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

val junitJupiter: String by project
val accidiaProtoserver: String by project
val junitJupiterApi: String by project
val junitJupiterParams: String by project
val junitJupiterEngine: String by project
val webdrivermanager: String by project
val jacksonModuleKotlin: String by project
val jacksonDataformatYaml: String by project
val log4jApi: String by project
val log4jCore: String by project
val selenide: String by project
val okhttp3: String by project
val okhttp3LoggingInterceptor: String by project
val retrofit: String by project
val retrofitConverterGson: String by project
val wireMockVersion: String by project
val mySqlConnection: String by project
val jdbs: String by project

plugins {
  kotlin("jvm") version "1.5.31"
  idea
  id("io.qameta.allure") version "2.9.6"
}

apply(plugin = "io.qameta.allure")
apply(plugin = "org.jetbrains.kotlin.jvm")

idea {
  project {
    jdkName = "1.8"
    languageLevel = IdeaLanguageLevel("1.8")
  }
  module.name = "KotlinFramework"
}

allure {
  adapter.autoconfigure
  adapter.aspectjWeaver
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("com.vladsch.kotlin-jdbc:kotlin-jdbc:$jdbs")
  implementation("mysql:mysql-connector-java:$mySqlConnection")
  implementation("org.junit.jupiter:junit-jupiter:$junitJupiter")
  implementation("org.accidia:protoserver:$accidiaProtoserver")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterApi")
  testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterParams")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterEngine")
  testImplementation("io.github.bonigarcia:webdrivermanager:$webdrivermanager")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlin")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonDataformatYaml")
  implementation("org.apache.logging.log4j:log4j-api:$log4jApi")
  implementation("org.apache.logging.log4j:log4j-core:$log4jCore")
  implementation ("com.codeborne:selenide:$selenide")
  implementation("com.squareup.okhttp3:okhttp:$okhttp3")
  implementation("com.squareup.okhttp3:logging-interceptor:$okhttp3LoggingInterceptor")
  implementation("com.squareup.retrofit2:retrofit:$retrofit")
  implementation("com.squareup.retrofit2:converter-gson:$retrofitConverterGson")
  implementation("com.github.tomakehurst:wiremock:$wireMockVersion")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}