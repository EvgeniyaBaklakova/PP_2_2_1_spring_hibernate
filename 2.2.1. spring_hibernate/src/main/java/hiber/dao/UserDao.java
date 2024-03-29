package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void saveUsers(User user);
   List<User> getListUsers();
   void saveCars(Car car);
   List<Car> getListCars();
   User getUserByModelAndSeriesCar(String model, int series);
}
