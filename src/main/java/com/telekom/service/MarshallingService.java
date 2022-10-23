package com.telekom.service;

import com.telekom.model.Student;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

import static com.telekom.config.FileUtil.PATH;

/**
 * Class responsible for converting Java objects to XML
 */
public class MarshallingService {

    public String marshallStudent(Student s) throws JAXBException {
        String filePath = s.getFirstName().toLowerCase()
                + "_" + s.getLastName().toLowerCase() + ".xml";
        File file = new File(PATH + filePath);
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(s, file);
        return filePath;
    }

}
