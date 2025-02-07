# nested-bug-reproducer

```
mvn test
```

result :

```
java.util.ServiceConfigurationError: io.smallrye.config.SmallRyeConfigBuilderCustomizer: io.quarkus.deployment.configuration.BuildTimeConfigBuilderCustomizer not a subtype
        at java.base/java.util.ServiceLoader.fail(ServiceLoader.java:593)
        at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNextService(ServiceLoader.java:1244)
        at java.base/java.util.ServiceLoader$LazyClassPathLookupIterator.hasNext(ServiceLoader.java:1273)
        at java.base/java.util.ServiceLoader$2.hasNext(ServiceLoader.java:1309)
        at java.base/java.util.ServiceLoader$3.hasNext(ServiceLoader.java:1393)
        at io.smallrye.config.SmallRyeConfigBuilder.build(SmallRyeConfigBuilder.java:757)
        at io.quarkus.deployment.configuration.BuildTimeConfigurationReader.initConfiguration(BuildTimeConfigurationReader.java:412)
        at io.quarkus.deployment.ExtensionLoader.loadStepsFrom(ExtensionLoader.java:141)
        at io.quarkus.deployment.QuarkusAugmentor.run(QuarkusAugmentor.java:107)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.runAugment(AugmentActionImpl.java:350)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.createInitialRuntimeApplication(AugmentActionImpl.java:271)
        at io.quarkus.runner.bootstrap.AugmentActionImpl.createInitialRuntimeApplication(AugmentActionImpl.java:61)
        at io.quarkus.test.junit.QuarkusMainTestExtension.doJavaStart(QuarkusMainTestExtension.java:183)
        at io.quarkus.test.junit.QuarkusMainTestExtension.doLaunch(QuarkusMainTestExtension.java:95)
        at io.quarkus.test.junit.QuarkusMainTestExtension$2.launch(QuarkusMainTestExtension.java:263)
        at org.acme.GreetingCommandTest$Nested2.test3(GreetingCommandTest.java:35)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at io.quarkus.test.junit.QuarkusMainTestExtension.interceptTestMethod(QuarkusMainTestExtension.java:303)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
```

The error occured when there is :

- 2 Nested classes or more
- launcher.launch() called in a nested class

There is no error if : 
- there is only one nested class, 
- or if launcher.launch() is not called in an nested class.