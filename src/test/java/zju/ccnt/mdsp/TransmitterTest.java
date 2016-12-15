package zju.ccnt.mdsp;

import org.junit.Test;
import zju.ccnt.mdsp.assaysheet.RegularBlood;

/**
 * Created by Cc on 2016/12/14.
 */

public class TransmitterTest {
    @Test
    public void testRegularBlood() {
        System.out.println(new RegularBlood().toJsonString());
    }
}