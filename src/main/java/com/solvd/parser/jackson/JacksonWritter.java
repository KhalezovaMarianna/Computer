package com.solvd.parser.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.parser.models.ActiveTasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonWritter {
    private static final Logger LOGGER = LogManager.getLogger(JacksonWritter.class);
    private static File file = new File(System.getProperty("user.dir") + "/src/main/resources/jackson.json");

    public static void serialize(ActiveTasks tasks) {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            List<ActiveTasks> activeTasks = new ArrayList<>();
            activeTasks.add(tasks);
            objectMapper.writeValue(file, activeTasks);
            LOGGER.info("Serialization succesfull to: " + file.getPath());
        } catch (JsonProcessingException e) {
            LOGGER.info("JsonProcessingException", e);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    public static void deserialize() {

        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, ActiveTasks.class);
        try {
            List<ActiveTasks> tasks = objectMapper.readValue(file, type);
            LOGGER.info("Successfully deserialized from: " + file.getPath());
            LOGGER.info(tasks);
        } catch (IOException e) {
            LOGGER.info("Error", e);
        }

    }
}

