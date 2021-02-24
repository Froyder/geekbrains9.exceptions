package ru.geek.homeworks.lesson9.exeptions;

public class MainClassExceptions {

  //основной метод для проверки формата массива, наличия неформатных символов и подсчета суммы элементов
  public static void checkArray4to4(String[][] array) throws MyArraySizeException, MyArrayDataException {
      System.out.println("Проверяем массив...");
      if (array.length != 4 || (array[0].length != 4) || (array[1].length != 4)
              || (array[2].length != 4) || (array[3].length != 4)) {
          throw new MyArraySizeException("Ошибка! Это не массив формата 4х4!");
      }
      int arraySum = 0;
      for (int i = 0; i < array.length; i++) {
          for (int j = 0; j < array.length; j++) {
              try {
                  arraySum += Integer.parseInt(array[i][j]);
              } catch (Exception exception) {
                  throw new MyArrayDataException("Неподходящий формат данных в ячейке [" + i + "][" + j + "].");
              }
          }
      }  System.out.println("Сумма всех элементов в массиве: " + arraySum);
  }


  public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

    // создаем заведомо неподходящий массив и проверяем его на соответствие формату
    String[][] myArray = new String[][]{{"15", "44"}, {"35", "12"}, {"&", "16", "50", "71"}};
      try {
       checkArray4to4(myArray);
      } catch (MyArraySizeException exception) {
        System.out.println(exception.getMessage());
      } System.out.println();

    // создаем массив нужного формата, но с неформатными символами
    String[][] myArray2 = new String[][]{{"15", "44", "63", "12"}, {"22", "6", "word", "12"},
                    {"7", "31", "77", "43"}, {"27", "word", "50", "71"}};

      try {
        checkArray4to4(myArray2);
      } catch (MyArrayDataException exception) {
        System.out.println(exception.getMessage());
      } System.out.println();

    // создаем массив нужного формата и наполнения, вычисляем сумму элементов
    String[][] myArray3 = new String[][]{{"15", "44", "29", "12"}, {"22", "6", "35", "12"},
              {"7", "31", "77", "43"}, {"27", "56", "50", "71"}};

      try {
          checkArray4to4(myArray3);
      } catch (MyArrayDataException exception) {
          System.out.println(exception.getMessage());
      }

    }
}
