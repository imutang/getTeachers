package com.example.demo.controller;

import com.example.demo.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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
    @GetMapping
    public java.util.Collection<Teacher> getTeachers(){
        return teachers.values();
    }

    @GetMapping("{id}")
    public Teacher getTeacherById(@PathVariable Integer id){
        return teachers.get(id);
    }

    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable Integer id){
        teachers.remove(id);
    }

    @PutMapping("{id}")
    public void putTeacher(@PathVariable Integer id,@RequestBody Teacher teacher){
        Teacher t=new Teacher();
        t.setName(teacher.getName());
        t.setId(teacher.getId());
        t.setAge(teacher.getAge());
        t.setSex(teacher.getSex());
    }

    @PostMapping
    public void postTeacher(@RequestBody Teacher teacher){
        teachers.put(++num,teacher);
    }

    @PostConstruct
    public void init() throws IOException {
        getReadJson();
    }

}
