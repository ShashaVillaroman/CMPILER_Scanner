package code;

public class MIPS64StateAcceptor {

    private int dfa;

    void start (char c) {
        switch (c) {
            case 'R': dfa = 1; break;
            case '$': dfa = 3; break;
            case 'F': dfa = 6; break;
            case 'D': dfa = 10; break;
            default: dfa = -1; break;
        }
    }

    void q1 (char c) {
        if (c >= '0' && c <= '9') {
            switch (c) {
                case '1':
                case '2': dfa = 2; break;
                case '3': dfa = 4; break;
                default: dfa = 5; break;
            }
        } else {
            dfa = -1;
        }
    }

    void q2 (char c) {
        if (c >= '0' && c <= '9') dfa = 5;
        else dfa = -1;
    }

    void q3 (char c) {
        if (c >= '0' && c <= '9') {
            switch (c) {
                case '1':
                case '2': dfa = 2; break;
                case '3': dfa = 4; break;
                default: dfa = 5; break;
            }
        } else if (c == 'F') {
            dfa = 6;
        } else {
            dfa = -1;
        }
    }

    void q4 (char c) {
        if (c == '0' || c == '1') dfa = 5;
        else dfa = -1;
    }

    void q5 (char c) {
        dfa = -1;
    }

    void q6 (char c) {
        if (c >= '0' && c <= '9') {
            switch (c) {
                case '1':
                case '2': dfa = 7; break;
                case '3': dfa = 8; break;
                default: dfa = 9; break;
            }
        } else {
            dfa = -1;
        }
    }

    void q7 (char c) {
        if (c >= '0' && c <= '9') dfa = 9;
        else dfa = -1;
    }

    void q8 (char c) {
        if (c == '0' || c == '1') dfa = 9;
        else dfa = -1;
    }

    void q9 (char c) {
        dfa = -1;
    }

    void q10 (char c) {
        switch (c) {
            case 'A': dfa = 11; break;
            case 'M': dfa = 15; break;
            default: dfa = -1; break;
        }
    }

    void q11 (char c) {
        if (c == 'D') dfa = 12;
        else dfa = -1;
    }

    void q12 (char c) {
        if (c == 'D') dfa = 13;
        else dfa = -1;
    }

    void q13 (char c) {
        switch (c) {
            case 'I': dfa = 14; break;
            case 'U': dfa = 19; break;
            default: dfa = -1; break;
        }
    }

    void q14 (char c) {
        if (c == 'U') dfa = 19;
        else dfa = -1;
    }

    void q15 (char c) {
        if (c == 'U') dfa = 16;
        else dfa = -1;
    }

    void q16 (char c) {
        if (c == 'L') dfa = 17;
        else dfa = -1;
    }

    void q17 (char c) {
        if (c == 'T') dfa = 18;
        else dfa = -1;
    }

    void q18 (char c) {
        if (c == 'U') dfa = 19;
        else dfa = -1;
    }

    void q19 (char c) {
        dfa = -1;
    }

    int getState(String s) {
        char c;
        dfa = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (dfa) {
                case 0: start(c); break;
                case 1: q1(c); break;
                case 2: q2(c); break;
                case 3: q3(c); break;
                case 4: q4(c); break;
                case 5: q5(c); break;
                case 6: q6(c); break;
                case 7: q7(c); break;
                case 8: q8(c); break;
                case 9: q9(c); break;
                case 10: q10(c); break;
                case 11: q11(c); break;
                case 12: q12(c); break;
                case 13: q13(c); break;
                case 14: q14(c); break;
                case 15: q15(c); break;
                case 16: q16(c); break;
                case 17: q17(c); break;
                case 18: q18(c); break;
                case 19: q19(c); break;
                default: return 0;
            }
        }
        return dfa;
    }
}