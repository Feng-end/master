package org.example.plugin.version

object Vers{
    const val jmock                               = "2.12.0"
    const val junit                               = "5.7.0"
    const val junit_platform                      = "1.7.0"
    const val junirocketmqt5                      = "5.4.2"
    const val mockito                             = "1.9.5"

    const val spring                              = "5.3.5"
    const val slf4j                               = "1.7.30"
    const val log4j2                              = "2.13.3"

    const val jackson                             = "2.12.3"
    const val swagger_v3                          = "2.1.11"
    const val springfox                           = "2.9.2"
    const val springdoc                           = "1.5.12"
     // const val springdoc                           = "1.6.2"
    const val open_feign                          = "10.10.1"
    const val okhttp3                             = "4.9.1"

    const val indra_octopus                       = "1.0.0.7-RELEASE"
    //const val indra_octopus                       = "1.0.0.x-SNAPSHOT"

    //const val spring_batch                        = "4.3.2"
    const val spring_cloud                        = "2020.0.2"
    //const val        spring_retry                        = "1.3.1"
    const val spring_security                     = "5.4.8"
    const val spring_boot                         = "2.4.10"
    const val spring_security_oauth2_autoconfigure= "2.4.10"
    const val spring_boot_admin                   = "2.3.1"

    const val alibaba_cloud                       = "2021.1"

    const val httpclient                          = "4.5.12"
    const val redisson                            = "3.15.6"

    const val tny_framework                       = "4.2.x-SNAPSHOT"
    const val jjwt                                = "0.11.2"

    const val rocketmq                            = "4.6.0"
    const val netty                               = "4.1.54.Final"
    const val netty_tcnative_boringssl_static     = "2.0.34.Final"
    const val rocketmq_boot                       = "2.2.1"

    const val dubbo                               = "3.0.4"

    const val indra_common                        = "1.0.0.3"

    const val kotlin_android                      = "1.6.10"
}

object Libs {
    const val slf4j_api                                ="org.slf4j:slf4j-api:${Vers.slf4j}"
    const val slf4j_simple                             ="org.slf4j:slf4j-simple:${Vers.slf4j}"
    const val log4j_over_slf4j                         ="org.slf4j:log4j-over-slf4j:${Vers.slf4j}"
    const val jcl_over_slf4j                           ="org.slf4j:jcl-over-slf4j:${Vers.slf4j}"

    const val log4j_web                                ="org.apache.logging.log4j:log4j-web"


    const val javassist                                ="org.javassist:javassist:3.27.0-GA"
    const val asm                                      ="org.ow2.asm:asm:5.0.4"


    const val disruptor                                ="com.lmax:disruptor:3.4.2"

    const val cglib_nodep                              ="cglib:cglib-nodep:3.2.0"

    const val json_smart                               ="net.minidev:json-smart:2.3"
    const val lang_tag                                 ="com.nimbusds:lang-tag:1.4.4"
    const val jackson_bom                              ="com.fasterxml.jackson:jackson-bom:${Vers.jackson}"
    const val jackson_core                             ="com.fasterxml.jackson.core:jackson-core"
    const val jackson_databind                         ="com.fasterxml.jackson.core:jackson-databind"
    const val jackson_annotations                      ="com.fasterxml.jackson.core:jackson-annotations"
    const val jackson_dataformat_yaml                  ="com.fasterxml.jackson.dataformat:jackson-dataformat-yaml"
    const val jackson_dataformat_xml                   ="com.fasterxml.jackson.dataformat:jackson-dataformat-xml"
    const val jackson_datatype_guava                   ="com.fasterxml.jackson.datatype:jackson-datatype-guava"
    const val jackson_datatype_java8                   ="com.fasterxml.jackson.datatype:jackson-datatype-jdk8"


    const val fastjson                                 ="com.alibaba:fastjson:1.2.73"
    const val validation_api                           ="javax.validation:validation-api:2.0.1.Final"
    const val netty_all                                ="io.netty:netty-all:4.1.54.Final"
    const val netty_tcnative_boringssl_static          ="io.netty:netty-tcnative-boringssl-static:${Vers.netty_tcnative_boringssl_static}"

    const val orika                                    ="ma.glasnost.orika:orika-core:1.5.4"
    const val oshi_core                                ="com.github.oshi:oshi-core:5.2.2"


