package com.apothekeammarienplatz.geburtstagskarten;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Copyright (C) 2021 Mandelkow
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
/**
 *
 * @author Mandelkow
 */
public class PatientFileReader {

    ArrayList<Patient> listOfPatients = new ArrayList<>();

    public PatientFileReader() {
        listOfPatients = readPatientFile();
    }

    public final ArrayList readPatientFile() {
        ArrayList listOfPatientsRead = new ArrayList();
        String todoFilePath = "C:\\Users\\Apothekenadmin\\Desktop\\Kundenliste Marienplatz.txt";
        try (FileReader reader = new FileReader(todoFilePath)) {
            String[] patientLineStrings;

            List<String[]> patientLineStringsList;
            patientLineStringsList = getPatientLineList(reader);

            for (int lineNumber = 0; lineNumber < patientLineStringsList.size(); lineNumber++) {
                patientLineStrings = patientLineStringsList.get(lineNumber);
                try {
                    Patient patient = new Patient(patientLineStrings);
                    listOfPatientsRead.add(patient);
                } catch (Exception e) {
                    /**
                     * Der Patient hatte unvollständige Daten. Er wird
                     * übersprungen.
                     */
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(PatientFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOfPatientsRead;
    }

    private List<String[]> getPatientLineList(Reader reader) throws IOException, CsvValidationException {
        List<String[]> list = new ArrayList<>();

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(0)
                .withCSVParser(parser)
                .build();

        String[] line;
        while ((line = csvReader.readNext()) != null) {
            list.add(line);
        }
        reader.close();

        return list;
    }

    public ArrayList<Patient> getListOfPatients() {
        return listOfPatients;
    }
}
