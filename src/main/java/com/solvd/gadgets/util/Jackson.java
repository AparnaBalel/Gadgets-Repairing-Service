package com.solvd.gadgets.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.gadgets.bin.Parts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Jackson {
    private static final Logger LOGGER = LogManager.getLogger(Jackson.class);
    // jackson parser for json
    public void parseParts() {
        File jsonFile = new File("src/main/resources/Parts.json");
        ObjectMapper mapper = new ObjectMapper();

        try {
            Parts parts = mapper.readValue(jsonFile, Parts.class);
            List<Parts> allParts = parts.getParts();

            if (allParts != null) {
                for (Parts part : allParts) {
                    LOGGER.info("\n" + "Part ID: " +" "+ part.getPartID() +"\n"
                    + "Part Name: " + part.getPartName() +"\n "
                    + "Part Cost: " + part.getPartCost());
                }
            } else {
                LOGGER.info("No parts found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

