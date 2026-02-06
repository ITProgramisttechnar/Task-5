package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;


   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional (readOnly = true)
   @Override
   public User findByModelAndSeries(String model, int series) {
      User user = userDao.findByModelAndSeries(model, series);
      if(user==null){
         System.out.println("Пользователь с машиной " + model + " " + series + " не найден");
      }
      return user;
   }
   @Transactional (readOnly = true)
   @Override
   public List<User> getAllUsersWithCar() {
      return userDao.getAllUsersWithCar();
   }
}

