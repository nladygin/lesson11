import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestOtus extends Base {

    private final String fName = "Николай";
    private final String fNameLatin = "Nikolay";
    private final String lName = "Ладыгин";
    private final String lNameLatin = "Ladygin";
    private final String blogName = "Nikolay";
    private final String bDay = "19.12.1980";
    private final String country = "Россия";
    private final String city = "Екатеринбург";
    private final String schedule = "Полный день";
    private final String contactValue = "+79221600984";
    private final String gender = "Мужской";
    private final String companyName = "Общество с ограниченной ответственностью  «Эч А Эс»";
    private final String work = "Тестировщик ПО";



    private Logger logger = LogManager.getLogger(this.getClass().getSimpleName());



    @Test
    public void fill(){
        logger.info("start fill");
            AboutMePage aboutMePage = gotoAboutMePage();
                aboutMePage.putFName(fName);
                aboutMePage.putFNameLatin(fNameLatin);
                aboutMePage.putLName(lName);
                aboutMePage.putLNameLatin(lNameLatin);
                aboutMePage.putBlogName(blogName);
                aboutMePage.putBDay(bDay);
                aboutMePage.selectCountry(country);
                aboutMePage.selectCity(city);
                aboutMePage.setSchedule(schedule);
                aboutMePage.setContact0(contactValue);
                aboutMePage.setContact1(contactValue);
                aboutMePage.setGender(gender);
                aboutMePage.setCompany(companyName);
                aboutMePage.setWork(work);
                aboutMePage.save();
        logger.info("finish fill");
    }



    @Test
    public void check() {
        logger.info("start check");
            AboutMePage aboutMePage = gotoAboutMePage();
                aboutMePage.checkFName(fName);
                aboutMePage.checkFNameLatin(fNameLatin);
                aboutMePage.checkLName(lName);
                aboutMePage.checkLNameLatin(lNameLatin);
                aboutMePage.checkBlogName(blogName);
                aboutMePage.checkBDay(bDay);
                aboutMePage.checkCountry(country);
                aboutMePage.checkCity(city);
                aboutMePage.checkSchedule(schedule);
                aboutMePage.checkContact0(contactValue);
                aboutMePage.checkContact1(contactValue);
                aboutMePage.checkGender(gender);
                aboutMePage.checkCompany(companyName);
                aboutMePage.checkWork(work);
        logger.info("finish check");
    }





    private AboutMePage gotoAboutMePage() {
        IndexPage indexPage = new IndexPage(driver);
        LogonPage logonPage = indexPage.gotoPrivateArea();
        return logonPage.logon(login, password);
    }


}
