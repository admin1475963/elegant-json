<img src="logo.svg" width="150px" height="50px">

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)

[![quality check](https://github.com/admin1475963/alpha-exam/actions/workflows/check.yml/badge.svg)](https://github.com/admin1475963/alpha-exam/actions/workflows/check.yml)

**Elegant JSON** is a true object-oriented library for makein JSON.
Read this blog [post](https://www.yegor256.com/2016/04/05/printers-instead-of-getters.html)
to understand main idea.

## How to use it

Maven:
```xml
<dependency>
    <groupId>io.github.admin1475963</groupId>
    <artifactId>elegant-json</artifactId>
    <version>0.1.0</version>
</dependency>
```

Project don't have any dependencies.

## Making JSON

Simple example of making JSON:
```java
new JsonObject()
    .add("Integer field", new JsonInt(5))
    .add("String field", new JsonString("Simple text"))
    .add(
        "Object field", 
        new JsonObject()
            .add("Inner field", new JsonString("Inner element"))
    )
    .toJson();
```

This code give us:
```json
{
    "Integer field": 5,
    "String field": "Simple text",
    "Object field": {
        "Inner field": "Inner element"
    }
}
```

We use classes like `JsonString`, because the method `add()` accept 
as a second paramater only instances of `JsonRepresentable`.
This classes are wrappers for primitives.

## Making JSON array

Simple example of making JSON array:
```java
new JsonArray()
    .add(new JsonString("First element"))
    .add(new JsonString("Second element"))
    .toJson();
```

This code give us:
```json
[
    "First element",
    "Second element"
]
```

## Making your object convertible to JSON

For this purpose you only implement `JsonRepresentable`.

## More complicated scenary of use

If you need that your class should return instance of `ConstructiveJsonObject`
(JsonObject simple implementation of this interface), you can implement
`JsonObjectConvertible`.

For example:
```java
public final class MyClass implements JsonObjectConvertible {
    private final String field1;
    private final String field2;
    
    // constructor and other methods
    
    @Override
    public ConstructiveJsonObject json() {
        return new JsonObject
            .add("field1", new JsonString(this.field1))
            .add("field2", new JsonString(this.field2));
    }
}
```

Now another object can add new elements to this JSON:
```java
final ConstructiveJsonObject json = new MyClass("field1", "field2").json();
json.add("field3", new JsonString("field3")).toJson();
```

This code gives:
```json
{
    "field1": "field1",
    "field2": "field2",
    "field3": "field3"
}
```

## How to contribute

If you have improvement suggestions or you find bugs, please make [issue](https://github.com/admin1475963/elegant-json/issues).
If you want make changes, please fork this repository, make changes and make pull request [issue](https://github.com/admin1475963/elegant-json/pulls).
After making changes verify it by:
```
mvn clean verify -Pquality
```

Changes not accepted if this command give any errors and warnings.
