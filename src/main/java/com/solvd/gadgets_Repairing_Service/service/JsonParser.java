package com.solvd.gadgets_Repairing_Service.service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.gadgets_Repairing_Service.JdbcConnection;
import com.solvd.gadgets_Repairing_Service.bin.Parts;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(JsonParser.class);

    public static void main(String[] args) {

        File jsonFile = new File("src/main/resources/Parts.json");

        // jackson parser for json
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

}}
