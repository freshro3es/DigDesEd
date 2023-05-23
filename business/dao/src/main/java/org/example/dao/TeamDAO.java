package org.example.dao;

import org.example.libs.EmpStatus;
import org.example.libs.TeamRole;
import org.example.model.Employee;
import org.example.model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "admin";
    private final String password = "admin";

    public TeamDAO() {
    }

    public void addTeam(Team team) throws SQLException {
        String sql = "INSERT INTO team (name) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, team.getName());
            stmt.executeUpdate();
        }
    }

    public void updateTeam(Team team) throws SQLException {
        String sql = "UPDATE team SET name=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, team.getName());
            stmt.setInt(2, team.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteTeam(int id) throws SQLException {
        String sql = "DELETE FROM team WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Team getTeamById(int id) throws SQLException {
        String sql = "SELECT * FROM team WHERE id=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                return new Team(id, name, null);
            }
        }
        return null;
    }

    public List<Team> getAllTeams() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Team team = new Team(id, name, null);
                teams.add(team);
            }
        }
        return teams;
    }

    public List<Employee> getEmployeesByTeamId(int id) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * " +
                    "FROM employee JOIN employee_in_team eit on employee.id = eit.fk_employee " +
                    "WHERE fk_team = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            while (rs.next()) {
                int employeeId = rs.getInt("id");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String fatherName = rs.getString("fathername");
                String position = rs.getString("position");
                String account = rs.getString("account");
                String email = rs.getString("email");
                EmpStatus empStatus = EmpStatus.valueOf(rs.getString("status"));
                String password = rs.getString("password");
                boolean isTemporaryPwd = rs.getBoolean("is_temporary_pwd");
                TeamRole role = TeamRole.valueOf(rs.getString("role"));
                Employee employee = new Employee(employeeId, firstName, lastName, fatherName, position, account, email, empStatus, password, isTemporaryPwd, role, null);
                employees.add(employee);
            }
        }
        return employees;
    }
}
