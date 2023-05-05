# XML Validator

An XSD validator written in Java.

## Build

```shell
mvn clean install
```

## Format

```shell
mvn com.coveo:fmt-maven-plugin:format
```

## Usage

## Executable jar

Without having to deal with linking dependencies.

```shell
java -jar target/xml-validator-1.0-SNAPSHOT-shaded.jar src/test/resources/person.xsd src/test/resources/baeldung.xml
# or
java -cp target/xml-validator-1.0-SNAPSHOT-shaded.jar org.example.validator.XmlValidator src/test/resources/person.xsd src/test/resources/baeldung.xml
# true
```

```shell
java -jar target/xml-validator-1.0-SNAPSHOT-shaded.jar src/test/resources/full-person.xsd src/test/resources/baeldung.xml
# or
java -cp target/xml-validator-1.0-SNAPSHOT-shaded.jar org.example.validator.XmlValidator src/test/resources/full-person.xsd src/test/resources/baeldung.xml
# false
```

## Java classpath

Custom dependency linking and configuration.

```shell
mvn dependency:copy-dependencies
java -cp target/dependency/*:target/xml-validator-1.0-SNAPSHOT.jar org.example.validator.XmlValidator src/test/resources/person.xsd src/test/resources/baeldung.xml
# true
```

```shell
mvn dependency:copy-dependencies
java -cp target/dependency/*:target/xml-validator-1.0-SNAPSHOT.jar org.example.validator.XmlValidator src/test/resources/full-person.xsd src/test/resources/baeldung.xml
# false
```

### Directly

```shell
mvn dependency:copy-dependencies
java -cp target/classes:target/dependency org.example.validator.XmlValidator src/test/resources/person.xsd src/test/resources/baeldung.xml
# true
```

```shell
mvn dependency:copy-dependencies
java -cp target/classes:target/dependency org.example.validator.XmlValidator src/test/resources/full-person.xsd src/test/resources/baeldung.xml
# false
```

## References

- [How to Create an Executable JAR with Maven][baeldung-jar]
- [Validate an XML File Against an XSD File][baeldung-xsd]
- [A Guide to JUnit 5][baeldung-junit]

## See also

- [An XSD Example][w3schools-xsd]

  [baeldung-jar]: https://www.baeldung.com/executable-jar-with-maven
  [baeldung-junit]: https://www.baeldung.com/junit-5
  [baeldung-xsd]: https://www.baeldung.com/java-validate-xml-xsd
  [w3schools-xsd]: https://www.w3schools.com/xml/schema_example.asp
