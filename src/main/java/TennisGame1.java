
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

            player2Score += 1;

    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (player1Score == player2Score) {
            score = getEqualsLessThreeScoreString(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {

            score = getScoreGreaterThreeString(player1Score,player2Score);

        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    score += "-";
                    tempScore = player2Score;
                }
                score += getScoreLessFourString(tempScore);
            }
        }
        return score;
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

    private String getScoreGreaterThreeString(int playerScore1, int playerScore2) {


        return getTypeWinner(getDifferenceScore(playerScore1,playerScore2))
                + " " +
                getNameWinner(playerScore1,playerScore2);
    }

    private int getDifferenceScore(int playerScore1, int playerScore2){

        return Math.abs(playerScore1 - playerScore2);

    }

    private String getTypeWinner(int differenceScore) {

        String typeWinner = "Win for";

        if(differenceScore == 1){

            typeWinner = "Advantage";
        }

        return typeWinner;
    }

    private String getNameWinner(int playerScore1, int playerScore2) {

        String nameWinner = this.player1Name;

        if(playerScore1 < playerScore2){

            nameWinner = this.player2Name;
        }

        return nameWinner;
    }


}
