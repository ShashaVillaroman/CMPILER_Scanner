package code;

public class Token {
    public String lexeme;
    public static MIPS64StateAcceptor stateAcceptor = new MIPS64StateAcceptor();

    enum TokenType {
        KEYWORD,
        GPR,
        FPR,
        ERROR
    }

    public TokenType tokenType;

    public Token(String word) {
        stateAcceptor = new MIPS64StateAcceptor();
        this.tokenType = identifyToken(word);
        this.lexeme = word;
    }

    public static TokenType identifyToken(String word) {
        int state = stateAcceptor.getState(word);
        switch (state) {
            case 2:
            case 4:
            case 5: return TokenType.GPR;
            case 7:
            case 8:
            case 9: return TokenType.FPR;
            case 18:
            case 19: return TokenType.KEYWORD;
            default: return TokenType.ERROR;
        }
    }
}