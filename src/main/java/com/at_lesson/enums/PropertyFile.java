package com.at_lesson.enums;

public class PropertyFile {

//     CONFIG("config.properties"),
//    EMAIL("email.properties");

    private String pathToFile;

    PropertyFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }
}
