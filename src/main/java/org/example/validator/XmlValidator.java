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
  private Validator initValidator(File xsdFile) throws SAXException {
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Source schemaFile = new StreamSource(xsdFile);
    Schema schema = factory.newSchema(schemaFile);
    return schema.newValidator();
  }

  public boolean isValid(File xsdFile, File xmlFile) throws IOException {
    try {
      initValidator(xsdFile).validate(new StreamSource(xmlFile));
    } catch (SAXException e) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(new XmlValidator().isValid(new File(args[0]), new File(args[1])));
  }
}
