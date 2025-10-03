plugins {
    kotlin("jvm") version "2.0.21"
    antlr
}

group = "com.rpgportugal"
version = "0.1.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    antlr ("org.antlr:antlr4:4.13.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks {
    //':compileTestKotlin' uses this output of task ':generateTestGrammarSource'
    compileTestKotlin {
        dependsOn(generateTestGrammarSource)
    }

    generateGrammarSource{
        // set output directory to some arbitrary location in `/build` directory.
        // by convention `/build/generated/sources/main/java/<generator name>` is often used
        outputDirectory = file("${project.layout.buildDirectory.get()}/generated/sources/main/java/antlr")

        // pass -package to make generator put code in not default space
        arguments as MutableList += listOf("-visitor", "-package", "com.rpgportugal.dicegoblin.parser")
    }
}

sourceSets {
    main {
        java {
            // telling that output generateGrammarSource should be part of main source set
            // actuall passed value will be equal to `outputDirectory` that we configured above
            srcDir(tasks.generateGrammarSource )

        }
    }
}