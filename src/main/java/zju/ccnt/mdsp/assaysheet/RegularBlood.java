package zju.ccnt.mdsp.assaysheet;

import com.alibaba.fastjson.JSON;
import zju.ccnt.mdsp.statics.RegularBloodStatics;

/**
 * Created by Dewayne on 2016/11/13.
 */

class Statics {
    String code, item, reference;
    double result;

    public Statics(String code, String item, String reference, double result) {
        this.code = code;
        this.item = item;
        this.reference = reference;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}

public class RegularBlood {
    private Statics[] statics = new Statics[16];

    public RegularBlood() {
        for (int i = 0; i < statics.length; i++) {
            statics[i] = new Statics(RegularBloodStatics.codes[i], RegularBloodStatics.items[i]
                    , RegularBloodStatics.reference[i], RegularBloodStatics.results[i]);
        }
    }

    public String toJsonString() {
        return JSON.toJSONString(this.statics);
    }
}