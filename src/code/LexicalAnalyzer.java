package code;
import java.util.ArrayList;

public class LexicalAnalyzer {
    private ArrayList<String> delimiterList;
    private ArrayList<Token> tokenList;

    int delimiterType(char c) {
        if (c == 10)
            return 2;
        if (c == ' ' || c == ',')
            return 1;
        return 0;
    }

    ArrayList<Token> process(String sourceCode) {
        delimiterList = new ArrayList<>();
        tokenList = new ArrayList<>();
        int count = 0, curDelim, prevDelim = -1;
        StringBuilder tokenSb = new StringBuilder();
        StringBuilder delimiterSb = new StringBuilder();
        for (int i = 0; i < sourceCode.length(); i++) {
            curDelim = delimiterType(sourceCode.charAt(i));
            if (curDelim == 0) {
                if (prevDelim > 0) {
                    if (delimiterSb.toString().length() == 0) {
                        if (prevDelim == 1) {
                            delimiterSb.append(" ");
                        } else {
                            delimiterSb.append("\n");
                        }
                    }
                    if (count > 0)
                        delimiterList.add(delimiterSb.toString());
                    tokenSb.setLength(0);
                }
                tokenSb.append(sourceCode.charAt(i));
            } else {
                if (prevDelim == 0) {
                    Token t = new Token(tokenSb.toString());
                    tokenList.add(t);
                    count++;
                    delimiterSb.setLength(0);
                }
                if (curDelim == 2)
                    delimiterSb.append("\n");
            }
            prevDelim = curDelim;
        }
        return tokenList;
    }

    public ArrayList<String> getDelimiterList() {
        return delimiterList;
    }

    public ArrayList<Token> getTokenList() {
        return tokenList;
    }
}