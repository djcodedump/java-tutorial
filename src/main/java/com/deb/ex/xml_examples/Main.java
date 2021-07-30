package com.deb.ex.xml_examples;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * transforming XML with XSL through Java
 */
public class Main {
    public static void main(String[] args) throws Exception{

        StreamSource sourceXml =  new StreamSource(new File("xml/bookstore.xml"));
        StreamSource styleXsl =  new StreamSource(new File("xml/bookstore2.xsl"));
        StreamResult resultHtml = new StreamResult(new File("xml/bookstore2.html"));

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(styleXsl);
        transformer.transform(sourceXml, resultHtml);
    }
}
