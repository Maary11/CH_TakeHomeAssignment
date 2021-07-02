package com.CloudHumans.API_Project;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pro {
    private int age;
    private String education_level = new String();
    private float writing_score;
    private String referral_code = new String();
    private PastExperiences past_experiences = new PastExperiences();
    private InternetTest internet_test = new InternetTest();
    private String selected_Project = new String();

    public Pro(int age, String education_Level, float writing_score, String referral_code, PastExperiences past_experiences, InternetTest internet_test) {
        this.age = age;
        this.education_level = education_Level;
        this.writing_score = writing_score;
        this.referral_code = referral_code;
        this.past_experiences = past_experiences;
        this.internet_test = internet_test;
    }

    public Pro() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public float getWriting_score() {
        return writing_score;
    }

    public void setWriting_score(float writing_score) {
        this.writing_score = writing_score;
    }

    public String getReferral_code() {
        return referral_code;
    }

    public void setReferral_code(String referral_code) {
        this.referral_code = referral_code;
    }

    public PastExperiences getPast_experiences() {
        return past_experiences;
    }

    public void setPast_experiences(PastExperiences past_experiences) {
        this.past_experiences = past_experiences;
    }

    public InternetTest getInternet_test() {
        return internet_test;
    }

    public void setInternet_test(InternetTest internet_test) {
        this.internet_test = internet_test;
    }

    public String getSelected_Project() {
        return selected_Project;
    }

    public void setSelected_Project(String selected_Project) {
        this.selected_Project = selected_Project;
    }

    public boolean tokenValidation(String referral_Code){
        return referral_Code.equals("token1234");
    }

    public List<String> fillEligibles(){
        List<String> Eligibles = new ArrayList<>();

        Eligibles.add("Calculate the Dark Matter of the universe for Nasa");
        Eligibles.add("Determine if the Schrodinger's cat is alive");
        Eligibles.add("Attend to users support for a YXZ Company");
        Eligibles.add("Collect specific people information from their social media for XPTO Company");

        return Eligibles;
    }

    public int scoreDefinition(String education_Level, float writing_Score, String referral_Code, PastExperiences past_Experiences, InternetTest internet_Test){
        int score = 0;

        if(education_Level.equals("high_school")){
            score += 1;
        }else if(education_Level.equals("bachelors_degree_or_high")){
            score += 2;
        }

        if(past_Experiences.isSales()){
            score += 5;
        }
        if(past_Experiences.isSupport()){
            score += 3;
        }

        if(internet_Test.getDownload_speed() > 50){
            score += 1;
        }else if(internet_Test.getDownload_speed() < 5){
            score -= 1;
        }

        if(internet_Test.getUpload_speed() > 50){
            score += 1;
        }else if(internet_Test.getUpload_speed() < 5){
            score -= 1;
        }

        if(writing_Score < 0.3){
            score -= 1;
        }else if(writing_Score >= 0.3 && writing_Score <= 0.7){
            score += 1;
        }else if(writing_Score > 0.7){
            score += 2;
        }

        if(tokenValidation(referral_Code)){
            score += 1;
        }

        return score;
    }

    public JSONObject scoreEvaluation(int age, String education_Level, float writing_Score, String referral_Code, PastExperiences past_Experiences, InternetTest internet_Test) {

        int score = scoreDefinition(education_Level, writing_Score, referral_Code, past_Experiences, internet_Test);

        List<String> eligible_Projects = fillEligibles();
        List<String> ineligible_Projects = new ArrayList<>();
        JSONObject answer = new JSONObject();
        answer.put("score", score);

        if (age > 18) {
            if (score > 10) {
                answer.put("selected_project", "Calculate the Dark Matter of the universe for Nasa");
                answer.put("eligible_projects", eligible_Projects);
                answer.put("ineligible_projects", ineligible_Projects);
                return answer;
            }else if (score <= 10 && score > 5) {
                eligible_Projects.remove("Calculate the Dark Matter of the universe for Nasa");
                ineligible_Projects.add("Calculate the Dark Matter of the universe for Nasa");
                answer.put("selected_project", "Determine if the Schrodinger's cat is alive");
                answer.put("eligible_projects", eligible_Projects);
                answer.put("ineligible_projects", ineligible_Projects);
                return answer;
            }else if (score <= 5 && score > 3) {
                eligible_Projects.remove("Calculate the Dark Matter of the universe for Nasa");
                ineligible_Projects.add("Calculate the Dark Matter of the universe for Nasa");
                eligible_Projects.remove("Determine if the Schrodinger's cat is alive");
                ineligible_Projects.add("Determine if the Schrodinger's cat is alive");
                answer.put("selected_project", "Attend to users support for a YXZ Company");
                answer.put("eligible_projects", eligible_Projects);
                answer.put("ineligible_projects", ineligible_Projects);
                return answer;
            } else if (score <= 3 && score > 2){
                eligible_Projects.remove("Calculate the Dark Matter of the universe for Nasa");
                ineligible_Projects.add("Calculate the Dark Matter of the universe for Nasa");
                eligible_Projects.remove("Determine if the Schrodinger's cat is alive");
                ineligible_Projects.add("Determine if the Schrodinger's cat is alive");
                eligible_Projects.remove("Attend to users support for a YXZ Company");
                ineligible_Projects.add("Attend to users support for a YXZ Company");
                answer.put("selected_project", "Collect specific people information from their social media for XPTO Company");
                answer.put("eligible_projects", eligible_Projects);
                answer.put("ineligible_projects", ineligible_Projects);
                return answer;
            }else{
                eligible_Projects.remove("Calculate the Dark Matter of the universe for Nasa");
                ineligible_Projects.add("Calculate the Dark Matter of the universe for Nasa");
                eligible_Projects.remove("Determine if the Schrodinger's cat is alive");
                ineligible_Projects.add("Determine if the Schrodinger's cat is alive");
                eligible_Projects.remove("Attend to users support for a YXZ Company");
                ineligible_Projects.add("Attend to users support for a YXZ Company");
                eligible_Projects.remove("Collect specific people information from their social media for XPTO Company");
                ineligible_Projects.add("Collect specific people information from their social media for XPTO Company");
                answer.put("selected_project", "");
                answer.put("eligible_projects", eligible_Projects);
                answer.put("ineligible_projects", ineligible_Projects);
                return answer;
            }
        }
        eligible_Projects.remove("Calculate the Dark Matter of the universe for Nasa");
        ineligible_Projects.add("Calculate the Dark Matter of the universe for Nasa");
        eligible_Projects.remove("Determine if the Schrodinger's cat is alive");
        ineligible_Projects.add("Determine if the Schrodinger's cat is alive");
        eligible_Projects.remove("Attend to users support for a YXZ Company");
        ineligible_Projects.add("Attend to users support for a YXZ Company");
        eligible_Projects.remove("Collect specific people information from their social media for XPTO Company");
        ineligible_Projects.add("Collect specific people information from their social media for XPTO Company");
        answer.put("selected_project", "");
        answer.put("eligible_projects", eligible_Projects);
        answer.put("ineligible_projects", ineligible_Projects);
        return answer;
    }
}
