package org.example.mapper;

import org.example.dto.create.CreateTeamDTO;
import org.example.dto.order.OrderTeamDTO;
import org.example.dto.update.UpdateTeamDTO;
import org.example.model.Team;
import org.springframework.stereotype.Component;

@Component //TODO а действительно ли нужен такой компонент?
public class TeamMapper {

    public Team toTeam(CreateTeamDTO dto) {
        if (dto == null) {
            return null;
        }

        Team team = new Team();

        team.setName(dto.getName());

        return team;
    }

    public OrderTeamDTO toOrderTeamDTO(Team team) {
        if (team == null) {
            return null;
        }
        return new OrderTeamDTO(
                team.getName()
        );
    }

    public void updateTeamDTOtoTeam(UpdateTeamDTO dto, Team team) {
        if (dto == null || team == null) {
            return;
        }
        team.setName(dto.getName());
    }
}
