package zju.ccnt.mdsp.springmvc.controller;

/**
 * Created by Cc on 2016/12/21.
 */

import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zju.ccnt.mdsp.db.MySqlSessionFactory;
import zju.ccnt.mdsp.mapping.Assay;
import zju.ccnt.mdsp.mapping.Recipe;
import zju.ccnt.mdsp.mapping.User;

import javax.persistence.NoResultException;
import java.util.List;

@RestController
public class ServiceController {
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

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") int id) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        Recipe recipe;
        try {
            recipe = session.get(Recipe.class, id);
        } catch (NoResultException e) {
            System.out.println("---> getRecipe() : id = NoResult");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } finally {
            session.close();
        }

        System.out.println("---> getRecipe() : id = " + id);

        return ResponseEntity.ok(recipe);
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ResponseEntity<List<Recipe>> getRecipes(@RequestParam("userId") int userId) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        List<Recipe> recipes;
        try {
            recipes = session.createQuery("FROM Recipe WHERE userId = " + userId
            ).getResultList();
        } catch (NoResultException e) {
            System.out.println("---> getRecipes() : userId = NoResult");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } finally {
            session.close();
        }

        System.out.println("---> getRecipes() : userId = " + userId);

        return ResponseEntity.ok(recipes);
    }
}