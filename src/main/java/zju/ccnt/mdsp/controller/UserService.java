package zju.ccnt.mdsp.controller;

import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zju.ccnt.mdsp.db.MySqlSessionFactory;
import zju.ccnt.mdsp.model.User;
import zju.ccnt.mdsp.utils.Utils;

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
            System.out.println("---> getUser() : id = NoResult");
            return Utils.genErrorResponse(HttpStatus.NOT_FOUND
                    , "Not Found");
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
            System.out.println("---> getId() : idcard = NoResult");
            return Utils.genErrorResponse(HttpStatus.NOT_FOUND
                    , "Not Found");
        } finally {
            session.close();
        }

        System.out.println("---> getId() : idcard = " + idcard);

        User user = new User();
        user.setId(id);
        user.setIdcard(idcard);


        return ResponseEntity.ok(user);
    }
    @RequestMapping(value = "/users/essentials/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getEssentialUser(@PathVariable("id") int id) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        User user;
        try {
            user = session.get(User.class, id);
            user.setRecipesById(null);
            user.setAssaysById(null);
        } catch (NoResultException e) {
            System.out.println("---> getEssentialUser() : id = NoResult");
            return Utils.genErrorResponse(HttpStatus.NOT_FOUND
                    , "Not Found");
        } finally {
            session.close();
        }

        System.out.println("---> getEssentialUser() : id = " + id);

        return ResponseEntity.ok(user);
    }
}