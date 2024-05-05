package org.example;

import org.example.model.*;
import org.example.service.DatabaseQueryService;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<ProjectPrice> projectPrices = DatabaseQueryService.getProjectPrices();
        System.out.println(projectPrices);

        List<WorkerAge> workerAges = DatabaseQueryService.findYoungestAndEldest();
        System.out.println(workerAges);

        List<WorkerSalary> workerSalaries = DatabaseQueryService.findMaxWorkerSalary();
        System.out.println(workerSalaries);

        List<ProjectClient> projectClients = DatabaseQueryService.findMaxProjectsClient();
        System.out.println(projectClients);

        List<LongestProject> longestProjects = DatabaseQueryService.findLongestProject();
        System.out.println(longestProjects);

    }
}
