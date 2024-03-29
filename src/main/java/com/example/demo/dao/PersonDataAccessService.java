package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        String sql="INSERT INTO PERSON VALUES(uuid_generate_v4(), ?)";

        return jdbcTemplate.update(sql,person.getName());
    }

    @Override
    public List<Person> selectAllPeople() {
        return jdbcTemplate.query("select * from person", (resultSet,i) ->{
            UUID id=UUID.fromString(resultSet.getString("id"));
            String name=resultSet.getString("name");
            return new Person(id,name);
        } );
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        Person person = jdbcTemplate.queryForObject(
                "select * from person where id = ?",
                new Object[]{id},
                (resultSet,i) ->{
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String name=resultSet.getString("name");
            return new Person(personId,name);
        } );

        return Optional.ofNullable(person);

    }

    @Override
    public int deletePersonById(UUID id) {
        String sql = "DELETE FROM PERSON WHERE ID = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        String sql = "UPDATE PERSON SET ID = ?, NAME = ?";
        return jdbcTemplate.update(sql,id,person.getName());
    }
}