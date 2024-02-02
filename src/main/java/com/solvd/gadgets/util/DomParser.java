package com.solvd.gadgets.util;

import org.apache.logging.log4j.LogManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(DomParser.class);
     public void DomParsing(File filePath, String tagName) {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         try {
             DocumentBuilder builder  =  factory.newDocumentBuilder();
             Document document =  builder.parse(filePath);
             document.getDocumentElement().normalize();
             NodeList List = document.getElementsByTagName(tagName);

             for (int i = 0; i < List.getLength(); i++) {
                 Node node = List.item(i);

                 if (node.getNodeType() == Node.ELEMENT_NODE) {
                     Element element = (Element) node;
                    String id = element.getAttribute("id");
                    LOGGER.info(id);
                    NodeList nodeList = node.getChildNodes();
                    for (int j = 0; j<nodeList.getLength(); j++){
                        Node details = nodeList.item(j);
                        if (details.getNodeType() == Node.ELEMENT_NODE){
                            Element detailsElement = (Element) details;
                            LOGGER.info(detailsElement.getTagName()+":"+ detailsElement.getTextContent());
                        }
                    }
                 }
             }
         } catch (ParserConfigurationException | IOException |SAXException e) {
             throw new RuntimeException(e);
         }

     }
}
