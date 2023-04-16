package task1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "./src/Задача ВС Java Сбер.csv";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        readFileAndOutput(scanner);
    }
    private static void readFileAndOutput(Scanner scanner) {
        while (scanner.hasNextLine()) {
            City city = parseFile(scanner.nextLine());
            System.out.println(city);
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