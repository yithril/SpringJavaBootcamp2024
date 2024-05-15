package org.example;

public class Main {
    public static void main(String[] args) {
        StudentRoutine studentRoutine = new StudentRoutine();

        studentRoutine.doRoutine();

        OfficeWorkerRoutine officeWorkerRoutine = new OfficeWorkerRoutine();
        officeWorkerRoutine.doRoutine();
    }
}