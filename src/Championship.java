import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Championship
{
    private int _maxPlayers = 32;
    private ArrayList<Player> _playerBordList = new ArrayList<>();
    private ArrayList<Player> _playerWinMatches = new ArrayList<>();
    private int _numberBattle;
    private int _compteur = 0;
    private ArrayList<Player> _playerList = new ArrayList<>();

    public Championship()
    {       
        createListOfPlayers();
        disputeMatch();
        sortTab(_playerBordList);
        displayResult();
    }

    /**
     * This method return the number of remaining matches
     * @param number Number players
     * @return       Number machtes
     */
    private int numberMatch(int number)
    {
        int result = number;
        if(result == 1)
            return _compteur;
        else
        {
            _compteur++;
            return numberMatch(number/2);
        }
    }

    /**
     * This methode create and add Player at List
     * And shuffle this List. 
     */
    private void createListOfPlayers()
    {
        while(_playerList.size()!=_maxPlayers)
        {
            Player p = new Player();
            _playerList.add(p);
        }

        Collections.shuffle(_playerList);
    }
    
    /**
     * This method plays matches between players
     * Call method attributPlayerToList().
     */
    private void disputeMatch()
    {
        _numberBattle = numberMatch(_maxPlayers);                           // Number matches

        for(int i = 0; i < _numberBattle; i++)
        {
            for(int j = 0; j < _playerList.size(); j+=2)
            {
                calculateResultPlayerMatches(_playerList.get(j), _playerList.get(j+1));
            }
            _playerList.clear();                                            // Clear this List
            _playerList.addAll(_playerWinMatches);                          // Add content '_playerWinMatches' at '_playerList'

            if(_playerList.size() == 1 && i == _numberBattle-1)                 
            {
                _playerBordList.add(_playerList.get(0));              // Add last Player to '_playerBordList'
            }

            _playerWinMatches.clear();                                      // Clear this List
        }
    }

    private void removePlayerOfList()
    {
        if(_playerList.size() == 2)
            return;
        
        _playerList.remove(0);
        _playerList.remove(0);
    }

    private void calculateResultPlayerMatches(Player A, Player B)
    {
        int result;

        result = (int)(Math.random()*2);
        //System.out.println(result);
        if(result == 0)
        {
            attributPlayerToList(A, B);
        }
        if(result == 1)
        {
            attributPlayerToList(B, A);
        }
    }

    private void attributPlayerToList(Player win, Player lose)
    {
        int pointGagne = 10;                                        // point for winner of matches

        win.setPoint(win.getPoint()+pointGagne);                    // add point to winner
        win.setVictory(win.getVictory()+1);                         // add victory
        _playerWinMatches.add(win);                                    // add Player to temporary ArrayList
        _playerBordList.add(lose);
    }

    /**
     * 
     * @param list
     */
    private void sortTab(ArrayList<Player> list)
    {
        Collections.sort(list, new Comparator<Player>()
        {
            @Override
            public int compare(Player A, Player B)
            {
                if(A.getVictory() < B.getVictory())
                    return 1;
                if(A.getVictory() > B.getVictory())
                    return -1;
                if(A.getVictory() == B.getVictory())
                    return 0;
                
                return 0; 
            }           
        });
    }


    /**
     * This method display result og Championship to console
     */
    private void displayResult()
    {
        for(Player p : _playerBordList)
        {
            System.out.println("Le Player : "+ p.getPN()+" a obtenu : "+p.getVictory()+" victoire avec "+ p.getPoint());
        }
    }

}
