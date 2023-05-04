package org.example.validator;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class XmlValidator {
  private Validator initValidator(String xsdPath) throws SAXException {
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Source schemaFile = new StreamSource(getFile(xsdPath));
    Schema schema = factory.newSchema(schemaFile);
    return schema.newValidator();
  }

  private File getFile(String location) {
    return new File(getClass().getClassLoader().getResource(location).getFile());
  }

  public boolean isValid(String xsdPath, String xmlPath) throws IOException, SAXException {
    Validator validator = initValidator(xsdPath);
    try {
      validator.validate(new StreamSource(getFile(xmlPath)));
      return true;
    } catch (SAXException e) {
      return false;
    }
  }
}
