package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   User add(User user);
   List<User> listUsers();
   User findByModelAndSeries(String model, int series);
   List<User> getAllUsersWithCar();
}
