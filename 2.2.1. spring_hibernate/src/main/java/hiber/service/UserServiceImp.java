package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Override
   public void add(User user) {
      userDao.saveUser(user);
   }

   @Override
   public void addCar(Car car){userDao.saveCar(car);}

   @Override
   public List<Car> listCar() {
      return userDao.getListCars();
   }

   @Override
   public User getUserByIdCar(String model, int series) {
      return userDao.getUserByModelAndSeriesCar(model, series);
   }
   @Override
   public List<User> listUsers() {
      return userDao.getListUsers();
   }

}
