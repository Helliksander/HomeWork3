import java.io.*;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;


public class ExcelCreator {
    public static void main(String[] args) throws IOException {
        FromTxtReader vocabularyValue = new FromTxtReader();
        DateOfBirth birthDate = new DateOfBirth();
        GenderGenerator personSex = new GenderGenerator();
        InnNumberGenerator personInnNumber = new InnNumberGenerator();
        int currentNumber;
        int maxNumberOfRecord = (int) (Math.random()*30);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet theOnlySheet = workbook.createSheet("Единственная страница");

        File createdFile = new File("New file 1.xls");


        HSSFRow theHeadOfTheRows = theOnlySheet.createRow((short)0);
        theHeadOfTheRows.createCell(0).setCellValue("Имя");
        theHeadOfTheRows.createCell(1).setCellValue("Фамилия");
        theHeadOfTheRows.createCell(2).setCellValue("Отчество");
        theHeadOfTheRows.createCell(3).setCellValue("Возраст");
        theHeadOfTheRows.createCell(4).setCellValue("Пол");
        theHeadOfTheRows.createCell(5).setCellValue("Дата рождения");
        theHeadOfTheRows.createCell(6).setCellValue("ИНН");
        theHeadOfTheRows.createCell(7).setCellValue("Почтовый индекс");
        theHeadOfTheRows.createCell(8).setCellValue("Страна");
        theHeadOfTheRows.createCell(9).setCellValue("Область");
        theHeadOfTheRows.createCell(10).setCellValue("Город");
        theHeadOfTheRows.createCell(11).setCellValue("Улица");
        theHeadOfTheRows.createCell(12).setCellValue("Дом");
        theHeadOfTheRows.createCell(13).setCellValue("Квартира");

        for (currentNumber = 1; currentNumber < maxNumberOfRecord; currentNumber++) {
            HSSFRow currentCircleRow = theOnlySheet.createRow((short)currentNumber);

            if (personSex.getSexType() == "М") {
                currentCircleRow.createCell(0).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Имя (муж)"))));
                currentCircleRow.createCell(1).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Фамилия (муж)"))));
                currentCircleRow.createCell(2).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Отчество (муж)"))));
                currentCircleRow.createCell(4).setCellValue("М");
            } else {
                currentCircleRow.createCell(0).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Имя (жен)"))));
                currentCircleRow.createCell(1).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Фамилия (жен)"))));
                currentCircleRow.createCell(2).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Отчество (жен)"))));
                currentCircleRow.createCell(4).setCellValue("Ж");
            }
//            currentCircleRow.createCell(3).setCellValue(birthDate.calculateCurrentAge(birthDate.generateDateIfBirth())); - Причина, по которой не используется - работает некорректно
            currentCircleRow.createCell(5).setCellValue(birthDate.prepareToCellInsertationFormat(birthDate.generateDateIfBirth()));
            currentCircleRow.createCell(6).setCellValue(personInnNumber.deleteExcessSymbols(personInnNumber.generateNumberArray()));
            currentCircleRow.createCell(7).setCellValue(DateOfBirth.randomizeBetweenMinMax(100000, 700000));
            currentCircleRow.createCell(8).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Страна"))));
            currentCircleRow.createCell(9).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Область"))));
            currentCircleRow.createCell(10).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Город"))));
            currentCircleRow.createCell(11).setCellValue(vocabularyValue.returnRandomValueFromReadTxtArray(vocabularyValue.readFromTxt(vocabularyValue.determinatorOfFile("Улица"))));
            currentCircleRow.createCell(12).setCellValue(DateOfBirth.randomizeBetweenMinMax(1,200));
            currentCircleRow.createCell(13).setCellValue(DateOfBirth.randomizeBetweenMinMax(1,200));

        }

        try {
            workbook.write(createdFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Файл создан и находится в директории " + createdFile.getAbsolutePath());




    }
}
