import java.util.Objects;

public class TennisGame2 implements TennisGame {

    private int player1Points = 0;
    private int player2Points = 0;

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

        if(!isEqualsScores()){

            score = getScoreLessOrGreaterFour();
        }

        return score;
    }

    //region General Comparisons

    private boolean isEqualsScores() {

        return this.player1Points == this.player2Points;
    }

    private boolean isLessThan(int limit) {

        return this.player1Points < limit && this.player2Points < limit;
    }

    private String getHighScorePlayerName() {

        String highScoreName = this.player1Name;

        if(this.player1Points < this.player2Points){

            highScoreName = this.player2Name;
        }

        return highScoreName;
    }

    //endregion

    //region Cases

    //region Equals

    private String getStringScoreEqualsAndLessFour() {

        String score = "Deuce";

        if (player1Points < 3) {

            score = scoreStringArrayEquals[this.player1Points];

        }

        return score;
    }

    //endregion

    //region Greater or Less than three

    private String getScoreLessOrGreaterFour(){

        String score = getTypeWinner();;
        if(isLessThan(4)) {

            score = scoreStringArray[player1Points] + "-" + scoreStringArray[player2Points];

        }

        return score;
    }

    private int getDifferenceScore() {

        return Math.abs(this.player1Points - this.player2Points);

    }

    private String getTypeWinner() {

        String typeWinner = "Win for";

        if (getDifferenceScore() == 1) {

            typeWinner = "Advantage";
        }

        return typeWinner + " " +getHighScorePlayerName();
    }

    //endregion

    //endregion

    private void Player1IncrementScore() {
        player1Points++;
    }

    private void Player2IncrementScore() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (Objects.equals(player, this.player1Name))
            Player1IncrementScore();
        else
            Player2IncrementScore();
    }
}