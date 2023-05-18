package org.example.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void create() {
        final int id = 1;
        String name = "Assignation";
        List<Employee> employees = null;
        Team team = new Team(id, name, employees);

        assertEquals(team.toString(), "Team(id=1, name=Assignation, employees=null)");
    }

}