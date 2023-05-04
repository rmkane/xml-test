package org.example.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class XmlValidatorTest {
  @Test
  public void givenValidXML_WhenIsValid_ThenTrue() throws IOException, SAXException {
    assertTrue(new XmlValidator().isValid("person.xsd", "baeldung.xml"));
  }

  @Test
  public void givenInvalidXML_WhenIsValid_ThenFalse() throws IOException, SAXException {
    assertFalse(new XmlValidator().isValid("full-person.xsd", "baeldung.xml"));
  }
}
