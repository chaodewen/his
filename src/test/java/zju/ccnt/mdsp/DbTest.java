package zju.ccnt.mdsp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import zju.ccnt.mdsp.db.MySqlSessionFactory;
import zju.ccnt.mdsp.mapping.DrugItem;
import zju.ccnt.mdsp.mapping.Recipe;
import zju.ccnt.mdsp.mapping.SingleDrugItem;

/**
 * Created by Cc on 2016/12/14.
 */

public class DbTest {
    private Session session;
    private Transaction transaction;

    @Before
    public void setup() {
        // 建立SessionFactory
        SessionFactory factory = MySqlSessionFactory.getInstance();
        // 取得Session
        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    @Test
    public void testInsertion() {
        Recipe recipe = new Recipe();
        recipe.setRdate(Utils.genSqlDate());
        recipe.setName("abc");
        recipe.setGender(0);
        recipe.setRecordId("1234567");
        recipe.setAddress("浙江大学玉泉校区");
        recipe.setDiagnosis("轻微感冒");
        recipe.setDoctor("张医生");
        recipe.setCharge(37.8);
        recipe.setChecker("王医生");
        recipe.setAge(18);
        session.save(recipe);

        DrugItem di1 = new DrugItem();
        di1.setDosageUnit("剂");
        di1.setDosageQuantity(1);
        di1.setNote("每日一剂，水煎400ml，分早晚两次空腹温服");
        di1.setTimePerDay(1);
        di1.setRecipeId(recipe.getId());
        session.save(di1);

        DrugItem di2 = new DrugItem();
        di2.setDosageUnit("片");
        di2.setDosageQuantity(2);
        di2.setNote("口服");
        di2.setTimePerDay(3);
        di2.setRecipeId(recipe.getId());
        session.save(di2);

        SingleDrugItem sdi1 = new SingleDrugItem();
        sdi1.setName("当归");
        sdi1.setPurchaseQuantity(new Double(10));
        sdi1.setPurchaseUnit("克");
        sdi1.setDrugItemId(di1.getId());
        session.save(sdi1);

        SingleDrugItem sdi2 = new SingleDrugItem();
        sdi2.setName("枸杞");
        sdi2.setPurchaseQuantity(new Double(5));
        sdi2.setPurchaseUnit("克");
        sdi2.setDrugItemId(di1.getId());
        session.save(sdi2);

        SingleDrugItem sdi3 = new SingleDrugItem();
        sdi3.setName("银翘片");
        sdi3.setPurchaseQuantity(new Double(2));
        sdi3.setPurchaseUnit("袋");
        sdi3.setDrugItemId(di2.getId());
        session.save(sdi3);
    }

    @Test
    public void testQuery() {
        Recipe recipe = session.get(Recipe.class, Integer.valueOf(1));
        System.out.println(recipe.getId());
        System.out.println(recipe.getAddress());
        System.out.println(recipe.getName());
        System.out.println(recipe.getDiagnosis());
        System.out.println(recipe.getRdate());
        System.out.println(recipe.getDoctor());
        Assert.assertEquals(recipe.getId(), 1);
    }

    @After
    public void close() {
        transaction.commit();
        session.close();
    }
}