    const val indra_octopus_bom                        ="com.indrasoft:octopus-bom:${Vers.indra_octopus}"
    const val indra_octopus_common                     ="com.indrasoft:octopus-common"
    const val indra_octopus_boot                       ="com.indrasoft:octopus-boot"
    const val indra_octopus_client                     ="com.indrasoft:octopus-client"
    const val indra_octopus_cloud                      ="com.indrasoft:octopus-cloud"
    const val indra_octopus_redis                      ="com.indrasoft:octopus-redis"
    const val indra_octopus_mongo                      ="com.indrasoft:octopus-mongo"
    const val indra_octopus_sharding                   ="com.indrasoft:octopus-sharding"
    const val indra_octopus_scheduler                  ="com.indrasoft:octopus-scheduler"
    const val indra_octopus_oauth2                     ="com.indrasoft:octopus-oauth2"
    const val indra_octopus_cluster                    ="com.indrasoft:octopus-cluster"
    const val indra_octopus_topic                      ="com.indrasoft:octopus-topic"
    const val indra_octopus_topic_rocketmq             ="com.indrasoft:octopus-topic-rocketmq"
    const val indra_octopus_topic_timing               ="com.indrasoft:octopus-topic-timing"
    const val indra_octopus_web                        ="com.indrasoft:octopus-web"

    const val commons_codec                            ="commons-codec:commons-codec:1.14"
    const val commons_io                               ="commons-io:commons-io:2.8.0"
    const val commons_beanutils                        ="commons-beanutils:commons-beanutils:1.9.4"
    const val commons_daemon                           ="commons-daemon:commons-daemon:1.2.3"
    const val commons_lang                             ="commons-lang:commons-lang:2.6"
    const val commons_collections                      ="commons-collections:commons-collections:3.2.2"
    const val commons_configuration                    ="commons-configuration:commons-configuration:1.10"
    const val commons_lang3                            ="org.apache.commons:commons-lang3:3.11"
    const val commons_collections4                     ="org.apache.commons:commons-collections4:4.4"
    const val commons_pool2                            ="org.apache.commons:commons-pool2:2.8.1"
    const val commons_crypto                           ="org.apache.commons:commons-crypto:1.1.0"
    const val httpclient                               ="org.apache.httpcomponents:httpclient"
    const val okio                                     ="com.squareup.okio:okio:2.10.0"
    const val okhttp                                   ="com.squareup.okhttp:okhttp:2.7.5"
    const val okhttp3                                  ="com.squareup.okhttp3:okhttp:${Vers.okhttp3}"
    const val okhttp3_logging_interceptor              ="com.squareup.okhttp3:logging-interceptor:${Vers.okhttp3}"
    const val druid                                    ="com.alibaba:druid:1.1.16"



    const val zookeeper                                ="org.apache.zookeeper:zookeeper:3.4.14"

    const val quartz                                   ="org.quartz-scheduler:quartz:2.3.1"

    const val xstream                                  ="com.thoughtworks.xstream:xstream:1.4.11.1"

    const val guava                                    ="com.google.guava:guava:30.0-jre"
    const val google_api_client                        ="com.google.api-client:google-api-client:1.31.1"
    const val google_api_oauth2                        ="com.google.auth:google-auth-library-oauth2-http:0.22.0"
    const val joda_time                                ="joda-time:joda-time:2.10.2"

    const val junit_jupiter_api                        ="org.junit.jupiter:junit-jupiter-api:${Vers.junit}"
    const val junit_jupiter_engine                     ="org.junit.jupiter:junit-jupiter-engine:${Vers.junit}"
    const val junit_vintage_engine                     ="org.junit.vintage:junit-vintage-engine:${Vers.junit}"
    const val junit_platform_launcher                  ="org.junit.platform:junit-platform-launcher:${Vers.junit_platform}"
    const val junit_platform_commons                   ="org.junit.platform:junit-platform-commons:${Vers.junit_platform}"

    const val byte_buddy                               ="net.bytebuddy:byte-buddy:1.10.14"
    const val byte_buddy_agent                         ="net.bytebuddy:byte-buddy-agent:1.10.14"

    const val spring_messaging                         ="org.springframework:spring-messaging"

    //const val        spring_retry                             ="org.springframework.retry:spring-retry:$Vers.spring_retry"
    //  const val      spring_batch_core                        ="org.springframework.batch:spring-batch-core:$Vers.spring_batch"

    const val spring_boot_dependencies                 ="org.springframework.boot:spring-boot-dependencies:${Vers.spring_boot}"

