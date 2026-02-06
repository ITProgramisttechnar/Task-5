package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public User add(User user) {
      sessionFactory.getCurrentSession().save(user);
      return user;
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findByModelAndSeries(String model, int series) {
      Query<User> query = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series", User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.uniqueResult();
   }

   @Override
   public List<User> getAllUsersWithCar() {
      Query<User> query = sessionFactory.getCurrentSession().createQuery("SELECT  DISTINCT u FROM User u LEFT JOIN FETCH u.car", User.class);
      return query.getResultList();
   }


}
