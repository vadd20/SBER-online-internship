package task4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "./src/Задача ВС Java Сбер.csv";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        Map<String, Integer> regionNumberOfCitiesMap = new HashMap<>();

        readFileToMap(scanner, regionNumberOfCitiesMap);
        printResult(regionNumberOfCitiesMap);
    }

    private static void printResult(Map<String, Integer> regionNumberOfCitiesMap) {
        Set<Map.Entry<String, Integer>> entries = regionNumberOfCitiesMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
    private static void readFileToMap(Scanner scanner, Map<String, Integer> map) {
        while (scanner.hasNextLine()) {
            City city = parseFile(scanner.nextLine());
            if (!map.containsKey(city.getRegion())) {
                map.put(city.getRegion(), 1);
            } else {
                Integer number = map.get(city.getRegion());
                ++number;
                map.put(city.getRegion(), number);
            }
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
}
