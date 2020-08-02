plugins {
    java
}

group ="org.example"
version ="1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {

    annotationProcessor("org.projectlombok:lombok:1.18.12")//без этого не будет работать lombok
    implementation ("org.projectlombok:lombok:1.18.12")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")

    implementation ("org.springframework:spring-core:5.2.8.RELEASE")
    implementation("org.springframework:spring-beans:5.2.8.RELEASE")
    implementation("org.springframework:spring-context:5.2.8.RELEASE")
    implementation("org.springframework:spring-jdbc:5.2.8.RELEASE")
    implementation("org.liquibase:liquibase-core:3.10.2")



    runtimeOnly("mysql:mysql-connector-java:8.0.20")

    testImplementation(group="org.junit.jupiter", name="junit-jupiter-engine", version="5.6.2")
    testImplementation("org.mockito:mockito-core:3.1.0")
}
configure<JavaPluginConvention>{
    sourceCompatibility = JavaVersion.VERSION_11
}
tasks.withType<Jar>{
    manifest{
        attributes ["Main-Class"]= "ClothesProject.MenuWithGeneric.MainMenuGeneric"
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}
