package Datawhale.Q0228;

import java.util.Stack;

public class Valid_Parentheses {
    public boolean isValid(String s) {
        char a, b;
        Stack<Character> st = new Stack<Character>();        //*****

        for (int i = 0; i < s.length(); i++) {
            a = s.charAt(i);
            if (a == '(' || a == '{' || a == '[')
                st.push(a);
            else if (a == ')' || a == '}' || a == ']') {
                if (st.size() == 0) return false;    //在pop前判空，否则RE
                b = st.pop();            //pop没有参数
                if (b == '(' && a == ')') continue;
                if (b == '{' && a == '}') continue;
                if (b == '[' && a == ']') continue;
                return false;
            }
        }
        if (st.size() == 0) return true;  //**********
        else return false;
    }
}
