package com.epam.lab.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlToobject {
    public static void main(String[] args) {

        try {

            File file = new File("gameOfThrones.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Task.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Task que = (Task) jaxbUnmarshaller.unmarshal(file);
            List<Seasons> list = que.getDatail();
            for (Seasons seasons : list)
                System.out.println(seasons.getYear() + " " + seasons.getName() + "  " + seasons.getCountry());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
