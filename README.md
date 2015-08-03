javahub
=======

Java language stuff. 
 
 



  ## Prerequisites Installation 

* JKD
* Gradle(JDK 1.5+, ships with Groovy lib, set GRADLE_HOME/bin, GRADLE_OPTS is optional)
    - Install
        - for OS X
            - brew install gradle
        - for Linux
            - download gradle.zip and unzip to '/home/../../gradle'
    - export GRADLE_HOME='/home/../../gradle'
    - export PATH=$GRADLE_HOME/bin:$PATH

* Gradle daemon

```
touch ~/.gradle/gradle.properties && echo "org.gradle.daemon=true" >> ~/.gradle/gradle.properties
```

  ## Directory Structure

    * src : java source code
    * docs : markdown documents
    * [gradle]
        - gradle/wrapper
        - build : classes and resources
        - build.gradle : like maven pom.xml file
        - settings.gradle : global setting
