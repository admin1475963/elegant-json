<img src="logo.png" width="150px" height="50px">

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)

[![quality check](https://github.com/admin1475963/alpha-exam/actions/workflows/check.yml/badge.svg)](https://github.com/admin1475963/alpha-exam/actions/workflows/check.yml)

**Elegant JSON** is a true object-oriented library for makein JSON.
Read this blog [post](https://www.yegor256.com/2016/04/05/printers-instead-of-getters.html)
to understand main idea.

**ATTENTION** This library is in alpha version, and the API may change.
Please use it at your own risk.

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


## How to contribute

If you have improvement suggestions or you find bugs, please make [issue](https://github.com/admin1475963/elegant-json/issues).
If you want make changes, please fork this repository, make changes and make [pull request](https://github.com/admin1475963/elegant-json/pulls).
After making changes verify it by:
```
mvn clean verify -Pquality
```

Changes not accepted if this command give any errors and warnings.
