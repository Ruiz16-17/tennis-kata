
public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {

        if (playerName == this.player1Name) {
            player1Score += 1;
        }
        if (playerName == this.player2Name) {
            player2Score += 1;
        }

    }

    public String getScore() {

        String score = "";

        if(isEqualsScores()){
            score = getEqualsLessThreeScoreString(this.player1Score);
        }

        if(isGreaterFourAndDifferrentsScoresCase()){
            score = getScoreGreaterThreeString();
        }
        if (isLessFourAndDifferentsCase()){

            score = getScoreLessFourString(player1Score) + "-" + getScoreLessFourString(player2Score);
        }

        return score;
    }

    private boolean isEqualsScores(){

        return this.player1Score == this.player2Score;
    }

    private boolean isGreaterFourScores(int score){

        return score >= 4;
    }

    private boolean isGreaterFourAndDifferrentsScoresCase(){

        return !isEqualsScores() && (isGreaterFourScores(player1Score) || isGreaterFourScores(player2Score));

    }

    private boolean isLessFourAndDifferentsCase(){

        return !isEqualsScores() && (!isGreaterFourScores(player1Score) && !isGreaterFourScores(player2Score));

    }

    private String getEqualsLessThreeScoreString(int tempScore) {

        String scoreString = "Deuce";

        if (tempScore < 3) {

            String[] scoreStringArray = new String[]{"Love-All", "Fifteen-All", "Thirty-All"};
            scoreString = scoreStringArray[tempScore];
        }

        return scoreString;
    }

    private String getScoreLessFourString(int tempScore) {

        String[] scoreString = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

        return scoreString[tempScore];
    }

    private String getScoreGreaterThreeString() {


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

}