    const val spring_security_oauth2_boot_autoconfigure="org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure:${Vers.spring_security_oauth2_autoconfigure}"
    const val spring_boot                              ="org.springframework.boot:spring-boot"
    const val spring_boot_autoconfigure                ="org.springframework.boot:spring-boot-autoconfigure:${Vers.spring_boot}"
    const val spring_boot_configuration_processor      ="org.springframework.boot:spring-boot-configuration-processor"
    const val spring_boot_starter                      ="org.springframework.boot:spring-boot-starter"
    const val spring_boot_starter_test                 ="org.springframework.boot:spring-boot-starter-test"
    const val spring_boot_starter_web                  ="org.springframework.boot:spring-boot-starter-web"
    const val spring_boot_starter_undertow             ="org.springframework.boot:spring-boot-starter-undertow"
    const val spring_boot_starter_thymeleaf            ="org.springframework.boot:spring-boot-starter-thymeleaf"
    const val spring_boot_starter_webflux              ="org.springframework.boot:spring-boot-starter-webflux"
    const val spring_boot_starter_tomcat               ="org.springframework.boot:spring-boot-starter-tomcat"
    const val spring_boot_starter_actuator             ="org.springframework.boot:spring-boot-starter-actuator"
    const val spring_boot_starter_aop                  ="org.springframework.boot:spring-boot-starter-aop"
    const val spring_boot_starter_log4j2               ="org.springframework.boot:spring-boot-starter-log4j2"
    const val spring_boot_devtools                     ="org.springframework.boot:spring-boot-devtools"
    const val spring_boot_mongodb                      ="org.springframework.boot:spring-boot-starter-data-mongodb"
    const val spring_boot_redis                        ="org.springframework.boot:spring-boot-starter-data-redis"
    const val spring_boot_starter_security             ="org.springframework.boot:spring-boot-starter-security"
    const val spring_boot_starter_validation           ="org.springframework.boot:spring-boot-starter-validation"
    const val spring_boot_starter_amqp                 ="org.springframework.boot:spring-boot-starter-amqp"
    const val spring_boot_starter_cache                ="org.springframework.boot:spring-boot-starter-cache"
    //const val        spring_boot_starter_oauth2_resource_server="org.springframework.boot:spring-boot-starter-oauth2-resource-server"
    //const val        spring_boot_starter_oauth2_client         ="org.springframework.boot:spring-boot-starter-oauth2-client"
    //const val        spring_security_jwt                       ="org.springframework.security:spring-security-jwt:$Vers.spring_security_jwt"
//const val        spring_security_oauth2                     ="org.springframework.security.oauth:spring-security-oauth2:$Vers.spring_security_oauth2"
    const val spring_boot_session_data_redis           ="org.springframework.session:spring-session-data-redis"
    const val spring_boot_starter_batch                ="org.springframework.boot:spring-boot-starter-batch"
    const val spring_boot_starter_websocket            ="org.springframework.boot:spring-boot-starter-websocket"


    const val spring_security_bom                      ="org.springframework.security:spring-security-bom:${Vers.spring_security}"
    const val spring_security_jose                     ="org.springframework.security:spring-security-oauth2-jose"
    const val spring_security_oauth2                   ="org.springframework.security:spring-security-oauth2"
    const val spring_security_core                     ="org.springframework.security:spring-security-core"
    const val spring_security_oauth2_client            ="org.springframework.security:spring-security-oauth2-client"
    const val spring_security_oauth2_resource_server   ="org.springframework.security:spring-security-oauth2-resource-server"


