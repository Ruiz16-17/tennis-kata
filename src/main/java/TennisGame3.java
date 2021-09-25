import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private int player2Score;
    private int player1Score;
    private String player1Name;
    private String player2Name;

    String[] scoreStringArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        String score = "Deuce";

        if (!isEqualsScores()) {
            score = getTypeWinner();
        }

        if (isLessThanFour() && !isSix()) {

            score = this.scoreStringArray[player1Score];
            return getStringScoreLessFour(score);
        }

        return score;

    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.player1Name))
            this.player1Score += 1;
        else
            this.player2Score += 1;

    }

    //region General Comparisons

    private boolean isEqualsScores() {

        return this.player1Score == this.player2Score;
    }

    private boolean isLessThanFour() {

        return this.player1Score < 4 && this.player2Score < 4;
    }

    private String getHighScorePlayerName() {

        String highScoreName = this.player1Name;

        if (this.player1Score < this.player2Score) {

            highScoreName = this.player2Name;
        }

        return highScoreName;
    }

    private boolean isSix() {

        return (this.player1Score + this.player2Score == 6);
    }

    //endregion

    //region Cases

    private String getTypeWinner() {

        String typeWinner = "Win for";

        if (Math.abs((this.player1Score - this.player2Score)) == 1) {

            typeWinner = "Advantage";
        }

        return typeWinner + " " + getHighScorePlayerName();
    }

    private String getStringScoreLessFour(String score) {
        return isEqualsScores() ? score + "-All" : score + "-" + this.scoreStringArray[this.player2Score];
    }

    //endregion

}
