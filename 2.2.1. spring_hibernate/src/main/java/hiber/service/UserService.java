package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void saveUsers(User user);
    List<User> listUsers();

    void saveCars(Car car);
    List<Car> listCar();
    User getUserByIdCar(String model, int series);
}
