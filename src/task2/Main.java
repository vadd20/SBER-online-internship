package task2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "/home/vadim/IdeaProjects/sber-task2/src/Задача ВС Java Сбер.csv";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        List<City> cities = new ArrayList<>();
        readFileToList(scanner, cities);
        System.out.println(sortByName(cities));
        System.out.println(sortByDistrictAndName(cities));
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

    private static List<City> sortByName(List<City> cities) {
        Comparator<City> comparator = City.comparatorByName;
        List<City> sorted = new ArrayList<>(cities);
        sorted.sort(comparator);
        return sorted;
    }

    private static List<City> sortByDistrictAndName(List<City> cities) {
        Comparator<City> comparator = City.ComparatorByDistrictAndName;
        List<City> sorted = new ArrayList<>(cities);
        sorted.sort(comparator);
        return sorted;
    }
}
