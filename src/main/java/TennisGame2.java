import java.util.Objects;

public class TennisGame2 implements TennisGame {

    public int player1Points = 0;
    public int player2Points = 0;

    private final String[] scoreStringArrayEquals = new String[]{"Love-All", "Fifteen-All", "Thirty-All"};
    private final String[] scoreStringArray = new String[]{"Love", "Fifteen", "Thirty","Forty"};
    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";

        if (isEqualsScores()) {
            score = getStringScoreEqualsAndLessFour();
        }

        if(isLessFourScores(4) && !isEqualsScores()) {

            score = scoreStringArray[player1Points] + "-" + scoreStringArray[player2Points];

        }

        if (player1Points > player2Points && player2Points >= 3) {
            score = "Advantage " + this.player1Name;
        }

        if (player2Points > player1Points && player1Points >= 3) {
            score = "Advantage " + this.player2Name;
        }

        if (player1Points >= 4 && player2Points >= 0 && (player1Points - player2Points) >= 2) {
            score = "Win for " + this.player1Name;
        }
        if (player2Points >= 4 && player1Points >= 0 && (player2Points - player1Points) >= 2) {
            score = "Win for " + this.player2Name;
        }
        return score;
    }

    //region General Comparisons

    private boolean isEqualsScores() {

        return this.player1Points == this.player2Points;
    }

    private boolean isLessFourScores(int limit) {

        return this.player1Points < limit && this.player2Points < limit;
    }

    //endregion

    private String getStringScoreEqualsAndLessFour() {

        String score = "Deuce";

        if (player1Points < 3) {

            score = scoreStringArrayEquals[this.player1Points];

        }

        return score;
    }

    private void P1Score() {
        player1Points++;
    }

    private void P2Score() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, this.player1Name))
            P1Score();
        else
            P2Score();
    }
}