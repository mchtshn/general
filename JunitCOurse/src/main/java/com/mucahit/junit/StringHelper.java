package com.mucahit.junit;

public class StringHelper {

    //AACD -> CD  ACD -> CD CDAA -> CDAA
    public String truncateAInFirst2Positions(String str) {
        if (str.length() <= 2) {
            return str.replaceAll("A", "");
        }

        String firstTwoCharacters = str.substring(0, 2);
        String remainingCharacters = str.substring(2);

        return firstTwoCharacters.replaceAll("A", "") + remainingCharacters;
    }

    //AACD -> false  ABAB -> true AB -> true A -> false
    public boolean areFirstandLastTwoCharactersTheSame(String str) {
        if (str.length() <= 1)
            return false;
        if (str.length() == 2)
            return true;

        String firstTwoCharacters = str.substring(0, 2);
        String lastTwoCharacters = str.substring(str.length() - 2);

        return firstTwoCharacters.equals(lastTwoCharacters);
    }
}
