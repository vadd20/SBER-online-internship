package task3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "./src/Задача ВС Java Сбер.csv";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        List<City> cities = new ArrayList<>();
        readFileToList(scanner, cities);
        findMaxPopulation(cities);
    }
    private static void readFileToList(Scanner scanner, List<City> cities) {
        while (scanner.hasNextLine()) {
            City city = parseFile(scanner.nextLine());
            cities.add(city);
        }
    }
    private static City parseFile(String currentLine) {
        String[] data = (currentLine).split(";");
        String name = data[1];
        String region = data[2];
        String district = data[3];
        int population = Integer.parseInt(data[4]);
        String foundation;
        if (data.length == 5) {
            foundation = "";
        } else {
            foundation = data[5];
        }
        return new City(name, region, district, population, foundation);
    }

    private static void findMaxPopulation (List<City> cities) {
        int maxPopulation = Integer.MIN_VALUE;
        int maxPopulationIndex = 0;
        for (int i = 0; i < cities.size(); ++i) {
            if (cities.get(i).getPopulation() > maxPopulation) {
                maxPopulation = cities.get(i).getPopulation();
                maxPopulationIndex = i;
            }
        }
        System.out.println("[" + maxPopulationIndex + "] = " + maxPopulation);
    }
}
