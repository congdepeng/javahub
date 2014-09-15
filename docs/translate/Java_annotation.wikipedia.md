#Java 注解

Java编程语言中的注解，是一个能添加到Java源代码中的语法元数据形式。 类，方法，变量，参数和包都可以被注解。和Javadoc的tags不一样，Java注解能够嵌入到编译器生成的类文件中，并可以在Java虚拟机运行期以反射的形式来取得注解。（不光是编译器可以将注解嵌入类文件）

概要

1 历史
2 JVM内置注解
3 例子xample
3.1 内置
3.2 自定义
4 处理
5 进一步
6 引用
7 外部链接
##一，历史
Java平台有多种专用的注解机制----例如，transient修饰符，或者@Deprecated。通用的注解（或称为元数据）方式由JSR-175在2002年引入并与2004年9月通过。注解终于在JDK1.5的时候，得以在java语言中使用。

## 二，内置注解
Java语言定于并内置了一组注解。
Java代码中的注解：
@Override -.检查该方法是否是重写的。如果方法不能在父类或者实现的接口中找到，将报一个编译错误。
```java
public class Override {

    //java: method does not override or implement a method from a supertype
    @Override
    public void oo() {
        System.out.println("over");
    }
}
```
@Deprecated - 废弃方法
@SuppressWarnings - 指示编译器忽略警告
```java
 @SuppressWarnings("unchecked")
    public static void warning() {
        ArrayList objects = new ArrayList();
        objects.add("ss");
        objects.add(11);
    }
```
应用到注解上的注解：（高阶注解？）
 - @Retention - . 指示所标注的注解如何保存---只是代码中还是编译进class文件或者在运行期间可以通过反射访问。
从@Override的定义可以看出，它的@Retention只在源代码中检查，JVM根本不检查是否是Override，因此编译到class里面没有意义。
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
```

- @Documented - 标注这个注解要不要在Java Doc生成引用文档。
- @Target - 标明了被注解的注解的应用范围，例如是只能应用到方法上的Override注解。（@Target(ElementType.METHOD)）
- @Inherited - .标明一个注解是否可以被子类继承到。（默认不加该标注就是不继承）

结论：
1.如果子类继承父类，并且重写了父类中的带有注解的方法，那么父类方法上的注解是不会被子类继承的。
2.如果子类继承父类，但是没有重写父类中带有注解的方法，那么父类方法上的注解会被子类继承，就是说在子类中可以得到父类方法上的注解。

##举例
###内置注解
该例演示了@Override注解的使用。该注解指示编译器去检查父类的对应方法。在代码所示的情况下，子类的getttype（）方法无法找到父类的对应方法（大小写不匹配），因此会有一个编译器错误。如果没有@Override的提示，子类就有写错方法的风险。
```java
public class Animal {
    public void speak() {
    }
 
    public String getType() {
        return "Generic animal";
    }
}
 
public class Cat extends Animal {
    @Override
    public void speak() { // This is a good override.
        System.out.println("Meow.");
    }
 
    @Override
    public String gettype() { // Compile-time error due to mistyped name.
        return "Cat";
    }
}
```
## 自定义注解
注解类型的定义和接口定义很相似。区别是在interface关键字前面多一个@符号。因为注解的本质是“元数据”，因此每一个注解中的方法都看成是一个元素，而且方法定义不可以包含参数而且不能抛出异常。方法的返回值类型也受到限制，只能是原始类型，String，Class，enums，注解和前面列举的类型的数组。方法可以有默认值。
```java 
// @Twizzle is an annotation to method toggle().
  @Twizzle
  public void toggle() {
  }
 
  // Declares the annotation Twizzle.
  public @interface Twizzle {
  }
```

注解一般包括一组可选的键值对。
```java 
  public @interface Edible {
      boolean value() default false;
  }

// Same as: @Edible(value = true)
  @Edible(true)
  Item item = new Carrot();
 ```

 ```java
  public @interface Author {
      String first();
      String last();
  }

  @Author(first = "Oompah", last = "Loompah")
  Book book = new Book();
