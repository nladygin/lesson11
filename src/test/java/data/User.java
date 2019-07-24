package data;

import java.util.Objects;

public class User {


    private String fName;
    private String fNameLatin;
    private String lName;
    private String lNameLatin;
    private String blogName;
    private String bDay;
    private String country;
    private String city;
    private String scheduleFull;
    private String scheduleFlexible;
    private String scheduleRemote;
    private String contactValue0;
    private String contactValue1;
    private String gender;
    private String companyName;
    private String work;



    public String getfName() {
        return fName;
    }

    public String getfNameLatin() {
        return fNameLatin;
    }

    public String getlName() {
        return lName;
    }

    public String getlNameLatin() {
        return lNameLatin;
    }

    public String getBlogName() {
        return blogName;
    }

    public String getbDay() {
        return bDay;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getScheduleFull() {
        return scheduleFull;
    }

    public String getScheduleFlexible() {
        return scheduleFlexible;
    }

    public String getScheduleRemote() {
        return scheduleRemote;
    }

    public String getContactValue0() {
        return contactValue0;
    }

    public String getContactValue1() {
        return contactValue1;
    }

    public String getGender() {
        return gender;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWork() {
        return work;
    }





    public User setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public User setfNameLatin(String fNameLatin) {
        this.fNameLatin = fNameLatin;
        return this;
    }

    public User setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public User setlNameLatin(String lNameLatin) {
        this.lNameLatin = lNameLatin;
        return this;
    }

    public User setBlogName(String blogName) {
        this.blogName = blogName;
        return this;
    }

    public User setbDay(String bDay) {
        this.bDay = bDay;
        return this;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public User setScheduleFull(String schedule) {
        this.scheduleFull = schedule;
        return this;
    }

    public User setScheduleFlexible(String schedule) {
        this.scheduleFlexible = schedule;
        return this;
    }

    public User setScheduleRemote(String schedule) {
        this.scheduleRemote = schedule;
        return this;
    }

    public User setContactValue0(String contactValue) {
        this.contactValue0 = contactValue;
        return this;
    }

    public User setContactValue1(String contactValue) {
        this.contactValue1 = contactValue;
        return this;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public User setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public User setWork(String work) {
        this.work = work;
        return this;
    }



    @Override
    public String toString(){
        String result = new String();
        return result
                        .concat(fName).concat(",")
                        .concat(fNameLatin).concat(",")
                        .concat(lName).concat(",")
                        .concat(lNameLatin).concat(",")
                        .concat(blogName).concat(",")
                        .concat(bDay).concat(",")
                        .concat(country).concat(",")
                        .concat(city).concat(",")
                        .concat(scheduleFull).concat(",")
                        .concat(scheduleFlexible).concat(",")
                        .concat(scheduleRemote).concat(",")
                        .concat(contactValue0).concat(",")
                        .concat(contactValue1).concat(",")
                        .concat(gender).concat(",")
                        .concat(companyName).concat(",")
                        .concat(work);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fName, user.fName) &&
                Objects.equals(fNameLatin, user.fNameLatin) &&
                Objects.equals(lName, user.lName) &&
                Objects.equals(lNameLatin, user.lNameLatin) &&
                Objects.equals(blogName, user.blogName) &&
                Objects.equals(bDay, user.bDay) &&
                Objects.equals(country, user.country) &&
                Objects.equals(city, user.city) &&
                Objects.equals(scheduleFull, user.scheduleFull) &&
                Objects.equals(scheduleFlexible, user.scheduleFlexible) &&
                Objects.equals(scheduleRemote, user.scheduleRemote) &&
                Objects.equals(contactValue0, user.contactValue0) &&
                Objects.equals(contactValue1, user.contactValue1) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(companyName, user.companyName) &&
                Objects.equals(work, user.work);
    }


    @Override
    public int hashCode() {
        return Objects.hash(fName, fNameLatin, lName, lNameLatin, blogName, bDay, country, city, scheduleFull, scheduleFlexible, scheduleRemote, contactValue0, contactValue1, gender, companyName, work);
    }
}
