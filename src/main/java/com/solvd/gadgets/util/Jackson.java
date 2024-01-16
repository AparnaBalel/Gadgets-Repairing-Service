package com.solvd.gadgets.util;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.gadgets.bin.Parts;
import com.solvd.gadgets.service.JsonParser;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Jackson {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Jackson.class);
    File jsonFile = new File("src/main/resources/Parts.json");
    // jackson parser for json

    public void JacksonParser(File jsonFile) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Parts parts = mapper.readValue(jsonFile, Parts.class);
            List<Parts> allParts = parts.getParts();
            for (Parts part : allParts) {
                LOGGER.info("Part ID: " + part.getPartID());
                LOGGER.info("Part Name: " + part.getPartName());
                LOGGER.info("part cost: " + part.getPartCost());
                LOGGER.info("");
            }

        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
