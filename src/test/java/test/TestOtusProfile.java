package test;

import data.User;
import helper.DataLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import page.AboutMePage;
import page.IndexPage;
import page.LogonPage;
import static org.junit.Assert.*;


public class TestOtusProfile extends Base {

    private Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    private User user = new DataLoader().load(User.class);



    @Test
    public void test(){

        IndexPage indexPage = new IndexPage(driver);
        LogonPage logonPage = indexPage.gotoPrivateArea();
        AboutMePage aboutMePage = logonPage.logon(login, password);

        logger.info("start fill");

        aboutMePage
                .setUserData(user)
                .save();

        logger.info("finish fill");

        aboutMePage.load();

        logger.info("start check");

        User savedUserData = aboutMePage.getUserData();

        assertEquals(savedUserData, user);

        logger.info("finish check");
    }


}
