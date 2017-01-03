package zju.ccnt.mdsp.utils;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Dewayne on 2016/12/25.
 */

public class Utils {
    public static ResponseEntity genErrorResponse(HttpStatus status
            , String message) {
        return new ResponseEntity("{\"error\":\"" + message + "\"}"
                , status);
    }
    public static Date getDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new Date(sdf.parse(str).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Query getQueryBySql(Session session, String sql
            , String start, String end) {
        if(!"default".equals(start) && !"default".equals(end)) {
            sql += " AND createdDate >= ? AND createdDate <= ?";
            Query query = session.createQuery(sql);
            query.setParameter(0, Utils.getDate(start));
            query.setParameter(1, Utils.getDate(end));
            return query;
        }
        else if(!"default".equals(start)) {
            sql += " AND createdDate >= ?";
            Query query = session.createQuery(sql);
            query.setParameter(0, Utils.getDate(start));
            return query;
        }
        else if(!"default".equals(end)) {
            sql += " AND createdDate <= ?";
            Query query = session.createQuery(sql);
            query.setParameter(0, Utils.getDate(end));
            return query;
        }
        else {
            Query query = session.createQuery(sql);
            return query;
        }
    }
}