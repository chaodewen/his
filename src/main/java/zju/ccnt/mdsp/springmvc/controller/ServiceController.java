package zju.ccnt.mdsp.springmvc.controller;

/**
 * Created by Cc on 2016/12/21.
 */

import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zju.ccnt.mdsp.db.MySqlSessionFactory;
import zju.ccnt.mdsp.mapping.User;

@RestController
public class ServiceController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestParam("id") int id) {
        Session session = MySqlSessionFactory.getInstance().openSession();
        User user = session.get(User.class, id);
        System.out.println("---> getUser() : id = " + user.getId());
        session.close();

        if(user == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(user);
    }
}