/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apothekeammarienplatz.geburtstagskarten;

import java.util.ArrayList;

/**
 *
 * @author asys
 */
public class PatientReviewer {

    PatientFileReader patientFileReader;
    ArrayList<Patient> listOfPatients;

    public PatientReviewer() {
        this.patientFileReader = new PatientFileReader();
        this.listOfPatients = patientFileReader.getListOfPatients();
    }

    public ArrayList getListOfPatients() {
        return listOfPatients;
    }

    public static void main(String[] args) {
        PatientReviewer patientReviewer = new PatientReviewer();
        ArrayList<Patient> listOfPatientsStatic = patientReviewer.getListOfPatients();

        listOfPatientsStatic.forEach((Patient patient) -> {
            System.out.println(patient.getVorname() + " " + patient.getNachname() + System.lineSeparator() + patient.getAdresse() + System.lineSeparator() + patient.getGeburtsDatum());
        });
    }

}