    const val spring_cloud_dependencies                ="org.springframework.cloud:spring-cloud-dependencies:${Vers.spring_cloud}"
    const val spring_cloud_commons                     ="org.springframework.cloud:spring-cloud-commons"
    const val spring_cloud_config_server               ="org.springframework.cloud:spring-cloud-config-server"
    const val spring_cloud_starter_security            ="org.springframework.cloud:spring-cloud-starter-security"
    const val spring_cloud_starter_config              ="org.springframework.cloud:spring-cloud-starter-config"
    const val spring_cloud_starter_sleuth              ="org.springframework.cloud:spring-cloud-starter-sleuth"
    const val spring_cloud_starter_loadbalancer        ="org.springframework.cloud:spring-cloud-starter-loadbalancer"
    const val spring_cloud_starter_bootstrap           ="org.springframework.cloud:spring-cloud-starter-bootstrap"
    const val spring_cloud_starter_openfeign           ="org.springframework.cloud:spring-cloud-starter-openfeign"
    const val spring_cloud_starter_oauth2              ="org.springframework.cloud:spring-cloud-starter-oauth2"
    const val spring_cloud_starter_gateway             ="org.springframework.cloud:spring-cloud-starter-gateway"
    const val spring_cloud_starter_eureka_server       ="org.springframework.cloud:spring-cloud-starter-netflix-eureka-server"
    const val spring_cloud_starter_eureka_client       ="org.springframework.cloud:spring-cloud-starter-netflix-eureka-client"
    const val spring_cloud_starter_hystrix             ="org.springframework.cloud:spring-cloud-starter-netflix-hystrix"
    const val spring_cloud_starter_zookeeper_discovery ="org.springframework.cloud:spring-cloud-starter-zookeeper-discovery"
    const val spring_boot_admin_dependencies           ="de.codecentric:spring-boot-admin-dependencies:${Vers.spring_boot_admin}"
    const val spring_boot_admin_starter_server         ="de.codecentric:spring-boot-admin-starter-server"
    const val spring_core                              ="org.springframework:spring-core"
    const val spring_boot_starter_json                 ="org.springframework.boot:spring-boot-starter-json"

    const val alibaba_nacos_client                     ="com.alibaba.nacos:nacos-client:2.0.3"
    const val alibaba_cloud_dependencies               ="com.alibaba.cloud:spring-cloud-alibaba-dependencies:${Vers.alibaba_cloud}"

    const val alibaba_cloud_stream_binder_rocketmq     ="com.alibaba.cloud:spring-cloud-stream-binder-rocketmq"
    const val alibaba_cloud_starter_bus_rocketmq       ="com.alibaba.cloud:spring-cloud-starter-bus-rocketmq"
    const val alibaba_cloud_starter_stream_rocketmq    ="com.alibaba.cloud:spring-cloud-starter-stream-rocketmq"
    const val alibaba_cloud_starter_nacos_config       ="com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config"
    const val alibaba_cloud_starter_nacos_discovery    ="com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery"
    const val alibaba_cloud_starter_sentinel           ="com.alibaba.cloud:spring-cloud-starter-alibaba-sentinel"
    const val alibaba_cloud_starter_sentinel_datasource="com.alibaba.cloud:spring-cloud-alibaba-sentinel-datasource"
    const val alibaba_cloud_starter_dubbo              ="com.alibaba.cloud:spring-cloud-starter-dubbo"
    const val sentinel_datasource_nacos                ="com.alibaba.csp:sentinel-datasource-nacos"



    const val smalldoc_spring_boot_starter             ="com.github.liuhuagui:smalldoc-spring-boot-starter:2.3.1"

    const val open_feign_jackson                       ="io.github.openfeign:feign-jackson:${Vers.open_feign}"

    const val tny_common_base                          ="com.tny.game:tny-game-common-base:${Vers.tny_framework}"
    const val tny_common_lang                          ="com.tny.game:tny-game-common-lang:${Vers.tny_framework}"
    const val tny_doc                                  ="com.tny.game:tny-game-doc:${Vers.tny_framework}"
    const val tny_doc_annotation                       ="com.tny.game:tny-game-doc-annotation:${Vers.tny_framework}"
    const val tny_web                                  ="com.tny.game:tny-game-web:${Vers.tny_framework}"
    const val tny_loader                               ="com.tny.game:tny-game-loader:${Vers.tny_framework}"
    const val tny_suite                                ="com.tny.game:tny-game-suite:${Vers.tny_framework}"
    const val tny_protoex                              ="com.tny.game:tny-game-protoex:${Vers.tny_framework}"

    const val protobuf_java                            ="com.google.protobuf:protobuf-java:3.8.0"
    const val jprotobuf                                ="com.baidu:jprotobuf:2.4.4"
    const val jprotobuf_precompile_plugin_gradle       ="gradle.plugin.com.baidu.jprotobuf:jprotobuf-precompile-plugin-gradle:1.0.8"

    const val swagger_models                           ="io.swagger.core.v3:swagger-models:${Vers.swagger_v3}"
    const val swagger_annotations                      ="io.swagger.core.v3:swagger-annotations:${Vers.swagger_v3}"
    const val springdoc_openapi_core                   ="org.springdoc:springdoc-openapi-core:${Vers.springdoc}"
    const val springdoc_openapi_ui                     ="org.springdoc:springdoc-openapi-ui:${Vers.springdoc}"
    const val springdoc_openapi_webmvc_core            ="org.springdoc:springdoc-openapi-webmvc-core:${Vers.springdoc}"
    const val springdoc_openapi_data_rest ="org.springdoc:springdoc-openapi-data-rest:${Vers.springdoc}"
    const val springdoc_openapi_security  ="org.springdoc:springdoc-openapi-security:${Vers.springdoc}"
    const val springdoc_openapi_webflux_ui="org.springdoc:springdoc-openapi-webflux-ui:${Vers.springdoc}"

