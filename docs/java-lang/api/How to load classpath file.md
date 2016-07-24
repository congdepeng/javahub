
# 有时候需要从classpath的路径下读文件（例如配置文件，或者jar或者class）

## 取得一个配置文件的全路经
```java
     InputStream is = SmartLoggerTest.class.getResourceAsStream("/logback-test.xml");
           URL resource = SmartLoggerTest.class.getResource("/logback-test.xml");
           System.out.println(resource);
           String file = resource.getFile();
           System.out.println(file);

            file:/home/com.depeng/github/xxx/Modules/core/target/classes/logback-test.xml
            /home/com.depeng/github/xxx/Modules/core/target/classes/logback-test.xml

```

## 或者读一个class文件
```java
    URL resource = SmartLoggerTest.class.getResource("/com/com.depeng/core/HostPort.class");
          System.out.println(resource);
                  InputStream is = SmartLoggerTest.class.getResourceAsStream("/com/com.depeng/core/HostPort.class");
          System.out.println(is);


                     file:/home/com.depeng/github/xx/core/target/classes/com/com.depeng/core/HostPort.class
                     java.io.BufferedInputStream@498edd8d

```

上面的代码无法找到org/slf4j/impl/StaticLoggerBinder.class，虽然StaticLoggerBinder是在classpath内的某个jar里面。为什么呢？
读一下getResource的方法签名文档，文档中指名该方法会委托具体的工作到其Classoader上。



## 如何得到ClassLoader

```java
      ClassLoader testclassLoader = SmartLoggerTest.class.getClassLoader();
          ClassLoader stringclassLoader = String.class.getClassLoader();
          ClassLoader classLoader = int.class.getClassLoader();

          System.out.println("================");
          System.out.println(testclassLoader);                    //sun.misc.Launcher$AppClassLoader@4821e115
          System.out.println(stringclassLoader);                  //null
          System.out.println(classLoader);                        //null
          System.out.println(ClassLoader.getSystemClassLoader()); //sun.misc.Launcher$AppClassLoader@4821e115
          System.out.println("================");
```

**其中比较奇怪的是**
```java
    InputStream is = char.class.getResourceAsStream("org/slf4j/impl/StaticLoggerBinder.class");
    InputStream is = String.class.getResourceAsStream("org/slf4j/impl/StaticLoggerBinder.class");

    char 和String的classloader都所null，但是上一条语句能找到 StaticLoggerBinder，而下一条找不到，Java太坑爹了！！！！！！！！！！！！！！！！！！！！

```



## 如果想从classpath包含的全部的文件里面找一个class文件呢？
```java
        Enumeration<URL> systemResources = ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class");
        while (systemResources.hasMoreElements()) {
            System.out.println(systemResources.nextElement());
        }
```