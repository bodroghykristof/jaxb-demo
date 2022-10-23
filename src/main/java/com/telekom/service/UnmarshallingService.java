package com.telekom.service;

import com.telekom.model.Student;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

import static com.telekom.config.FileUtil.PATH;

public class UnmarshallingService {

    public Student unmarshallStudent(String xmlFilePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Student) unmarshaller.unmarshal(new File(PATH + xmlFilePath));
    }

}
