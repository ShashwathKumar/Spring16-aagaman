package gopackdev.arrivalpack.bluemixbean;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/**
 * Created by Chi-Han on 3/30/2016.
 */
public class StudentBean {
    String schoolEmail;
    String passWord;
    String firstName;
    String lastName;
    String gender;
    String firstLanguage;
    String nationality;
    String dietaryRestriction;
    String interestExpertise;
    String clubParticipated;
    String favoriteClass;
    String recentConcern;
    String somethingWantToTryInFuture;
    //The primary key from db
    String id;
    int sleepTime = 0;
    int wakeupTime = 0;
    int schoolID = 0;
    /**
     * Constructor
     *
     * @param schoolEmail
     * @param passWord
     * @param firstName
     * @param lastName
     * @param gender
     * @param firstLanguage
     * @param nationality
     * @param dietaryRestriction
     * @param interestExpertise
     * @param clubParticipated
     * @param favoriteClass
     * @param recentConcern
     * @param somethingWantToTryInFuture
     * @param sleepTime
     * @param wakeupTime
     */
    public StudentBean(String schoolEmail, String passWord, int schoolID,
                       String firstName, String lastName, String gender,
                       String firstLanguage, String nationality, String dietaryRestriction,
                       String interestExpertise, String clubParticipated, String favoriteClass,
                       String recentConcern, String somethingWantToTryInFuture,
                       int sleepTime, int wakeupTime){
        this.schoolEmail = schoolEmail;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.firstLanguage = firstLanguage;
        this.nationality = nationality;
        this.dietaryRestriction = dietaryRestriction;
        this.interestExpertise = interestExpertise;
        this.clubParticipated = clubParticipated;
        this.favoriteClass = favoriteClass;
        this.recentConcern = recentConcern;
        this.somethingWantToTryInFuture = somethingWantToTryInFuture;
        this.sleepTime = sleepTime;
        this.wakeupTime = wakeupTime;
        this.schoolID = schoolID;
    }

    public StudentBean(JSONObject json){
        try {
            this.schoolEmail = json.getString("school_email");
            this.passWord = json.getString("password");
            this.schoolID = json.getInt("school_id");
            this.firstName = json.getString("first_name");
            this.lastName = json.getString("last_name");
            this.gender = json.getString("gender");
            this.firstLanguage = json.getString("first_language");
            this.nationality = json.getString("nationality");
            this.dietaryRestriction = json.getString("dietary_restriction");
            this.interestExpertise = json.getString("interest_expertise");
            this.clubParticipated = json.getString("club_participated");
            this.favoriteClass = json.getString("favorite_class");
            this.recentConcern = json.getString("recent_concern");
            this.somethingWantToTryInFuture = json.optString("something_want_to_try_in_future");
            this.sleepTime = json.getInt("sleep_time");
            this.wakeupTime = json.getInt("wakeup_time");
            //add id attribute.
            this.id = json.optString("id");
        } catch (JSONException e) {
            Log.e("StudentBean", "Error reading JSON in constructor: " + e.getLocalizedMessage());
        }
    }
    /**
     *  Get JSON data format for Student
     * @return
     */

    public String JSONFormat(){
//        String json = "{" +
//                "  \"school_email\": \""+this.schoolEmail+"\"," +
//                " \"school_id\": \""+this.schoolID+"\","+
//                "  \"password\": \""+this.passWord+"\"," +
//                "  \"first_name\": \""+this.firstName+"\"," +
//                "  \"last_name\": \""+this.lastName+"\"," +
//                "  \"gender\": \""+this.gender+"\"," +
//                "  \"first_language\": \""+this.firstLanguage+"\"," +
//                "  \"nationality\": \""+this.nationality+"\"," +
//                "  \"dietary_restriction:\": \""+this.dietaryRestriction+"\"," +
//                "  \"interest_expertise\": \""+this.interestExpertise+"\"," +
//                "  \"club_participated\": \""+this.clubParticipated+"\"," +
//                "  \"favorite_class\": \""+this.favoriteClass+"\"," +
//                "  \"recent_concern\": \""+this.recentConcern+"\"," +
//                "  \"something_want_to_try_in_future\": \""+this.somethingWantToTryInFuture+"\"," +
//                "  \"sleep_time\": 0," +
//                "  \"wakeup_time\": 0" +
//                "}";
        JSONObject obj = new JSONObject();
        try {
            obj.put("school_email",this.schoolEmail);
            obj.put("school_id",this.schoolID);
            obj.put("password",this.passWord);
            obj.put("first_name",this.firstName);
            obj.put("last_name",this.lastName);
            obj.put("gender",this.gender);
            obj.put("first_language",this.firstLanguage);
            obj.put("nationality",this.nationality);
            obj.put("dietary_restriction",this.dietaryRestriction);
            obj.put("interest_expertise",this.interestExpertise);
            obj.put("club_participated",this.clubParticipated);
            obj.put("favorite_class",this.favoriteClass);
            obj.put("recent_concern",this.recentConcern);
            obj.put("something_want_to_try_in_future",this.somethingWantToTryInFuture);
            obj.put("sleep_time",this.sleepTime);
            obj.put("wakeup_time",this.wakeupTime);
            if(this.id != null && this.id.length() > 0){
                //if the object converting back to JSON has id...
                obj.put("id", this.id);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();

    }
    public void setID(String id){
        this.id = id;
    }

    public String getID(){
        return id;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public boolean isMale(){
        return gender.toLowerCase().equals("male");
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage = firstLanguage;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDietaryRestriction() {
        return dietaryRestriction;
    }

    public void setDietaryRestriction(String dietaryRestriction) {
        this.dietaryRestriction = dietaryRestriction;
    }

    public String getInterestExpertise() {
        return interestExpertise;
    }

    public void setInterestExpertise(String interestExpertise) {
        this.interestExpertise = interestExpertise;
    }

    public String getClubParticipated() {
        return clubParticipated;
    }

    public void setClubParticipated(String clubParticipated) {
        this.clubParticipated = clubParticipated;
    }

    public String getFavoriteClass() {
        return favoriteClass;
    }

    public void setFavoriteClass(String favoriteClass) {
        this.favoriteClass = favoriteClass;
    }

    public String getRecentConcern() {
        return recentConcern;
    }

    public void setRecentConcern(String recentConcern) {
        this.recentConcern = recentConcern;
    }

    public String getSomethingWantToTryInFuture() {
        return somethingWantToTryInFuture;
    }

    public void setSomethingWantToTryInFuture(String somethingWantToTryInFuture) {
        this.somethingWantToTryInFuture = somethingWantToTryInFuture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int getWakeupTime() {
        return wakeupTime;
    }

    public void setWakeupTime(int wakeupTime) {
        this.wakeupTime = wakeupTime;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }
}
