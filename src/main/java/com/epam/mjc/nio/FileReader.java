package com.epam.mjc.io;

import com.epam.mjc.nio.Profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class FileReader
{

    public Profile getDataFromFile(File file)
    {
        Profile profile = null;

        try (InputStream inputStream = new FileInputStream(file))
        {
            if(!Files.exists(file.toPath())) {
                throw new IOException("File not found");
            }
            //Read file and save lines
            String fileContent = new String(inputStream.readAllBytes());
            String[] lines = fileContent.split("\\R");

            //Parse lines and get the data
            String name = lines[0].split(" ")[1];
            Integer age = Integer.parseInt(lines[1].split(" ")[1]);
            String email = lines[2].split(" ")[1];
            Long phone = Long.parseLong(lines[3].split(" ")[1]);

            //Create profile
            profile = new Profile(name, age, email, phone);
        } catch (IOException e)
        {
            //Some exception handling
        }

        return profile;
    }
}
