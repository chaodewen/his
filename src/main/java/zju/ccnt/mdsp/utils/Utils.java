package zju.ccnt.mdsp.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by Dewayne on 2016/12/25.
 */

public class Utils {
    public static ResponseEntity genErrorResponse(HttpStatus status
            , String message) {
        return new ResponseEntity("{\"error\":\"" + message + "\"}"
                , status);
    }
}