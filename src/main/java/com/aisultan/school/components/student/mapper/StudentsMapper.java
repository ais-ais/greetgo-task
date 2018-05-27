package com.aisultan.school.components.student.mapper;


import com.aisultan.school.components.student.model.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface StudentsMapper {
    @Select("select * from students")
    List<Students> findAll();

    @Delete("delete from students where id = #{id}")
    void delete(int id);

    @Insert("insert into students(name, surname, course, advisor, email) values(#{name}, #{surname}, #{course}, #{advisor}, #{email})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before=false, resultType = Integer.class)
    void insert(Students students);

    @Insert("CREATE TABLE IF NOT EXISTS ${_parameter} \n" +
            "        (\n" +
            "        `ID` INTEGER AUTO_INCREMENT , " +
            "         `NAME` VARCHAR(20), " +
            "         `SURNAME` VARCHAR(20), " +
            "         `COURSE` INTEGER, " +
            "         `ADVISOR` VARCHAR(20), " +
            "         `EMAIL` VARCHAR(100), " +
            "        ) \n" +
            "        ENGINE=InnoDB")
    void createTableIfAbsent(String tableName);
}
