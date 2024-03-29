package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      System.out.println("connection");
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.saveUsers(new User("User1", "Lastname1", "user1@mail.ru")
              .setCar(new Car("model1", 1)));
      userService.saveUsers(new User("User2", "Lastname2", "user2@mail.ru")
              .setCar(new Car("model2", 2)));
      userService.saveUsers(new User("User3", "Lastname3", "user3@mail.ru")
              .setCar(new Car("model3", 3)));
      userService.saveUsers(new User("User4", "Lastname4", "user4@mail.ru")
              .setCar(new Car("model4", 4)));


      User user2 = userService.getUserByIdCar("model2", 2);
      System.out.println(user2);



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }
      List<Car> car = userService.listCar();
      for (Car cars : car) {
         System.out.println("id = " + cars.getId());
         System.out.println("model = " + cars.getModel());
         System.out.println("series = " + cars.getSeries());
      }

      context.close();
   }
}
