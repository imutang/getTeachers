package com.example.demo.controller;

import com.example.demo.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping
public class TeacherController {
    @Autowired
    private ReadJsonText readJsonText;
    private static int num=0;
    private final HashMap<Integer, Teacher> teachers=new HashMap<>();
    private void getReadJson() throws IOException {
        for (Teacher teacher:readJsonText.getJson().teachers){
            teachers.put(++num,teacher);
        }
    }



}
