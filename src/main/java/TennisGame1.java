import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {

        if (Objects.equals(playerName, this.player1Name)) {
            player1Score += 1;
        }
        if (Objects.equals(playerName, this.player2Name)) {
            player2Score += 1;
        }

    }

    public String getScore() {

        String score = "";

        if (isEqualsScores()) {
            score = getStringEqualsScore(this.player1Score);
        }

        if (isGreaterFourAndDiffScoreCase()) {
            score = getStringGreaterThreeScore();
        }
        if (isLessFourAndDiffScoreCase()) {

            score = getStringLessFourScore(player1Score) + "-" + getStringLessFourScore(player2Score);
        }

        return score;
    }

    //region General Comparisons

    private boolean isEqualsScores() {

        return this.player1Score == this.player2Score;
    }

    private boolean isGreaterFourScores(int score) {

        return score >= 4;
    }

    //endregion

    //region cases

    //region Equals Case

    private String getStringEqualsScore(int score) {

        String scoreString = "Deuce";

        if (score < 3) {

            String[] scoreStringArray = new String[]{"Love-All", "Fifteen-All", "Thirty-All"};
            scoreString = scoreStringArray[score];
        }

        return scoreString;
    }

    //endregion

    //region Greater than four and differents Scores

    private boolean isGreaterFourAndDiffScoreCase() {

        return !isEqualsScores() && (isGreaterFourScores(player1Score) || isGreaterFourScores(player2Score));

    }

    private String getStringGreaterThreeScore() {


        return getTypeWinner(getDifferenceScore())
                + " " +
                getNameWinner();
    }

    private int getDifferenceScore() {

        return Math.abs(this.player1Score - this.player2Score);

    }

    private String getTypeWinner(int differenceScore) {

        String typeWinner = "Win for";

        if (differenceScore == 1) {

            typeWinner = "Advantage";
        }

        return typeWinner;
    }

    private String getNameWinner() {

        String nameWinner = this.player1Name;

        if (this.player1Score < this.player2Score) {

            nameWinner = this.player2Name;
        }

        return nameWinner;
    }

    //endregion

    //region Less than four and differents Scores

    private boolean isLessFourAndDiffScoreCase() {

        return !isEqualsScores() && (!isGreaterFourScores(player1Score) && !isGreaterFourScores(player2Score));

    }

    private String getStringLessFourScore(int score) {

        String[] scoreString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

        return scoreString[score];
    }

    //endregion

    //endregion

}
