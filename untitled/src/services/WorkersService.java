package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.people.People;
import model.people.Workers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkersService {
    private ObjectMapper mapper;

    public WorkersService() {
        this.mapper = new ObjectMapper();

    }

    public List<Workers> loadWorkers(String filePath) throws IOException {
        Workers[] workersArray = mapper.readValue(new File(filePath), Workers[].class);
        return Arrays.asList(workersArray);
    }

    public List<Workers> filterWorkersByAge(List<Workers> workersList, Integer age) {
        List<Workers> workersFilters = new ArrayList<>();
        for (Workers worker : workersList) {
            if (worker.getAge() > age) {
                workersFilters.add(worker);
            }
        }
        return workersFilters;
    }

    public void saveWorkersFilter(String filePath, List<Workers> workersList) throws IOException {
        mapper.writeValue(new File(filePath), workersList);
    }

    public void showWorkers(List<Workers> workersList) {
        for (Workers worker : workersList) {
            System.out.println(worker);
        }
    }

}
