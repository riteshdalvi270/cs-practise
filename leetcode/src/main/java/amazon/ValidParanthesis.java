package amazon;

import java.util.Stack;

/**
 * Determine if paranthesis are valid. Ordering matters. Open and closing together. Created by ritesh on 7/8/17.
 */
public class ValidParanthesis
{

    public static void main(String args[])
    {

        final String input = "([]";

        System.out.print(isValid(input));
    }

    public static boolean isValid(String s)
    {

        if (s == null || s.length() == 0)
        {
            return true;
        }

        char in[] = s.toCharArray();
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {

            if (in[i] == '}')
            {

                if (stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    final Character poppedCharacter = stack.pop();

                    if (poppedCharacter != '{')
                    {
                        return false;
                    }
                }
            }
            else if (in[i] == ']')
            {

                if (stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    final Character poppedCharacter = stack.pop();

                    if (poppedCharacter != '[')
                    {
                        return false;
                    }
                }
            }
            else if (in[i] == ')')
            {

                if (stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    final Character poppedCharacter = stack.pop();

                    if (poppedCharacter != '(')
                    {
                        return false;
                    }
                }
            }
            else
            {
                stack.push(in[i]);
            }
        }

        return stack.isEmpty();
    }
}
