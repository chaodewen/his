package zju.ccnt.mdsp.controller;

import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zju.ccnt.mdsp.db.MySqlSessionFactory;
import zju.ccnt.mdsp.model.User;

import javax.persistence.NoResultException;

/**
 * Created by Cc on 2016/12/23.
 */

@RestController
public class UserService {
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        User user = null;
        try {
            user = session.get(User.class, id);
        } catch (NoResultException e) {
            System.out.println("---> getUser() : id = " + user.getId());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } finally {
            session.close();
        }

        System.out.println("---> getUser() : id = " + user.getId());

        return ResponseEntity.ok(user);
    }
    @RequestMapping(value = "/users/id", method = RequestMethod.GET)
    public ResponseEntity<User> getId(@RequestParam("idcard") String idcard) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        int id;
        try {
            id = (Integer) session.createNativeQuery(
                    "SELECT id FROM User WHERE idcard = " + idcard).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("---> getId() : id = NoResult");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } finally {
            session.close();
        }

        System.out.println("---> getId() : id = " + id);

        User user = new User();
        user.setId(id);
        user.setIdcard(idcard);


        return ResponseEntity.ok(user);
    }
}