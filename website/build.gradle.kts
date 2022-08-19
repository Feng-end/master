import org.example.plugin.version.Libs

dependencies{

    implementation(Libs.spring_boot_starter_web)
    implementation(Libs.spring_boot_starter_security)
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    runtimeOnly("mysql:mysql-connector-java")

//    implementation(Libs.spring_boot_mongodb)
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:2.7.1")

//    implementation("com.github.xiaoymin:knife4j-spring-boot-starter:3.0.3")
    implementation("cn.hutool:hutool-all:5.7.21")
    implementation("org.apache.poi:poi-ooxml:5.0.0")

    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")

    implementation("org.projectlombok:lombok:1.18.4")

}