```	
注解本身也需要注解来说明它将在何时何处使用
```java 
@Retention(RetentionPolicy.RUNTIME) // Make this annotation accessible at runtime via reflection.
  @Target({ElementType.METHOD})       // This annotation can only be applied to class methods.
  public @interface Tweezable {
  }
```

编译器因为语法原因，也预留了一组特殊的注解（例如@Deprecated, @Override 和 @SuppressWarnings）

注解经常在框架中大量应用，例如如果框架需要和用户自定义的类和方法集成，往往需在外部资源（例如XML配置文件）定义关系或者需要编程来实现（API调用），而注解可以很方便的应用此类行为。例如下面是被注解的JPA数据类:

```java
@Entity                                             //定义这是一个entity bean
@Table(name = "people")                 // 映射这个bean到 SQL 表 "people"
public class Person implements Serializable {
    @Id                                                                           // 映射id为主键
    @GeneratedValue(strategy = GenerationType.AUTO) //数据库负责生成主键
    private Integer id;
 
    @Column(length = 32)                     
    private String name;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}
```
注解不是方法调用，注解不影响代码本身语义，它是自包含的。然后，这个class对象在运行期被传递到JPA的实现，然后提取注解来生成ORM。

一个复杂的例子如下：
```java
package com.annotation;
 
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,
 ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE,
 ElementType.PACKAGE,ElementType.FIELD,ElementType.LOCAL_VARIABLE})
@Inherited
 
public @interface Unfinished {
    public enum Priority { LOW, MEDIUM, HIGH }
    String value();
    String[] changedBy() default "";
    String[] lastChangedBy() default "";
    Priority priority() default Priority.MEDIUM;
    String createdBy() default "James Gosling";
    String lastChanged() default "2011-07-08";
}

package com.annotation;
 
public @interface UnderConstruction {
    String owner() default "Patrick Naughton";
    String value() default "Object is Under Construction.";
    String createdBy() default "Mike Sheridan";
    String lastChanged() default "2011-07-08";
}

package com.validators;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
 
import com.annotation.UnderConstruction;
import com.annotation.Unfinished;
import com.annotation.Unfinished.Priority;
import com.util.Util;
 
@UnderConstruction(owner="Navin Gujarish")
public class DateValidator implements Validator {
 
    public void validate(FacesContext context, UIComponent component, Object value)
        throws ValidatorException
    {
        String date = (String) value;
        String errorLabel = "Please enter a valid date.";
        if (!component.getAttributes().isEmpty())
        {
            errorLabel = (String) component.getAttributes().get("errordisplayval");
        }
 
        if (!Util.validateAGivenDate(date))
        {
            @Unfinished(changedBy = "Steve",
                value = "whether to add message to context or not, confirm",
                priority = Priority.HIGH
            )
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary(errorLabel);
            message.setDetail(errorLabel);
            throw new ValidatorException(message);
        }
    }
}
```
##注解处理器
当java源代码编译之后，注解能够被编译器的注解处理器插件处理。该处理器能生成信息消息或者创建额外的java源代码或者资源文件，然后继续被编译处理，甚至修改注解代码本身。编译器根据存储策略（CLASS或者RUNTIME）来有条件的往class文件中存储注解的元数据，然后JVM或者其他程序能够读取此类元数据来决定如何和程序交互或者改变他们的行为。

除了用注解处理器来处理注解，Java程序员可以写代码用反射来处理注解。Java SE5在java.lang.reflect包中提供了一个新的接口AnnotatedElement，这个接口被java反射类实现，例如Class，Constructor，Field，Method和Package. 实现了这个接口来表示当前运行在JVM中的程序的一个注解元素。这个接口使得注解能够被反射读取。
```java

package java.lang.reflect;

import java.lang.annotation.Annotation;

/**
 * 代表了本VM中当前正在运行的程序的一个注解元素。本接口运行通过反射来读取注解。
* 所有本接口返回的注解都是不可变且可以序列化的。
 *
 */
