package ru.clevertec.plugin.service

class FileService {

    void writeToFile(String fileName, String message) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(message)
        }
    }
}
