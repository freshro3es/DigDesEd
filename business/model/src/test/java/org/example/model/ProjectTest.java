package org.example.model;

import org.example.libs.ProjStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void create() {
        final int id = 2;
        String name = "Vtec";
        String description = "The Power of Dreams";
        ProjStatus status = ProjStatus.DEVELOPING;
        Team team = null;

        Project project = new Project(id, name, description, status, team);
        assertEquals(
                project.toString(), "Project(id=2, name=Vtec, " +
                        "description=The Power of Dreams, status=DEVELOPING, team=null)"
                );
    }

}