package zju.ccnt.mdsp.controller;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zju.ccnt.mdsp.db.MySqlSessionFactory;
import zju.ccnt.mdsp.model.DrugItem;
import zju.ccnt.mdsp.model.Recipe;
import zju.ccnt.mdsp.utils.Utils;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Cc on 2016/12/23.
 */

@RestController
public class RecipeService {
    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") int id) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        Recipe recipe;
        try {
            recipe = session.get(Recipe.class, id);
        } catch (NoResultException e) {
            System.out.println("---> getRecipe() : id = NoResult");
            return Utils.genErrorResponse(HttpStatus.NOT_FOUND
                    , "Not Found");
        } finally {
            session.close();
        }

        System.out.println("---> getRecipe() : id = " + id);

        return ResponseEntity.ok(recipe);
    }
    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ResponseEntity<List<Recipe>> getRecipes(@RequestParam("userId") int userId
            , @RequestParam(value = "start", defaultValue = "default") String start
            , @RequestParam(value = "end", defaultValue = "default") String end) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        List<Recipe> recipes;
        try {
            String sql = "FROM Recipe WHERE userId = " + userId;
            if(!"default".equals(start) && !"default".equals(end)) {
                sql += " AND createdDate >= ? AND createdDate <= ?";
                Query query = session.createQuery(sql);
                query.setParameter(0, Utils.getDate(start));
                query.setParameter(1, Utils.getDate(end));
                recipes = query.getResultList();
            }
            else if(!"default".equals(start)) {
                sql += " AND createdDate >= ?";
                Query query = session.createQuery(sql);
                query.setParameter(0, Utils.getDate(start));
                recipes = query.getResultList();
            }
            else if(!"default".equals(end)) {
                sql += " AND createdDate <= ?";
                Query query = session.createQuery(sql);
                query.setParameter(0, Utils.getDate(end));
                recipes = query.getResultList();
            }
            else {
                Query query = session.createQuery(sql);
                recipes = query.getResultList();
            }
        } catch (NoResultException e) {
            System.out.println("---> getRecipes() : userId = NoResult");
            return Utils.genErrorResponse(HttpStatus.NOT_FOUND
                    , "Not Found");
        } finally {
            session.close();
        }

        System.out.println("---> getRecipes() : userId = " + userId);

        return ResponseEntity.ok(recipes);
    }
}