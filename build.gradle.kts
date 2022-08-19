
// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.example.plugin.version.*
import org.jetbrains.kotlin.backend.wasm.lower.excludeDeclarationsFromCodegen

plugins {
    id("org.example.plugin.version")
    id("java-gradle-plugin")
    id ("java")
    id("org.springframework.boot"). version("2.4.10"). apply(false)
//    id("io.spring.dependency-management") version("1.0.11.RELEASE") apply(false)
    id("io.spring.dependency-management") version("1.0.11.RELEASE")
    id("com.github.johnrengelman.processes") version("0.5.0") apply(false)
    id("org.springdoc.openapi-gradle-plugin") version("1.3.3") apply(false)

//    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.3.RELEASE")
    }
}


allprojects{
    this.repositories {
        mavenLocal()
        mavenCentral()
    }

}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "org.example.plugin.version")
//    apply(plugin = "java-gradle-plugin")


    apply (plugin="org.springframework.boot")
    apply (plugin="io.spring.dependency-management")
    apply (plugin="com.github.johnrengelman.processes")
    apply (plugin="org.springdoc.openapi-gradle-plugin")


    dependencyManagement {
        imports {
            mavenBom(Libs.spring_cloud_dependencies)
            mavenBom(Libs.alibaba_cloud_dependencies)
            mavenBom(Libs.spring_boot_dependencies)

        }
    }

}




