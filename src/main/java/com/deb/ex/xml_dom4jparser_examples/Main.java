package com.deb.ex.xml_dom4jparser_examples;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.dom.DOMDocument;
import org.dom4j.dom.DOMElement;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, DocumentException {
        
        //parseXMLwithDOM4JParser();

        createXMLDocumentWithDOM4J();
    }

    private static void createXMLDocumentWithDOM4J() throws IOException {
        /*
        <?xml version = "1.0" encoding = "UTF-8" standalone = "no"?>
        <cars>
           <supercars company = "Ferrari">
              <carname type = "formula one">Ferrari 101</carname>
              <carname type = "sports">Ferrari 202</carname>
           </supercars>
        </cars>
        */
        Document document = new DOMDocument();

        Element cars = new DOMElement("cars");
        document.setRootElement(cars);

        Element supercars = new DOMElement("supercars");
        supercars.addAttribute("company", "Ferrari");
        cars.add(supercars);

        Element carname1 = new DOMElement("carname");
        carname1.addAttribute("type", "formula one");
        carname1.addText("Ferrari 101");

        Element carname2 = new DOMElement("carname");
        carname2.addAttribute("type", "sports");
        carname2.addText("Ferrari 202");

        supercars.add(carname1);
        supercars.add(carname2);

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(System.out, outputFormat);
        document.setXMLEncoding("UTF-8");
        xmlWriter.write(document);
        xmlWriter.close();
    }

    private static void parseXMLwithDOM4JParser() throws IOException, DocumentException {

        File file = new File("xml/bookstore.xml");
        Document document = new SAXReader().read(file);

        Map<String, List<Node>> categoryMap = new HashMap<>();

        Element rootElement = document.getRootElement();

        /*
        for(Iterator<Element> itr = rootElement.elementIterator(); itr.hasNext();){
            Element element = itr.next();
            System.out.println(element.getName() + "=" + element.getStringValue());
        }
        */

        List<Node> books = document.selectNodes("/bookstore/book");
        for(Node book : books){
            String category = book.valueOf("@category");
            if (!categoryMap.containsKey(category)) {
                List<Node> categoryBooks = new ArrayList<>();
                categoryBooks.add(book);
                categoryMap.put(category, categoryBooks);
            } else {
                categoryMap.get(category).add(book);
            }
        }

        display(categoryMap);
    }

    private static void display(Map<String, List<Node>> categoryMap) {
        for (Map.Entry<String, List<Node>> entry : categoryMap.entrySet()) {
            System.out.println("************************");
            System.out.println("Category:" + entry.getKey() + " has " + entry.getValue().size() + " book(s)\n");
            for (int i = 0; i < entry.getValue().size(); i++) {
                Node book = entry.getValue().get(i);
                List<Node> childNodes = book.selectNodes("*");
                for (int j = 0; j < childNodes.size(); j++) {
                    Node childNode= childNodes.get(j);
                    System.out.println(childNode.getName() + ":" + childNode.getText());
                }
                System.out.println(i == entry.getValue().size() - 1 ? "\n" : "------------------------------");
            }
        }
    }
}
