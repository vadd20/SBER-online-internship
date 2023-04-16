package task2;

import java.util.Comparator;

public class City {
    String name;
    String region;
    String district;
    int population;
    String foundation;

    City (String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';

    }
    public static Comparator<City> comparatorByName = new Comparator<City>() {
        @Override
        public int compare(City city1, City city2) {
            return city1.getName().compareToIgnoreCase(city2.getName());
        }
    };

    public static Comparator<City> ComparatorByDistrictAndName = new Comparator<City>() {
        @Override
        public int compare(City city1, City city2) {
            int disrtictCompare = city1.getDistrict().compareTo(city2.getDistrict());
            if (disrtictCompare != 0) {
                return disrtictCompare;
            }
            return city1.getName().compareTo(city2.getName());
        }
    };
}
