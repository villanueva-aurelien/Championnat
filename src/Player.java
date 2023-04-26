public class Player
{
    private int _point = 0;
    private int _victory = 0;
    private int _playerNumber = 0;
    private static int index = 0;

    public Player()
    {
        _playerNumber = index++;
    }
//-----------------------------------------------------------
    public int getPN()
    {
        return _playerNumber;
    }

    public int getPoint()
    {
        return _point;
    }

    public void setPoint(int p)
    {
        _point = p;
    }

    public int getVictory()
    {
        return _victory;
    }

    public void setVictory(int v)
    {
        _victory = v;
    }
}
