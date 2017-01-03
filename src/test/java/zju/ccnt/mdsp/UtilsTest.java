package zju.ccnt.mdsp;

import org.junit.Test;
import zju.ccnt.mdsp.utils.Utils;

import java.sql.Date;

/**
 * Created by Dewayne on 2017/1/1.
 */

public class UtilsTest {
    @Test
    public void testGetDate() {
        Date date = Utils.getDate("2016-03-12");
        System.out.println(date.toString());
    }
}