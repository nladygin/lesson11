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
                aboutMePage
                        .putFName(fName)
                        .putFNameLatin(fNameLatin)
                        .putLName(lName)
                        .putLNameLatin(lNameLatin)
                        .putBlogName(blogName)
                        .putBDay(bDay)
                        .selectCountry(country)
                        .selectCity(city)
                        .setSchedule(schedule)
                        .setContact0(contactValue)
                        .setContact1(contactValue)
                        .setGender(gender)
                        .setCompany(companyName)
                        .setWork(work)
                        .save();
        logger.info("finish fill");
    }



    @Test
    public void check() {
        logger.info("start check");
            AboutMePage aboutMePage = gotoAboutMePage();
                aboutMePage
                        .checkFName(fName)
                        .checkFNameLatin(fNameLatin)
                        .checkLName(lName)
                        .checkLNameLatin(lNameLatin)
                        .checkBlogName(blogName)
                        .checkBDay(bDay)
                        .checkCountry(country)
                        .checkCity(city)
                        .checkSchedule(schedule)
                        .checkContact0(contactValue)
                        .checkContact1(contactValue)
                        .checkGender(gender)
                        .checkCompany(companyName)
                        .checkWork(work);
        logger.info("finish check");
    }





    private AboutMePage gotoAboutMePage() {
        IndexPage indexPage = new IndexPage(driver);
        LogonPage logonPage = indexPage.gotoPrivateArea();
        return logonPage.logon(login, password);
    }


}
