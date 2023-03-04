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
   private UserDao userDao;
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public void saveUsers(User user) {
      userDao.saveUsers(user);
   }

   @Override
   public void saveCars(Car car){userDao.saveCars(car);}

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
