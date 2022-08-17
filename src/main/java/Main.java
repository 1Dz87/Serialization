import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class Main {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        File file = new File("d:\\JavaGr\\cars\\garage");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Garage garage = objectMapper.readValue(reader, Garage.class);
        System.out.println(garage.getAddress());
    }

    private static void saveAllGarage() throws IOException {
        File parentDir = getParentDir("d:\\JavaGr\\cars\\");
        Garage garage = makeGarage("San Francisco");
        String json = objectMapper.writeValueAsString(garage);
        File file = new File(getCarFileName(parentDir, "garage"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(json);
        }
    }

    private static void saveOnlyCars() throws IOException {
        File parentDir = getParentDir("d:\\JavaGr\\cars\\");
        List<Car> cars = makeCars();
        for (Car car : cars) {
            File file = new File(getCarFileName(parentDir, car.getName()));
            String json = objectMapper.writeValueAsString(car);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(json);
            }
        }
    }

    private static Garage makeGarage(String address) {
        List<Car> cars = makeCars();
        return new Garage(address, cars);
    }

    private static String getCarFileName(File parent, String carName) {
        return parent.getAbsolutePath() + File.separator + carName;
    }

    private static File getParentDir(String path) {
        File parentDir = new File(path);
        if (!parentDir.exists()) {
            parentDir.mkdir();
        }
        return parentDir;
    }

    private static List<Car> makeCars() {
        Car mercedes = new Car.Builder()
                .id(1L)
                .name("Mercedes")
                .engineValue(0.9f)
                .build();
        Car lada = new Car.Builder()
                .id(2L)
                .name("Lada")
                .engineValue(11.5f)
                .build();
        Car rover = new Car.Builder()
                .id(3L)
                .name("Rover")
                .engineValue(0f)
                .build();
        return List.of(mercedes, lada, rover);
    }
}
