#Java 8 Tutorial
2014年3月16日
> “Java is still not dead—and people are starting to figure that out.”


欢迎阅读这个Java 8教程，我将在此一步步的演示所有新加的特性。这些简短的代码的示例将教会你如何使用默认接口方法，lambda表达式，方法引用和可重复的注解。
在文章的最后将介绍最新的API改进，例如streams，函数式接口，map扩展和新的日期API。
我尽量避免大段的文字描述---取而代之的是一段段加了注释的代码片段，开始吧!

## 默认的接口方法

Java 8可以在接口里面定义非抽象（non-abstract）的方法，只要在方法定义的时候加上**default**关键字。这个特性还有一个名称叫“扩展方法”。

```java
interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
```

**Formula**接口除了定义了抽象的**calculate**方法外，还定义了一个默认方法**sqrt**。 实现类只需要实现抽象的**calculate**方法，至于默认的**sqrt**方法是可以直接使用的。

```java
Formula formula = new Formula() {
    @Override
    public double calculate(int a) {
        return sqrt(a * 100);
    }
};

formula.calculate(100);     // 100.0
formula.sqrt(16);           // 4.0
```


上面代码中的formula是实现接口的一个匿名对象。这段代码看起来很啰嗦：6行代码就完成了一个如此简单的计算。在下一个章节，我们将看到Java 8中有一个更优雅的方法来实现单个方法的对象（single method objects ）。


# Lambda 表达式
让我们看看在之前的java版本中如何对一个由String组成的列表进行排序：

```java
List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
});
```

静态的实用方法**Collections.sort**接受一个列表和一个比较器作为参数。通常我们自己创建一个匿名的比较器然后传递给此方法。
为了避免总是创建一个匿名对象，Java 8带来了一个更简短的语法，lambda表达式：

```java
Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});
```

正如你所见，代码更短更具可读性了。但是还可以更简短，对于单行方法体你可以省略花括号和**return**关键字：

```java

    Collections.sort(names, (String a, String b) -> b.compareTo(a));

```


美妙的是，还可以更简短：

```java

    Collections.sort(names, (a, b) -> b.compareTo(a));

```

Java编译器可以根据上下文分析出参数类型，因此你可以把参数类型也省略掉。让我们更深入的学习如何广泛的使用lambda表达式吧。


## 函数式接口

那么lambda表达式是如何整合进Java的类型系统的呢？（译注：Java有任何新概念的加入都试图往面向对象上靠前科。）每一个lambda都关联到一个由接口限定的给定的类型。所谓函数式接口~~functional interface~~必须包含一个且只由一个抽象的方法定义。每一个这种类型的lambda表达式将匹配到这个抽象方法。因为默认方法不是抽象的，你可以添加任意多的默认方法到你的函数式接口中。
How does lambda expressions fit into Javas type system? Each lambda corresponds to a given type, specified by an interface. A so called functional interface must contain exactly one abstract method declaration. Each lambda expression of that type will be matched to this abstract method. Since default methods are not abstract you're free to add default methods to your functional interface.
我们可以把任意的只含有一个抽象方法的接口看成是lambda表达式。为了确保你的接口满足这个要求，你应该给接口添加一个**@FunctionalInterface**注解。编译器将处理这个注解，如果发现超过1个抽象方法就抛出一个异常。
举个例子:

```java
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
Integer converted = converter.convert("123");
System.out.println(converted);    // 123
```

值得注意的是上面的代码如果却是**@FunctionalInterface **注解仍然可以正常工作。
（译注：看，Java又一次将lambda绑定到了面向对象的接口上面。）


## 方法引用和构造器引用

利用静态方法的引用，上面的示例代码能够进一步的简化：

```java
Converter<String, Integer> converter = Integer::valueOf;
Integer converted = converter.convert("123");
System.out.println(converted);   // 123
```

Java 8允许你使用::关键字来传递方法或者构造器的引用。上面的代码演示了如何引用一个静态的方法引用。而且我们还可以引用对象的方法：

```java
class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

Something something = new Something();
Converter<String, String> converter = something::startsWith;
String converted = converter.convert("Java");
System.out.println(converted);    // "J"
```

让我们来看看**::**关键字如何调用构造器。首先定义一个包含2个构造器的示例bean：

```java
class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
```


