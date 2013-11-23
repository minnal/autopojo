autopojo [![Build Status](https://travis-ci.org/minnal/autopojo.png)](https://travis-ci.org/minnal/autopojo)
========

Autopojo is a java library that can automatically populate the pojo objects. It provides a very simple interface and can be easily extended and customized.

What can you do with Autopojo?
------------------------------
Autopojo provides a simple interface to popuate a pojo class. You should be able to do,

```java
    AutoPojoFactory factory = new AutoPojoFactory();
    
    // Load a simple pojo class
    MySimplePojo object = factory.populate(MySimplePojo.class);
    
    // Load a nested pojo class
    NestedPojo object = factory.populate(NestedPojo.class);
    
    // Load `n` levels of nested pojo class
    NestedPojo object = factory.populate(NestedPojo.class, 3);
    
    // Load a generic pojo
    GenericPojo<String, Long> object = factory.populate(NestedPojo.class, String.class, Long.class);
    
    // And you can load a collection too
    List<SimplePojo> list = factory.populate(List.class, SimplePojo.class);
    
```

Getting Started
---------------
### Setting Up Maven

Autopojo is available as a Maven artifact and should be fairly simpler to integrate with your application. Just add the below maven dependency to your pom.xml file,

```xml
   <dependencies>
     <dependency>
       <groupId>org.minnal</groupId>
       <artifactId>autopojo</artifactId>
       <version>0.0.2</version>
     </dependency>
   </dependencies>
   
   <repositories>
     <repository>
       <id>autopojo-repo</id>
       <url>https://raw.github.com/minnal/mvn-repo/master/releases</url>
       <snapshots>
         <enabled>true</enabled>
         <updatePolicy>always</updatePolicy>
       </snapshots>
     </repository>
   </repositories>
```

If you are on a non-maven project, you will have to include these additional dependencies in addition to activejpa-core,

* commons-lang3-3.1.jar
* commons-math3-3.2.jar
* guava-14.0.1.jar
* commons-beanutils-1.8.3.jar
* slf4j-log4j12-1.7.5.jar

### Customizing pojo generation
You can pass on custom configuration to the AutoPojoFactory and control the pojo generation,

```java
      Configuration configuration = new Configuration();
      configuration.setStringPrefix("ID");
      configuration.setStringLength(10);
      configuration.setIntegerMinValue(100);
      configuration.setIntegerMaxValue(300);
      AutoPojoFactory factory = new AutoPojoFactory(configuration);
      ....
      ....
      factory.populate(...);
```

### Registering custom resolvers
There could be cases where you want to generate a pojo for custom classes. Create a custom resolver is as simple as extending the abstract resolver,

```java
      public class MyCustomClassResolver implements AttributeResolver {
          
          public void init(GenerationStrategy strategy, Configuration configuration) {
        	}
	
          public void resolve(Object pojo, AttributeMetaData attribute, int maxDepth) {
          }
          
          public Object resolve(Class<?> clazz, int maxDepth, Type... genericTypes) {
          }
      }
```

And register the resolver to the strategy as below,

```java
      GenerationStrategy strategy = new GenerationStrategy(new Configuration());
      
      // The resolver will resolve all the sub classes of MyCustomClass as well
      strategy.register(MyCustomClass.class, MyCustomClassResolver.class);
```

License
-------
Autopojo is offered under Apache License, Version 2.0
