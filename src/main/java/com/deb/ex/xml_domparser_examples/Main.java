package com.deb.ex.xml_domparser_examples;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * transforming XML with XSL through Java
 */
public class Main {
    public static void main(String[] args) throws Exception {

        //transformXMLwithXSLT();

        //parseXMLwithDOMParser();

        //createXMLDocumentWithDOM();

        parseXMLWithXpath();
    }

    private static void parseXMLWithXpath() throws IOException, SAXException, ParserConfigurationException,
            XPathExpressionException {

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(new File("xml/bookstore.xml"));

        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression ="/bookstore/book";

        NodeList books = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

        extractFromNodeList(books);
    }

    private static void createXMLDocumentWithDOM() throws ParserConfigurationException, TransformerException {
        /*
        <?xml version = "1.0" encoding = "UTF-8" standalone = "no"?>
        <cars>
           <supercars company = "Ferrari">
              <carname type = "formula one">Ferrari 101</carname>
              <carname type = "sports">Ferrari 202</carname>
           </supercars>
        </cars>
        */

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        var document = documentBuilder.newDocument();

        Element cars = document.createElement("cars");
        document.appendChild(cars);

        Element supercars = document.createElement("supercars");
        supercars.setAttribute("company", "Ferrari");
        cars.appendChild(supercars);

        Element carname1 = document.createElement("carname");
        carname1.setAttribute("type", "formula one");
        carname1.setTextContent("Ferrari 101");
        supercars.appendChild(carname1);

        Element carname2 = document.createElement("carname");
        carname2.setAttribute("type", "sports");
        carname2.setTextContent("Ferrari 202");
        supercars.appendChild(carname2);

        Source source = new DOMSource(cars);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);

    }

    private static void parseXMLwithDOMParser() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(new File("xml/bookstore.xml"));

        Element root = document.getDocumentElement();
        root.normalize();

        NodeList books = root.getChildNodes();

        extractFromNodeList(books);
    }

    private static void extractFromNodeList(NodeList books) {
        Node book;
        Map<String, List<Node>> categoryMap = new HashMap<>();

        for (int i = 0; i < books.getLength(); i++) {
            book = books.item(i);
            if (book.getNodeType() == Node.ELEMENT_NODE) {
                String category = book.getAttributes().getNamedItem("category").getNodeValue();
                if (!categoryMap.containsKey(category)) {
                    List<Node> categoryBooks = new ArrayList<>();
                    categoryBooks.add(book);
                    categoryMap.put(category, categoryBooks);
                }
                else{
                    categoryMap.get(category).add(book);
                }
            }
        }

        for (Map.Entry<String, List<Node>> entry : categoryMap.entrySet()) {
            System.out.println("************************");
            System.out.println("Category:" + entry.getKey() + " has " + entry.getValue().size() + " book(s)");
            for (int i = 0; i < entry.getValue().size(); i++) {
                Node bookNode = entry.getValue().get(i);
                for (int j = 0; j < bookNode.getChildNodes().getLength(); j++) {
                    Node childNode = bookNode.getChildNodes().item(j);
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) childNode;
                        System.out.println(element.getTagName() + ":" + element.getTextContent());
                    }
                }
                System.out.println(i == entry.getValue().size() - 1 ? "\n" : "------------------------------");
            }
        }
    }

    private static void transformXMLwithXSLT() throws TransformerException, UnsupportedEncodingException {
        StreamSource sourceXml = new StreamSource(new File("xml/bookstore.xml"));
        StreamSource styleXsl = new StreamSource(new File("xml/bookstore2.xsl"));
        StreamResult resultHtmlinDoc = new StreamResult(new File("xml/bookstore2.html"));
        StreamResult resultHtmlinConsole = new StreamResult(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(styleXsl);
        //transformer.transform(sourceXml, resultHtmlinDoc);
        transformer.transform(sourceXml, resultHtmlinConsole);
    }

}
