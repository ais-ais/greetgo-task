package com.aisultan.school;


import com.aisultan.school.components.student.mapper.StudentsMapper;
import com.aisultan.school.components.student.model.Students;
import com.aisultan.school.components.student.resource.StudentsResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentsResource.class)
public class ControllerTest {



    @MockBean
    private StudentsMapper studentsMapper;

    @Before
    public void setUp(){

        List<Students> students = new ArrayList<>();
        Students student1 = new Students();
        student1.setName("hello");
        students.add(student1);
        Students student2 = new Students();
        student2.setName("world");
        students.add(student2);
        Mockito.when(studentsMapper.findAll()).thenReturn(students);

    }

    @Test
    public void checkFindAllStudents() {
        List<Students> studentsList = new ArrayList<>();
        Students student1 = new Students();
        student1.setName("hello");
        studentsList.add(student1);
        Students student2 = new Students();
        student2.setName("world");
        studentsList.add(student2);
        given(studentsMapper.findAll()).willReturn(studentsList);
    }

    @Test
    public void check() {

        List<Students> studentsList = studentsMapper.findAll();

        assertNotNull(studentsList);
        assertEquals(2, studentsList.size());
        assertTrue(studentsList.get(0).getName().equals("hello"));
    }


}
