package org.example.validator;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class XmlValidator {
  private static final Logger logger = LoggerFactory.getLogger(XmlValidator.class);

  private Validator initValidator(File xsdFile) throws SAXException {
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Source schemaFile = new StreamSource(xsdFile);
    Schema schema = factory.newSchema(schemaFile);
    return schema.newValidator();
  }

  public boolean isValid(File xsdFile, File xmlFile) throws IOException {
    logger.info("Validating {} against {}", xmlFile, xsdFile);
    try {
      initValidator(xsdFile).validate(new StreamSource(xmlFile));
    } catch (SAXException e) {
      logger.error("Encountered a parsing exception", e);
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    if (args.length < 2) {
      logger.warn("Usage: <path/to/file.xsd> <path/to/file.xml>");
      System.exit(1);
    }
    try {
      System.out.println(new XmlValidator().isValid(new File(args[0]), new File(args[1])));
    } catch (IOException e) {
      logger.error("Encountered an issue while reading file", e);
      System.exit(2);
    }
  }
}