接下来我们定义一个person factory接口来创建person对象：

```java
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
```

我们通过构造器引用将这一切联系起来，而不是像以前那样需要首先实现工厂接口：

```java
PersonFactory<Person> personFactory = Person::new;
Person person = personFactory.create("Peter", "Parker");
```
通过**Person::new**，我们创建了一个Person构造器的引用。Java编译器根据**PersonFactory.create**的参数信息自动的选择匹配的构造器。


## Lambda 作用域
在lambda表达式中访问外层作用域的变量的方式和匿名对象访问外层作用域类似。你可以访问所有声明为final的实例变量或者静态变量。

###访问本地变量
lambda表达式可以访问外层的final局部变量：

```java
final int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);

stringConverter.convert(2);     // 3
```

但是和匿名对象不同的是，此处的final不是必须的：
```java
int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);

stringConverter.convert(2);     // 3
```
然而**num**其实有隐式的final约束，下面的代码无法编译：
```java
int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);
num = 3;
```
在lambda内部试图改变num也是不被允许的。（但是难道不是传值吗？）


###访问静态变量和类字段

和局部变量不同的是，我们可以在lambda中访问和修改实例属性和静态变量。这种行为我们在使用匿名对象的时候已经很熟悉了。
```java
class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}
```

###访问默认接口方法
还记得第一节里面的例子吗？接口**Formula**定义了一个默认方法**sqrt**，该方法可以被所有实现接口的对象（包括匿名对象）使用。可惜的是在lambda表达式中无法访问。
默认方法不能被lambda表达式调用，下面的代码无法编译。
```java

Formula formula = (a) -> sqrt( a * 100);
```

