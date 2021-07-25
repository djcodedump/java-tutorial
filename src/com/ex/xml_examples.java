package com.ex;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.Properties;

public class xml_examples {
    public static void main(String[] args) throws Exception{

        StreamSource sourceXml =  new StreamSource(new File("xml/bookstore.xml"));
        StreamSource styleXsl =  new StreamSource(new File("xml/bookstore2.xsl"));
        StreamResult resultHtml = new StreamResult(new File("xml/bookstore2.html"));

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(styleXsl);
        transformer.transform(sourceXml, resultHtml);
    }
}