    const val aspectjrt                   ="org.aspectj:aspectjrt:1.9.5"
    const val aspectj_weaver                   ="org.aspectj:aspectjweaver:1.9.9.1"

    const val jjwt_api                    ="io.jsonwebtoken:jjwt-api:${Vers.jjwt}"
    const val jjwt_impl                   ="io.jsonwebtoken:jjwt-impl:${Vers.jjwt}"
    const val jjwt_jackson                ="io.jsonwebtoken:jjwt-jackson:${Vers.jjwt}"
    const val java_jwt                    ="com.auth0:java-jwt:3.10.0"
    const val nimbus_jose_jwt             ="com.nimbusds:nimbus-jose-jwt:9.15.2"
    const val nimbus_oauth2_oidc_sdk      ="com.nimbusds:oauth2-oidc-sdk:8.21"


    const val kaptcha                     ="com.github.penggle:kaptcha:2.3.2"
    const val mail                        ="com.sun.mail:javax.mail:1.6.2"
    const val mail_api                    ="javax.mail:javax.mail-api:1.6.2"
    const val libphonenumber              ="com.googlecode.libphonenumber:libphonenumber:8.12.3"
    const val carrier                     ="com.googlecode.libphonenumber:carrier:1.129"
    const val aliyun_java_sdk_core        ="com.aliyun:aliyun-java-sdk-core:4.5.0"
    const val alipay_easy_sdk             ="com.alipay.sdk:alipay-easysdk:2.2.0"
    const val wechatpay_api               ="com.github.wechatpay-apiv3:wechatpay-apache-httpclient:0.4.2"

    const val caffeine                    ="com.github.ben-manes.caffeine:caffeine:2.8.8"

    const val redisson                    ="org.redisson:redisson:${Vers.redisson}"
    const val redisson_spring_data        ="org.redisson:redisson-spring-data-24:${Vers.redisson}"
    const val redisson_spring_boot_starter="org.redisson:redisson-spring-boot-starter:${Vers.redisson}"


    const val rocketmq_acl                ="org.apache.rocketmq:rocketmq-acl:${Vers.rocketmq}"
    const val rocketmq_client             ="org.apache.rocketmq:rocketmq-client:${Vers.rocketmq}"
    const val rocketmq_common             ="org.apache.rocketmq:rocketmq-common:${Vers.rocketmq}"
    const val rocketmq_logging            ="org.apache.rocketmq:rocketmq-logging:${Vers.rocketmq}"
    const val rocketmq_spring_boot        ="org.apache.rocketmq:rocketmq-spring-boot:${Vers.rocketmq_boot}"
    const val rocketmq_spring_boot_starter="org.apache.rocketmq:rocketmq-spring-boot-starter:${Vers.rocketmq_boot}"
    const val micrometer_core             ="io.micrometer:micrometer-core:1.5.5"
    const val reactor_extra               ="io.projectreactor.addons:reactor-extra:3.3.3.RELEASE"
    const val reactor_core                ="io.projectreactor:reactor-core:3.3.5.RELEASE"

    const val spring_web                  ="org.springframework:spring-web"

    const val tencentcloud_sdk_java                    ="com.tencentcloudapi:tencentcloud-sdk-java:4.0.11"
    const val tencentcloud_cos_sdk                     ="com.qcloud:cos_api:5.6.39"

    const val dubbo_spring_boot_starter                ="org.apache.dubbo:dubbo-spring-boot-starter:${Vers.dubbo}"

    // =============================================================================

    const val indra_common_bom                         ="com.indrasoft.commons:commons-common-bom:${Vers.indra_common}"
    const val indra_common_core                        ="com.indrasoft.commons:commons-common-core"
    const val indra_common_web_base                    ="com.indrasoft.commons:commons-common-web-base"

    const val uidcenter_app_api_client                 ="com.indrasoft.uidcenter:uidcenter-app-api-client:1.0.0.x-20211009.141208-1"

    const val tssjni_common_core                       ="com.indrasoft.tss:tssjni-common-core:1.0.0.1"
}