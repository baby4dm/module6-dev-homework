package org.example.service;

import org.example.model.*;
import org.example.util.Database;
import org.example.util.QueryReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
        public static List<ProjectPrice> getProjectPrices() {
            Connection connection = Database.getInstance().getConnection();
            String query = QueryReader.getQueryFromFile("sql/print_project_prices.sql");
            List<ProjectPrice> projectPrices = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    ProjectPrice project = new ProjectPrice();
                    project.setId(result.getInt("project_id"));
                    project.setPrice(result.getInt("salary_sum"));
                    projectPrices.add(project);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return projectPrices;
        }

        public static List<WorkerAge> findYoungestAndEldest(){
            Connection connection = Database.getInstance().getConnection();
            String query = QueryReader.getQueryFromFile("sql/find_youngest_eldest_workers.sql");
            List<WorkerAge> workers = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    WorkerAge worker = new WorkerAge();
                    worker.setType(result.getString("type"));
                    worker.setName(result.getString("name"));
                    worker.setDate(result.getDate("birthday").toLocalDate());
                    workers.add(worker);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return workers;
        }

        public static List<WorkerSalary> findMaxWorkerSalary(){
            Connection connection = Database.getInstance().getConnection();
            String query = QueryReader.getQueryFromFile("sql/find_max_salary_worker.sql");
            List<WorkerSalary> workers = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    WorkerSalary worker = new WorkerSalary();
                    worker.setName(result.getString("name"));
                    worker.setSalary(result.getInt("salary"));
                    workers.add(worker);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return workers;
        }

        public static List<ProjectClient> findMaxProjectsClient(){
            Connection connection = Database.getInstance().getConnection();
            String query = QueryReader.getQueryFromFile("sql/find_max_projects_client.sql");
            List<ProjectClient> clients = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    ProjectClient client = new ProjectClient();
                    client.setName(result.getString("name"));
                    client.setCount(result.getInt("project_count"));
                    clients.add(client);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return clients;
        }

        public static List<LongestProject> findLongestProject(){
            Connection connection = Database.getInstance().getConnection();
            String query = QueryReader.getQueryFromFile("sql/find_longest_project.sql");
            List<LongestProject> projects = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    LongestProject project = new LongestProject();
                    project.setId(result.getInt("id"));
                    project.setMonths(result.getInt("month_count"));
                    projects.add(project);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return projects;
        }
}
