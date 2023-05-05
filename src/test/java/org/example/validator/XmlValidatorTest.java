package org.example.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class XmlValidatorTest {
  private File getFile(String location) {
    return new File(getClass().getClassLoader().getResource(location).getFile());
  }

  @Test
  public void givenValidXML_WhenIsValid_ThenTrue() throws IOException, SAXException {
    assertTrue(new XmlValidator().isValid(getFile("person.xsd"), getFile("baeldung.xml")));
  }

  @Test
  public void givenInvalidXML_WhenIsValid_ThenFalse() throws IOException, SAXException {
    assertFalse(new XmlValidator().isValid(getFile("full-person.xsd"), getFile("baeldung.xml")));
  }
}
