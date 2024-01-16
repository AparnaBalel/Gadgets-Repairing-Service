package com.solvd.gadgets;

import com.solvd.gadgets.bin.Technicians;
import com.solvd.gadgets.service.jdbc.TechniciansServiceImpl;
import com.solvd.gadgets.service.mybatis.PartsServiceImpl;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        TechniciansServiceImpl technician = new TechniciansServiceImpl();
        technician.parsingTechnician();

        PartsServiceImpl partsService = new PartsServiceImpl();
        partsService.parsingParts();
    }

}
