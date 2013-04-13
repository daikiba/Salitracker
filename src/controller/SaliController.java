/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import saliSql.*;

/**
 *
 * @author Kone
 */
public interface SaliController {
    boolean verifyUser();

    List<SaliLog> getUserLog();
    String getUserFullName();
    String getEmail();
    float getUserHeight();
    float getUserWeight();
    float getUserBMI(); // calculated from height and weight

    SaliWeekProgram getUserWeekProgram();
    SaliLogRow getLogAttribute(int reps, int sets, float weight); // return new only if doesn't exist in database

    void setUserFullName(String name);
    void setUserHeight(float height);
    void setUserWeight(float weight);
    void setEmail(String email);
    void setUserWeekProgram(SaliWeekProgram weekProgram);

    void addNewUserLog(SaliLog log);
    void addNewProgram(SaliProgram program);
    void addNewWeekProgram(SaliWeekProgram weekProgram);
    void addNewActivity(SaliActivity activity);
    void addNewMuscleGroup(SaliMuscleGroup muscleGroup);

    List<SaliMuscleGroup> getMuscleGroups();
    List<SaliProgram> getPrograms();
    List<SaliWeekProgram> getWeekPrograms();
    List<SaliActivity> getActivities();
}
