package com.telekom;

import com.telekom.model.Student;
import com.telekom.service.MarshallingService;
import com.telekom.service.UnmarshallingService;
import jakarta.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) throws JAXBException {
        MarshallingService marshallingService = new MarshallingService();
        UnmarshallingService unmarshallingService = new UnmarshallingService();
        Student student = createStudent();
        String xmlFilePath = marshallingService.marshallStudent(student);
        Student unmarshalledStudent = unmarshallingService.unmarshallStudent(xmlFilePath);
        System.out.println("Original student: " + student);
        System.out.println("Unmarshalled student: " + unmarshalledStudent);
        System.out.println("Objects are equal: " + student.equals(unmarshalledStudent));
        System.out.println("Detari: " + unmarshallingService.unmarshallStudent("lajos_detari.xml"));
    }

    private static Student createStudent() {
        Student s = new Student();
        s.setId(1L);
        s.setFirstName("Eric");
        s.setLastName("Cantona");
        return s;
    }
}