## 内置的函数式接口
JDK 1.8 API包含许多内置的函数式接口。其中有一些在之前的版本中我们已经很熟悉了，例如，**Comparator 或 Runnable**。通过使用**@FunctionalInterface**注解，些接口已经被扩展到支持lambda表达式。
同时，为了让你的工作很轻松，Java 8 API也包含了一组新的函数式接口。某些新的接口在[Google Guava](https://code.google.com/p/guava-libraries/)库中已经被广泛接受。尽管你已经很熟悉Guava，但是仍然值得好好留意一下这些接口。

###断言（Predicates）
Predicates接口拥有一个只接受单一参数并返回布尔值的test函数。另外此接口还包含多个默认方法，从而组合成复杂的逻辑（默认方法是and，or和negate）。

```java
Predicate<String> predicate = (s) -> s.length() > 0;

predicate.test("foo");              // true
predicate.negate().test("foo");     // false

Predicate<Boolean> nonNull = Objects::nonNull;
Predicate<Boolean> isNull = Objects::isNull;

Predicate<String> isEmpty = String::isEmpty;
Predicate<String> isNotEmpty = isEmpty.negate();
```

##函数（Functions）
Functions 接受单一参数并处理后返回一个结果。默认方法可以用来将多个函数串成一个链式调用（默认方法有compose，andThen）。
```java
Function<String, Integer> toInteger = Integer::valueOf;
Function<String, String> backToString = toInteger.andThen(String::valueOf);

backToString.apply("123");     // "123"
```
##Suppliers
Suppliers 产出一个指定类型的对象结果。和Functions不一样，Suppliers不需要参数。（译注：不需要输入，保证有一个返回值。其实泛型可以算作是它的一个隐式输入。）
```java
Supplier<Person> personSupplier = Person::new;
personSupplier.get();   // new Person
```

###Consumers
Consumers 代表了对单个输入执行操作的行为。
（译注：必须有一个输入，另外泛型可以看成是一个隐式输入。）

```java
    Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
    greeter.accept(new Person("Luke", "Skywalker"));

```

###Comparators

Comparators 在之前的版本已经普遍使用。 Java 8 给这个接口添加了多种默认方法。

```java
Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

Person p1 = new Person("John", "Doe");
Person p2 = new Person("Alice", "Wonderland");

comparator.compare(p1, p2);             // > 0
comparator.reversed().compare(p1, p2);  // < 0
```

###Optionals
Optionals 不是函数式接口，而是非常漂亮的防范**NullPointerException**的实用类。这是下一节中非常重要的一个概念，让我们快速的看一下Optionals是如何工作的吧。
Optional 是一个可能为空的值的简单容器。假设一个方法可能返回非空（non-null）结果同时也可能返回null。现在你可以返回Optional而不是直接返回一个null了。
```java
Optional<String> optional = Optional.of("bam");

optional.isPresent();           // true
optional.get();                 // "bam"
optional.orElse("fallback");    // "bam"

optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
```

## Streams
**java.util.Stream**代表了一系列上面可以执行一个或多个操作的元素。Stream操作可以分为中间操作或者终止调用。当操作终止时，返回一个确定类型的结果，而中间的操作返回一个Stream对象自身（self），因此你可以将多个方法调用链在一行代码中。Streams由集合数据源创建（例如实现**java.util.Collection**的lists或者sets）。Stream的操作可以是顺序的（sequential）或者并行的。
让我们首先看一下顺序的Streams，第一步创建一个有String组合的list数据源：
```java
List<String> stringCollection = new ArrayList<>();
stringCollection.add("ddd2");
stringCollection.add("aaa2");
stringCollection.add("bbb1");
stringCollection.add("aaa1");
stringCollection.add("bbb3");
stringCollection.add("ccc");
stringCollection.add("bbb2");
stringCollection.add("ddd1");
```
Java 8 中的Collections已经经过了扩展，调用**Collection.stream()**或者**Collection.parallelStream()**，你就可以很简单的创建Streams。下面的章节将介绍常见的Stream操作。

### Filter
Filter接受一个Predicate来过滤Stream中的元素，此操作属于一个中间操作，从而我们可以在结果上调用另一个Stream操作（forEach）。forEach接受一个consumer来做具体过滤的过滤每个元素的工作。forEach是一个终止操作，而且它的返回类型是void，因此我们不能在它后面继续做Stream操作。
```java
stringCollection
    .stream()
    .filter((s) -> s.startsWith("a"))
    .forEach(System.out::println);

// "aaa2", "aaa1"
```
### Sorted
Sorted是一个中间操作，用来返回一个排序后的Stream源的快照。默认元素按照自然排序，当然你可以传递一个定制化的Comparator。

```java
stringCollection
    .stream()
    .sorted()
    .filter((s) -> s.startsWith("a"))
    .forEach(System.out::println);

// "aaa1", "aaa2"
```
需要指明的是**sorted**仅仅是创建一个排序后的快照而不是直接在原始数据源上修改。**stringCollection**的顺序保持不变：

```java
System.out.println(stringCollection);
// ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1
```
### Map
中间操作**map**通过给定的函数来将每个元素转换为其他对象。下面的例子将每一个字符串转换为全大写的字符串。当然你也可以用**map**将每个对象转换为非字符串。返回值的类型由你传递给**map**的函数的泛型决定。

```java
stringCollection
    .stream()
    .map(String::toUpperCase)
    .sorted((a, b) -> b.compareTo(a))
    .forEach(System.out::println);

// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
```
### Match

多样的Match操作可以用来检验某个Stream是否匹配给定的predicate。这些操作都是终止操作并返回一个布尔结果。
```java
boolean anyStartsWithA =
    stringCollection
        .stream()
        .anyMatch((s) -> s.startsWith("a"));

System.out.println(anyStartsWithA);      // true

boolean allStartsWithA =
    stringCollection
        .stream()
        .allMatch((s) -> s.startsWith("a"));

System.out.println(allStartsWithA);      // false

boolean noneStartsWithZ =
    stringCollection
        .stream()
        .noneMatch((s) -> s.startsWith("z"));

System.out.println(noneStartsWithZ);      // true
```

### Count
Cout是一个终止操作，以long类型返回Stream中元素的个数。
（译注：因为int类型只有4G，所以返回long比较保险。）
```java
long startsWithB =
    stringCollection
        .stream()
        .filter((s) -> s.startsWith("b"))
        .count();

System.out.println(startsWithB);    // 3
```

### Reduce
这个终止操作使用给定的函数在Stream的元素上执行缩减（reduction）行为。操作的返回结果是一个持有reduced value的Optional。
```java
Optional<String> reduced =
    stringCollection
        .stream()
        .sorted()
        .reduce((s1, s2) -> s1 + "#" + s2);

reduced.ifPresent(System.out::println);
// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
```

### Parallel Streams
上面提到，Streams可以是顺序的也可以是并行的（parallel）。顺序的Streams上的操作是单线程的，而并行Streams的操作是在多个线程上并发（concurrent）执行的。
下面的示例演示了使用并行Streams来提高性能是如何的简便.
首先我们创建一个拥有大量唯一元素的列表：
```java
int max = 1000000;
List<String> values = new ArrayList<>(max);
for (int i = 0; i < max; i++) {
    UUID uuid = UUID.randomUUID();
    values.add(uuid.toString());
}
```

现在我们测算对这个集合的Stream进行排序的时间：
#### Sequential Sort
```java
long t0 = System.nanoTime();

long count = values.stream().sorted().count();
System.out.println(count);

long t1 = System.nanoTime();

long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
System.out.println(String.format("sequential sort took: %d ms", millis));

// sequential sort took: 899 ms
```

####Parallel Sort

```java
long t0 = System.nanoTime();

long count = values.parallelStream().sorted().count();
System.out.println(count);

long t1 = System.nanoTime();

long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
System.out.println(String.format("parallel sort took: %d ms", millis));

// parallel sort took: 472 ms
```
正如你看到的，2个代码片段几乎一样，但是并行排序大约快了50%。你唯一要做的就是把stream() 改成 parallelStream()。


## Map
前面已经提到了，maps不支持Streams。取而代之的是maps现在支持多种全新而有效的方法来解决常见任务。
```java
Map<Integer, String> map = new HashMap<>();

for (int i = 0; i < 10; i++) {
    map.putIfAbsent(i, "val" + i);
}

map.forEach((id, val) -> System.out.println(val));
```

从上面的代码中很容易看出来：** putIfAbsent**是为了让我们少写额外的非空判断；**forEach**接受一个Consumer来给map中的每个value执行操作。
下面的例子演示如何使用实用函数：
```java
map.computeIfPresent(3, (num, val) -> val + num);
map.get(3);             // val33

map.computeIfPresent(9, (num, val) -> null);
map.containsKey(9);     // false

map.computeIfAbsent(23, num -> "val" + num);
map.containsKey(23);    // true

map.computeIfAbsent(3, num -> "bam");
map.get(3);             // val33
```

下面，学习如何根据给定的key和value组合来移除一个实体（entries）。
```java
map.remove(3, "val3");
map.get(3);             // val33

map.remove(3, "val33");
map.get(3);             // null
```

还有一个非常有帮助的方法是：
```java
map.getOrDefault(42, "not found");  // not found
```

合并（Merge）map的值也变得非常简单：
```java
map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
map.get(9);             // val9

map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
map.get(9);             // val9concat
```

如果找不到匹配的就插入，找到就使用合并函数来合并。

## Date API
Java 8 提供来一个全新的日期和时间API，位于**java.time**包下面。这个新的日期API和[Joda-Time](http://www.joda.org/joda-time/)类似，但是又[不完全一样](http://blog.joda.org/2009/11/why-jsr-310-isn-joda-time_4941.html)。下面的例子包含了这个新API大多数重要的部分。
### Clock
Clock 提供了对当前日期和时间的访问。Clocks能够意识到时区的不同，用来替换**System.currentTimeMillis()**来取得当前毫秒。另外**Instant**类用来创建旧的**java.util.Date**对象。
```java
Clock clock = Clock.systemDefaultZone();
long millis = clock.millis();

Instant instant = clock.instant();
Date legacyDate = Date.from(instant);   // legacy java.util.Date
```

### Timezones
时区由ZoneId来表示。可以通过静态工厂方法方便的创建时区。时区定义了偏移量，这在Instant和本地时间的互相转换时非常重要。
```java
System.out.println(ZoneId.getAvailableZoneIds());
// prints all available timezone ids

ZoneId zone1 = ZoneId.of("Europe/Berlin");
ZoneId zone2 = ZoneId.of("Brazil/East");
System.out.println(zone1.getRules());
System.out.println(zone2.getRules());

// ZoneRules[currentStandardOffset=+01:00]
// ZoneRules[currentStandardOffset=-03:00]
```

### LocalTime
LocalTime表示一个没有时区的时间，例如，10pm或者17:30:15。下面的例子创建来两个本地时间。然后我们比较时间并计算时间差。
```java
LocalTime now1 = LocalTime.now(zone1);
LocalTime now2 = LocalTime.now(zone2);

System.out.println(now1.isBefore(now2));  // false

long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

System.out.println(hoursBetween);       // -3
System.out.println(minutesBetween);     // -239
```

LocalTime 附带来多样的工厂方法来简化创建和处理时间问题。
```java
LocalTime late = LocalTime.of(23, 59, 59);
System.out.println(late);       // 23:59:59

DateTimeFormatter germanFormatter =
    DateTimeFormatter
        .ofLocalizedTime(FormatStyle.SHORT)
        .withLocale(Locale.GERMAN);

LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
System.out.println(leetTime);   // 13:37
```

### LocalDate
LocalDate代表了一个唯一的日期，例如2014-03-11。它是不可变的。
```java
LocalDate today = LocalDate.now();
LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
LocalDate yesterday = tomorrow.minusDays(2);

LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
System.out.println(dayOfWeek);    // FRIDAY
```

根据string创建LocalDate：
```java
DateTimeFormatter germanFormatter =
    DateTimeFormatter
        .ofLocalizedDate(FormatStyle.MEDIUM)
        .withLocale(Locale.GERMAN);

LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
System.out.println(xmas);   // 2014-12-24
```

### LocalDateTime
LocalDateTime 代表了date-time. 它将data和time组合成一个对象。同时它也是不可变的，用起来与LocalTime 和 LocalDate类似。
```java
LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
System.out.println(dayOfWeek);      // WEDNESDAY

Month month = sylvester.getMonth();
System.out.println(month);          // DECEMBER

long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
System.out.println(minuteOfDay);    // 1439
```

给定时区后，LocalDateTime可以方便的转换为Instant，然后转换成旧的** java.util.Date**.
```java
Instant instant = sylvester
        .atZone(ZoneId.systemDefault())
        .toInstant();

Date legacyDate = Date.from(instant);
System.out.println(legacyDate);     // Wed Dec 31 23:59:59 CET 2014
```

格式化date-times的过程和格式化dates或者times类似。除了预定义的格式，我们也可以自定义日期格式。
```java
DateTimeFormatter formatter =
    DateTimeFormatter
        .ofPattern("MMM dd, yyyy - HH:mm");

LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
String string = formatter.format(parsed);
System.out.println(string);     // Nov 03, 2014 - 07:13
```

和**java.text.NumberFormat**不一样，新的**DateTimeFormatter**是不可变而且是线程安全的。
更多细节见[这里](http://download.java.net/jdk8/docs/api/java/time/format/DateTimeFormatter.html)。

## Annotations
注解在Java 8中是可以重复的。让我们直接来看代码吧。
首先，我们定义一个包装器注解来持有一个实际注解的数组：
```java
@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}
```

Java 8中通过使用**@Repeatable**注解来声明相同类型的注解可以重复出现。
 - 样式 1: 使用注解当容器 (旧样式)
```java
@Hints({@Hint("hint1"), @Hint("hint2")})
class Person {}
```
 - 样式 2: 使用可重复注解 (新样式)
```java
@Hint("hint1")
@Hint("hint2")
class Person {}
```

使用样式2的话，Java编译器隐式的设置了@Hints注解。这对通过反射来取得注解信息非常重要。
```java
Hint hint = Person.class.getAnnotation(Hint.class);
System.out.println(hint);                   // null

Hints hints1 = Person.class.getAnnotation(Hints.class);
System.out.println(hints1.value().length);  // 2

Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
System.out.println(hints2.length);          // 2
```

尽管我们从未定义@Hints注解并在Person类上使用，它仍然可以通过**getAnnotation(Hints.class)**来读取到。然而更方便的方法是**getAnnotationsByType**, 它可以直接访问所有的@Hint注解。
另外Java 8新加了2个targets：
```java
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@interface MyAnnotation {}
```

## 就到这里吧
本Java 8编程指南就到此收尾。当然肯定还有大量值得讨论的细节，这取决于你想不想继续探索JDK 8。稍微列举一下例如**Arrays.parallelSort,StampedLock **和**CompletableFuture** 都值得一看。
我希望这篇文章对你有所帮助且读起来比较舒服。所有的[示例代码](https://github.com/winterbe/java8-tutorial)都放在Github。


这是中文翻译，[原文](http://winterbe.com/posts/2014/03/16/java-8-tutorial/)请看这里。
