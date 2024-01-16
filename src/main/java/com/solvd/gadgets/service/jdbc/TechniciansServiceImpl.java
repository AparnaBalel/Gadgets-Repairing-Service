package com.solvd.gadgets.service.jdbc;

import com.solvd.gadgets.service.TechniciansService;
import com.solvd.gadgets.util.DomParser;

import java.io.File;

public class TechniciansServiceImpl implements TechniciansService {

    File file = new File("src/main/resources/company.xml");
    String tagName = "technician";
    @Override
    public void insertTechnician(String firstName, String lastName, String Email, long Phone) {

    }

    @Override
    public void parsingTechnician() {
        DomParser domParser = new DomParser();
        domParser.DomParsing(file,tagName);
    }
}
