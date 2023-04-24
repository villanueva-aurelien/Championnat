public class Champ
{
    private static final int MAX_PLAYERS = 32;
    private Player[] _playerBord;
    private int _numberBattle;




    private int numberMatch(int number)
    {
        int result = number;
        if(result == 0)
            return 1;
        else
            return result * numberMatch(number/2);
    }

    private int remainingPlayer(int number)
    {
        int result = number/2;
        return result;
    }
}
