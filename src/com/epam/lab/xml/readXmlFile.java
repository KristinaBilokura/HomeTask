package com.epam.lab.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class readXmlFile {
    public static void main(String[] args) {

        try {
            File inputFile = new File("games.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nListon = doc.getElementsByTagName("country");
            System.out.println("----------------------------");

            for (int temp1 = 0; temp1 < nListon.getLength(); temp1++) {
                Node nNode = nListon.item(temp1);
                System.out.println("Current Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println( eElement.getAttribute("name"));

                }
            }
            NodeList nList = doc.getElementsByTagName("season");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Number : "
                            + eElement.getAttribute("id"));
                    System.out.println("Name : "
                            + eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Description :"
                            + eElement
                            .getElementsByTagName("description")
                            .item(0)
                            .getTextContent());
                    System.out.println("Year of premier : "
                            + eElement
                            .getElementsByTagName("year")
                            .item(0)
                            .getTextContent());

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