public interface AnnotatedElement {
    /**
     * 如果一个制定的注解应用到了该元素上，返回true，反之false.  
     * 
     * @param annotationClass  注解类  
     * @return true
     * @since 1.5
     */
     boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);

   /**
     * 返回本元素的制定的注解，如果不存在则返回null，为的是得到该注解的特定值
     * @param annotationClass 注解类型
     * @return this element's annotation for the specified annotation type if
     *     present on this element, else null
     * @throws NullPointerException if the given annotation class is null
     * @since 1.5
     */
    <T extends Annotation> T getAnnotation(Class<T> annotationClass);

    /**
     * 返回一个array，包含该元素所有的注解。
     *
     * @return all annotations present on this element
     * @since 1.5
     */
    Annotation[] getAnnotations();

    /**
     * 返回纯注解，不包括继承的
     *
     * @return All annotations directly present on this element
     * @since 1.5
     */
    Annotation[] getDeclaredAnnotations();
}


```
AnnotatedElement接口提供对含有RUNTIME属性的注解的访问功能。因为注解类型是编译后存储在字节码中的，所以注解可以像类对象一样返回给反射的方法调用。下面是一个复杂的注解处理示例：

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
 
// This is the annotation to be processed
// Default for Target is all Java Elements
// Change retention policy to RUNTIME (default is CLASS)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeHeader {
    // Default value specified for developer attribute
    String developer() default "Unknown";
    String lastModified();
    String [] teamMembers();
    int meaningOfLife();
}
 
// This is the annotation being applied to a class
@TypeHeader(developer = "Bob Bee",
    lastModified = "2013-02-12",
    teamMembers = { "Ann", "Dan", "Fran" },
    meaningOfLife = 42)
 
public class SetCustomAnnotation {
    // Class contents go here
}
 
// This is the example code that processes the annotation
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
 
public class UseCustomAnnotation {
    public static void main(String [] args) {
        Class<SetCustomAnnotation> classObject = SetCustomAnnotation.class;
        readAnnotation(classObject);
    }
 
    static void readAnnotation(AnnotatedElement element) {
        try {
            System.out.println("Annotation element values: \n");
            if (element.isAnnotationPresent(TypeHeader.class)) {
                // getAnnotation returns Annotation type
                Annotation singleAnnotation = 
                        element.getAnnotation(TypeHeader.class);
                TypeHeader header = (TypeHeader) singleAnnotation;
 
                System.out.println("Developer: " + header.developer());
                System.out.println("Last Modified: " + header.lastModified());
 
                // teamMembers returned as String []
                System.out.print("Team members: ");
                for (String member : header.teamMembers())
                    System.out.print(member + ", ");
                System.out.print("\n");
 
                System.out.println("Meaning of Life: "+ header.meaningOfLife());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
```
##See also
- JSR 250: Common Annotations for the Java Platform
- CLI Attributes
- Java programming
- Java virtual machine
- Model-driven architecture
- Python decorators, inspired by Java annotations, which have a similar syntax.
References[edit]
Jump up^ "Annotations". Sun Microsystems. Retrieved 2011-09-30..
Jump up^ Sun Microsystems (2005). Java(TM) Language Specification (3rd ed.). Prentice Hall. ISBN 0-321-24678-0.
Jump up^ [Obasanjo] (2007). "A COMPARISON OF MICROSOFT'S C# PROGRAMMING LANGUAGE TO SUN MICROSYSTEMS' JAVA PROGRAMMING LANGUAGE: Metadata Annotations". Dare Obasanjo. Archived from the original on 2007. Retrieved 2012-09-20.
Jump up^ Coward, Danny (2006-11-02). "JSR 175: A Metadata Facility for the JavaTM Programming Language". Java Community Process. Retrieved 2008-03-05.
Jump up^ http://www.java2s.com/Tutorial/Java/0020__Language/TheBuiltInAnnotations.htm
External links[edit]
An Introduction to Java Annotations by M. M. Islam Chisty
Introduction to Java 5.0 Annotations by Joy Christy
Introduction to Java 6 Annotations at Sun Developer Network Site
Of Java Annotations by John Hunt
Custom Annotations in Java
Categories: 
Java programming language

