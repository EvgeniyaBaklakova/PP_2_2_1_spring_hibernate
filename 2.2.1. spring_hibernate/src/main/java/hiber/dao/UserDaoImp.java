package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   private SessionFactory sessionFactory;
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void saveUsers(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   public void saveCars(Car car){ sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public List<Car> getListCars() {
      return sessionFactory.getCurrentSession().createQuery("from Car").getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getListUsers() {
      return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
   }

   @Override
   public User getUserByModelAndSeriesCar(String model, int series) {
      Query<User> query = sessionFactory.getCurrentSession().createQuery(" from User u where u.car.model = :model" +
              " and u.car.series = :series").setParameter("model", model).setParameter("series", series);
      return query.getSingleResult();
   }
}