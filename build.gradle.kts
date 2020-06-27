plugins {
    java
}

group ="org.example"
version ="1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
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

