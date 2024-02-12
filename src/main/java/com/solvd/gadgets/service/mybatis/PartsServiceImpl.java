package com.solvd.gadgets.service.mybatis;

import com.solvd.gadgets.service.serviceInterfaces.PartsService;
import com.solvd.gadgets.util.Jackson;

import java.io.File;

public class PartsServiceImpl implements PartsService {
    File jsonFile = new File("src/main/resources/Parts.json");

    public PartsServiceImpl() {

    }

    @Override
    public void parsingParts() {
        Jackson jackson = new Jackson();
        jackson.parseParts();
    }
}
