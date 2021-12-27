package com.example.demo.controller;

import com.example.demo.pojo.AllTeachers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ReadJsonText {
    @Value("${jsonPath}")
    private String jsonPath;

    public File readJson(){
        File file=new File(jsonPath);
        return file;
    }

    public AllTeachers getJson() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        AllTeachers allTeachers=objectMapper.readValue(readJson(),AllTeachers.class);
        return allTeachers;
    }
}
