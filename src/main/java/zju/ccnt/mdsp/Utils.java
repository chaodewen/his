package zju.ccnt.mdsp;

import java.sql.Date;
import java.util.UUID;

/**
 * Created by Dewayne on 2016/12/19.
 */

public class Utils {
    public static String genUUID() {
        return UUID.randomUUID().toString();
    }

    public static Date genSqlDate() {
        return new java.sql.Date(new java.util.Date().getTime());
    }
}