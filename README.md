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

```shell
pushd target/classes; java org.example.validator.XmlValidator person.xsd baeldung.xml; popd     
# true
```

```shell
pushd target/classes; java org.example.validator.XmlValidator full-person.xsd baeldung.xml; popd
# false
```

## References

- [Validate an XML File Against an XSD File][baeldung-xsd]
- [A Guide to JUnit 5][baeldung-junit]

## See also

- [An XSD Example][w3schools-xsd]

  [baeldung-xsd]: https://www.baeldung.com/java-validate-xml-xsd
  [baeldung-junit]: https://www.baeldung.com/junit-5
  [w3schools-xsd]: https://www.w3schools.com/xml/schema_example.asp