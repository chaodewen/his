package zju.ccnt.mdsp.utils;

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
}