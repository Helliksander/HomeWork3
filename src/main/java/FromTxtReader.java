import java.io.*;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class FromTxtReader {

    public String determinatorOfFile (String valueOfTxtFile) {

        String determinedNameTxtFile;


        if (valueOfTxtFile == "Имя (муж)") {
            determinedNameTxtFile = "src\\main\\resources\\NamesMale.txt";
        }else if (valueOfTxtFile == "Имя (жен)") {
            determinedNameTxtFile = "src\\main\\resources\\NamesFemale.txt";
        } else if (valueOfTxtFile == "Фамилия (муж)") {
            determinedNameTxtFile = "src\\main\\resources\\LastNamesMale.txt";
        } else if (valueOfTxtFile == "Фамилия (жен)") {
            determinedNameTxtFile = "src\\main\\resources\\LastNamesFemale.txt";
        } else if (valueOfTxtFile == "Отчество (муж)") {
            determinedNameTxtFile = "src\\main\\resources\\MiddleNamesMale.txt";
        } else if (valueOfTxtFile == "Отчество (жен)") {
            determinedNameTxtFile = "src\\main\\resources\\MiddleNamesFemale.txt";
        } else if (valueOfTxtFile == "Страна") {
            determinedNameTxtFile = "src\\main\\resources\\Countries.txt";
        } else if (valueOfTxtFile == "Область") {
            determinedNameTxtFile = "src\\main\\resources\\Regions.txt";
        } else if (valueOfTxtFile == "Город") {
            determinedNameTxtFile = "src\\main\\resources\\Cities.txt";
        } else {
            determinedNameTxtFile = "src\\main\\resources\\Streets.txt";
        }

        return determinedNameTxtFile;

    }


    public ArrayList<String> readFromTxt(String determinedNameTxtFile) throws IOException {

        File nameTxtFile = new File(determinedNameTxtFile);
        ArrayList<String> listOfNameValues = new ArrayList<String>(30);
        FileReader nameFileReader = new FileReader(nameTxtFile) ;
        BufferedReader nameBufferedReader = new BufferedReader(nameFileReader);

        String line = nameBufferedReader.readLine();

        while (line != null) {
            listOfNameValues.add(line);
            line = nameBufferedReader.readLine();
        }


        return listOfNameValues;
    }


    public String returnRandomValueFromReadTxtArray (ArrayList listOfNameValues) {
        return valueOf(listOfNameValues.get((int)(Math.random()*29)));
    }
}

