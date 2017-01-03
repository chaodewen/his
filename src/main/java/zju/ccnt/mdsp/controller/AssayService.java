package zju.ccnt.mdsp.controller;

import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zju.ccnt.mdsp.db.MySqlSessionFactory;
import zju.ccnt.mdsp.model.Assay;
import zju.ccnt.mdsp.utils.Utils;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Cc on 2016/12/23.
 */

@RestController
public class AssayService {
    @RequestMapping(value = "/assays/{id}", method = RequestMethod.GET)
    public ResponseEntity<Assay> getAssay(@PathVariable("id") int id) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        Assay assay;
        try {
            assay = session.get(Assay.class, id);
        } catch (NoResultException e) {
            System.out.println("---> getAssay() : id = NoResult");
            return Utils.genErrorResponse(HttpStatus.NOT_FOUND
                    , "Not Found");
        } finally {
            session.close();
        }

        System.out.println("---> getAssay() : id = " + id);

        return ResponseEntity.ok(assay);
    }

    @RequestMapping(value = "/assays", method = RequestMethod.GET)
    public ResponseEntity<List<Assay>> getAssays(@RequestParam("userId") int userId
            , @RequestParam(value = "start", defaultValue = "default") String start
            , @RequestParam(value = "end", defaultValue = "default") String end) {
        Session session = MySqlSessionFactory.getInstance().openSession();

        List<Assay> assays;
        try {
            String sql = "FROM Assay WHERE userId = " + userId;
            if(!"default".equals(start)) {
                sql += " AND finishedDate >= " + start;
            }
            if(!"default".equals(end)) {
                sql += " AND finishedDate <= " + end;
            }
            assays = session.createQuery(sql).getResultList();
        } catch (NoResultException e) {
            System.out.println("---> getAssays() : userId = NoResult");
            return Utils.genErrorResponse(HttpStatus.NOT_FOUND
                    , "Not Found");
        } finally {
            session.close();
        }

        System.out.println("---> getAssays() : userId = " + userId);

        return ResponseEntity.ok(assays);
    }
}