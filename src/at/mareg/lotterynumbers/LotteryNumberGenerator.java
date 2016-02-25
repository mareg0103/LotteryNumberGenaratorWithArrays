package at.mareg.lotterynumbers;

public class LotteryNumberGenerator
{

  public static void main (final String [] args)
  {
    // necessary variables
    final InputHelper helper = new InputHelper ();
    String userInWhichGame;
    String userInHowManyRows;
    final int maxRowsAllowed = 12;
    int userInputRows;
    final String startOutput = "Das ist ein Lottozeilen-Generator!\nWas möchten Sie spielen?\n\nLotto > Drücken Sie bitte die 1\nEuromilionen > Drücken Sie bitte die 2.\n";
    final int lotteryHowManyNumbers = 6;
    final int lotteryMaxNumbers = 45;
    final int euroMillionHowManyNumbers = 5;
    final int euroMillionMaxNumbers = 50;
    final int euroMillionHowManyStarNumbers = 2;
    final int euroMillionMaxStarNumbers = 11;
    ;

    // get user input
    userInWhichGame = helper.getUserInput (startOutput);
    userInHowManyRows = helper.getUserInput ("Wieviele Zahlenreihen möchten Sie generiert haben (max " +
                                                maxRowsAllowed +
                                                ")?  ");
    userInputRows = Integer.parseInt (userInHowManyRows);

    // if userInputNumber is from 1 to maxRowsAllowed and game selection is 1...
    if (userInputRows > 0 && userInputRows <= maxRowsAllowed && userInWhichGame.contains ("1"))
    {

      final LotteryNumbers lottoNum = new LotteryNumbers (userInputRows, lotteryHowManyNumbers, lotteryMaxNumbers);
      final int [] [] iList = lottoNum.generate ();

      for (int x = 0; x < userInputRows; x++)
      {
        for (int y = 0; y < 6; y++)
        {
          checkIntLength (iList[x][y]);
          System.out.print (iList[x][y] + " ");
        }
        System.out.println ();
      }
    }
    else // ...else if userInputNumber is from 1 to maxRowsAllowed and game
         // selection is 2
      if (userInputRows > 0 && userInputRows <= maxRowsAllowed && userInWhichGame.contains ("2"))
      {
        final EuroMillionNumbers euroMillionNum = new EuroMillionNumbers (userInputRows,
                                                                          euroMillionHowManyNumbers,
                                                                          euroMillionMaxNumbers,
                                                                          euroMillionHowManyStarNumbers,
                                                                          euroMillionMaxStarNumbers);
        final int [] [] iList = euroMillionNum.generateLotto ();
        final int [] [] iStarList = euroMillionNum.generateStar ();

        for (int x = 0; x < userInputRows; x++)
        {
          for (int y = 0; y < 5; y++)
          {
            checkIntLength (iList[x][y]);
            System.out.print (iList[x][y] + " ");
          }

          System.out.print (" Sternnummern: ");

          for (int y = 0; y < 2; y++)
          {
            checkIntLength (iStarList[x][y]);
            System.out.print (iStarList[x][y] + " ");
          }
          System.out.println ();
        }

      }
      // else invalid input
      else
      {
        System.out.println ("Keine gültige Eingabe, Programm wird beendet!!!");
      }

  }

  private static void checkIntLength (final int num)
  {

    if (String.valueOf (num).length () == 1)
    {
      System.out.print ("0");
    }
  }
}
