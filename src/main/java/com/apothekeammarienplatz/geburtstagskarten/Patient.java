/*
 * Copyright (C) 2021 asys
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.apothekeammarienplatz.geburtstagskarten;

/**
 *
 * @author asys
 */
public class Patient {

    private String vorname;
    private String nachname;
    private String geburtsDatum;

    private String straße;
    private String postleitzahl;
    private String ort;

    public Patient(String[] patientLineStrings) throws Exception {

        try {
            vorname = patientLineStrings[2];
            nachname = patientLineStrings[3];
            geburtsDatum = patientLineStrings[13];

            straße = patientLineStrings[5];
            postleitzahl = patientLineStrings[8];
            ort = patientLineStrings[9];
        } catch (Exception e) {
            String fehlerText = "Es fehlen wichtige Patientendaten.";
            System.out.println(fehlerText);
            throw new Exception(fehlerText);
        }
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getGeburtsDatum() {
        return geburtsDatum;
    }

    public String getAdresse() {
        return straße + System.lineSeparator() + postleitzahl + " " + ort;
    }

}
