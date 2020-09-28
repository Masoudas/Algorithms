package Chapter5.RegularExpressions_5;

/**
 * In normal editors, usually .* is the sign in a search bar that means search using regular expressions.
 * Normally, we want to use the match case, so that exactly what we put in the search bar is searched for.
 * 
 * For starters, we can just look for simple snippets, like abc. The matches are found. What are the matches?
 * In VS Code, these are matches that are not separated by space chars like space (\\s), tab (\\t) or end of line (\\n).
 * Note that order of course matters in the pattern. 
 * 
 * Note also that searching for special characters that are also part of regex special characters requires caution. 
 * We cannot directly search for .[{(|^\*+?&. For these we should use in a non-raw string, or a scape backslash,
 * like \. or \\.
 * 
 * The following are the helpers we use with regex.
 * 
 * . - Any character except new line
 * \d - Any digit from 0-9.
 * \D - Not a digit.
 * \w - Word char (a-z or A-Z or 0-9 or _)
 * \W - Not a char 
 * \s - WhiteSpace (space, tab, newLine).
 * \S - not whitespace (space, tab, newLine).
 * 
 * \b - Word boundary
 * \B - Not a word boundary
 * ^ Beginning of string
 * $ End of string
 * 
 * [] - Matches chars set (For example [ab] means ONE Char matches a or b). There's no need to escape inside character set, because
 * why would you?! The expression knows that these are literals. If dash put at the start or end, it just
 * means dash, otherwise, a-z means range of from a to z.
 * [^] - Not matches char set.
 * | - Either or
 * () Matches Group
 * 
 * Quantifiers:
 * * Zero or more
 * + One or more
 * ? Zero or one
 * {3} Exactly Three
 * {3,5} Three to five
 * {3,} Three or more
 * 
 * 
 * \b: So with "Ha HaHa", if we write \bHa, we're searching for a word boundary, then Ha. So it will find TWO matches. The third
 * one which is second Ha in Haha is not found. \bHa\b only finds the first one. \bHa\B finds only the second one.
 * 
 * Example: [A-Za-z-] ? looks for a char from a to z, both small and capital, or a dash (the end one)!
 * 
 * Example: [^] ? If it were empty, means no char, but now that there's a negate, means every character!
 * 
 * Example: [^a-z]? Every char that is not a-z.
 * 
 * Example: [^b]at? Every pattern that is not bat!
 * 
 * Example: \d{3}.\d{3}.\d{4}? Means, search for a pattern of exactly three digits, followed by a dot, then three digits followed
 * by a dot, then four digits.
 * 
 * Write a pattern that finds all names that start with Mr. Mrs. or Ms.? There could be a space after these words too, like Mr. Adams, Mr.Adams?
 * M(r|s|rs)\s?\. \w+
 * 
 * Write a pattern that will match Masoudas@hotmail.com? Well. Supposing the email address only contains small and capital letters,
 * one has to write [a-zA-Z]+@[a-zA-Z]+\.com
 * 
 * Write one that matches Masoud.As@univ-amu.fr together with previous email? 
 * Why is the previous one not matching? Because of the dot in the first part,
 * and the - in the second part, as well as the fr. So we may expand it as [a-zA-Z.]+@[a-zA-Z.]\.(com|fr).
 * 
 * Write a pattern that matches the previous one together with Masoud-123@univ-amu.net?
 * Well, we can just add a dash and 0-9 to the first part and we're done. [a-zA-Z0-9.-]+@[a-zA-Z.]\.(com|fr|net).
 * Regular expressions for matching email addresses for example can be found over the internet. They're hard to write!
 */
public class RegexInUse {
    
}
