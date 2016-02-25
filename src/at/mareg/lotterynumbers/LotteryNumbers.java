package at.mareg.lotterynumbers;

public class LotteryNumbers extends Lottery
{
  public LotteryNumbers (final int howMany, final int howMuch, final int max)
  {
    super (howMany, howMuch, max);
  }

  public int [] [] generate ()
  {
    final int [] [] tRow = new int [howManyRows] [howMuchNumbers];
    boolean isIn = false;

    for (int x = 0; x < howManyRows; x++)
    {
      for (int y = 0; y < howMuchNumbers; y++)
      {
        final int num = (int) (Math.random () * maxNumbers) + 1;

        for (final int temp : tRow[x])
        {
          if (temp == num)
          {
            isIn = true;
            break;
          }
        }

        if (!isIn)
        {
          tRow[x][y] = num;
        }
        else
        {
          y--;
        }

        isIn = false;

      }
    }

    return tRow;
  }
}
