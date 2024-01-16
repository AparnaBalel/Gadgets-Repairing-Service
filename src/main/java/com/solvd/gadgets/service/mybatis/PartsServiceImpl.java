package com.solvd.gadgets.service.mybatis;

import com.solvd.gadgets.service.PartsService;
import com.solvd.gadgets.util.JAXBParser;

public class PartsServiceImpl implements PartsService {

    @Override
    public void parsingParts() {
        JAXBParser jaxbParser = new JAXBParser();
        jaxbParser.JAXBParser();
    }
}
