package  engine;

import java.lang.String;
import engine.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameEngine {

    private Player currentPlayer;
    private int nextPlayerNumber = 1;
    private List<Player> players;
    private List<GameDataFromXml> gdfx = new ArrayList<>();
    private GameDataFromXml currentGameData;
    private boolean isGameStarted = false;
    private int diceValue;
    private long startTime;
    private int numberOfTurns = 0;
    private int tryNumber;
    public enum WordCheck {
            CORRECT, WRONG, CHARS_NOT_PRESENT, TRIES_DEPLETED
    }

    public void loadXml(String pathToXml)
            throws WrongPathException, DictionaryNotFoundException, BoardSizeException, NotXmlFileException,
            DuplicateLetterException, NotValidXmlFileException, GameTypeException {
        GameDataFromXml gd = new GameDataFromXml();
        gd.initializingDataFromXml(pathToXml);
        //check validation:
        gd.isValidXml(pathToXml);
        gd.isDictionaryInRightPos();
        gd.isValidBoardSize(gd.getBoardSize());
        gd.isAllLettersAppearOnce();
        gdfx.add(gd);
    }


    public boolean isXmlLoaded() {
        return !gdfx.isEmpty();
    }

    public boolean isStarted() {
        return isGameStarted;
    }

    public void startGame() throws NumberOfPlayersException {
        currentGameData =  gdfx.get(0);
        players = new ArrayList<>();
        for (engine.jaxb.schema.generated.Player p: currentGameData.getPlayers()) {
            players.add(new Player(p.getName().get(0)));
        }
        currentPlayer = players.get(0);
        isGameStarted = true;
        startTime = System.currentTimeMillis();
        tryNumber = 1;
    }

    public Status getStatus() {
        if (currentGameData == null) {
            GameDataFromXml gd = gdfx.get(gdfx.size() - 1);
            return new Status(
                    gd.getBoard().getBoard(),
                    currentPlayer != null ? currentPlayer.getName() : null,
                    gd.getNumOfTries()
            );
        }
        return new Status(
                currentGameData.getBoard().getBoard(),
                currentPlayer != null ? currentPlayer.getName() : null,
                currentGameData.getNumOfTries()
        );
    }

    public int getDiceValue() {
        Random random = new Random();
        diceValue = random.nextInt(currentGameData.getNumOfCubeWigs() - 1) + 2;
        return diceValue;
    }

    public boolean updateBoard(List<int[]> points) {
        if (points.size() > diceValue) {
            return false;
        }
        try {
            currentGameData.updateBoard(points);
            return true;
        }
        catch (OutOfBoardBoundariesException e){
            // TODO: handel correctly
            System.out.println("Some of the points you chose are out of boandries!\n Try again.");
            return false;
        }
    }

    public char[][] getBoard() {
        return currentGameData.getBoard().getBoard();

    }

    public int getMaxRetries() {
        return currentGameData.getNumOfTries();
    }

    public WordCheck isWordValid(String word, int tries) {
        if (tries == tryNumber && tries <= currentGameData.getNumOfTries()) {
            //TODO: check if letters are shown in the board
            //TODO: remove used letters from board and add others
            if (!currentGameData.getBoard().hasChars(word)) {
                return WordCheck.CHARS_NOT_PRESENT;
            }
            if (currentGameData.getDictionary().hasWord(word)) {
                currentPlayer.updateScore(word, currentGameData.calcScore(word));
                nextPlayer();
                return WordCheck.CORRECT;
            }
            tryNumber++;
            return WordCheck.WRONG;
        }
        nextPlayer();
        return WordCheck.TRIES_DEPLETED;
    }

    private void nextPlayer() {
        currentPlayer = players.get(nextPlayerNumber);
        nextPlayerNumber = (nextPlayerNumber + 1) % players.size();
        numberOfTurns++;
        tryNumber = 1;
    }

    public Statistics getStatistics() {
        return new Statistics(players, System.currentTimeMillis() - startTime, numberOfTurns, currentGameData);
    }
}
