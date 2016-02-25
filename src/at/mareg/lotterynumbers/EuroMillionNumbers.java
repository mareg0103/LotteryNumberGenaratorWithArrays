package at.mareg.lotterynumbers;

public class EuroMillionNumbers extends Lottery
{

  private final int maxStarNumbers;
  private final int howMuchStarNumbers;

  public EuroMillionNumbers (final int howMany,
                             final int howMuch,
                             final int maxLotto,
                             final int howMuchStar,
                             final int maxStar)
  {
    super (howMany, howMuch, maxLotto);
    this.howMuchStarNumbers = howMuchStar;
    this.maxStarNumbers = maxStar;
  }

  public int [] [] generateLotto ()
  {
    int [] [] tRow = new int [howManyRows] [howMuchNumbers];

    tRow = generate (tRow, howManyRows, howMuchNumbers, maxNumbers);

    return tRow;
  }

  public int [] [] generateStar ()
  {
    int [] [] tStarRow = new int [howManyRows] [howMuchStarNumbers];

    tStarRow = generate (tStarRow, howManyRows, howMuchStarNumbers, maxStarNumbers);

    return tStarRow;
  }

  private int [] [] generate (final int [] [] list, final int rows, final int numbers, final int max)
  {
    final int [] [] tRow = list;
    boolean isIn = false;

    for (int x = 0; x < rows; x++)
    {
      for (int y = 0; y < numbers; y++)
      {
        final int num = (int) (Math.random () * max) + 1;

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
