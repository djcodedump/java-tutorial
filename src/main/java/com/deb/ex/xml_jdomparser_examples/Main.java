package com.deb.ex.xml_jdomparser_examples;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, JDOMException {

        //parseXMLwithJDOMParser();

        createXMLDocumentWithJDOM();
    }

    private static void createXMLDocumentWithJDOM() throws IOException {
        /*
        <?xml version = "1.0" encoding = "UTF-8" standalone = "no"?>
        <cars>
           <supercars company = "Ferrari">
              <carname type = "formula one">Ferrari 101</carname>
              <carname type = "sports">Ferrari 202</carname>
           </supercars>
        </cars>
        */
        Document xmlDocument = new Document();

        Element cars = new Element("cars");
        xmlDocument.addContent(cars);

        Element supercars = new Element("supercars");
        supercars.setAttribute("company","Ferrari");


        Element carname1 = new Element("carname");
        carname1.setAttribute("type","formula one");
        carname1.setText("Ferrari 101");

        Element carname2 = new Element("carname");
        carname2.setAttribute("type","sports");
        carname2.setText("Ferrari 202");

        supercars.addContent(carname1);
        supercars.addContent(carname2);

        cars.addContent(supercars);

        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.setFormat(Format.getPrettyFormat());
        xmlOutputter.output(xmlDocument, System.out);
    }

    private static void parseXMLwithJDOMParser() throws JDOMException, IOException {
        Document document = new SAXBuilder().build(new File("xml/bookstore.xml"));

        Element rootElement = document.getRootElement();

        Map<String, List<Element>> categoryMap = new HashMap<>();

        List<Element> books = rootElement.getChildren();
        for (Element book : books) {
            String category = book.getAttribute("category").getValue();
            if (!categoryMap.containsKey(category)) {
                List<Element> categoryBooks = new ArrayList<>();
                categoryBooks.add(book);
                categoryMap.put(category, categoryBooks);
            } else {
                categoryMap.get(category).add(book);
            }
        }

        for (Map.Entry<String, List<Element>> entry : categoryMap.entrySet()) {
            System.out.println("************************");
            System.out.println("Category:" + entry.getKey() + " has " + entry.getValue().size() + " book(s)");
            for (int i = 0; i < entry.getValue().size(); i++) {
                Element book = entry.getValue().get(i);
                for (int j = 0; j < book.getChildren().size(); j++) {
                    Element childElement = book.getChildren().get(j);
                    System.out.println(childElement.getName() + ":" + childElement.getValue());
                }
                System.out.println(i == entry.getValue().size() - 1 ? "\n" : "------------------------------");
            }
        }
    }

}

