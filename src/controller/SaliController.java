/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Set;
import saliSql.*;

/**
 *
 * @author Kone
 */
public interface SaliController {
    boolean verifyUser(String username, String password);

    Set<SaliLog> getUserLog();
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
    boolean addNewProgram(String name, Set<SaliActivity> iSet);
    boolean addNewWeekProgram(String name, Set<SaliProgram> iSet);
    boolean addNewActivity(String name, String description, int defaultAmountOfReps, Set<SaliMuscleGroup> iSet);
    void addNewMuscleGroup(SaliMuscleGroup muscleGroup);

    Set<SaliMuscleGroup> getMuscleGroups();
    Set<SaliProgram> getPrograms();
    Set<SaliWeekProgram> getWeekPrograms();
    Set<SaliActivity> getActivities();
}
