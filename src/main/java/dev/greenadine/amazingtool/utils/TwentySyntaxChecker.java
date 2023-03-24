package dev.greenadine.amazingtool.utils;

import dev.greenadine.amazingtool.exception.TwentyInvalidSyntaxException;

import java.util.ArrayList;
import java.util.regex.Pattern;

public final class TwentySyntaxChecker {

    private static final Pattern gebruikPattern = Pattern.compile("gebruik (kompas|zwOog|kleurOog|[a-z]+)");
    private static final Pattern toewijzenVariabelePattern = Pattern.compile("([a-z]) = (\\d+|[a-z] [+-] \\d+)");

    private static final Pattern alsPattern = Pattern.compile("als ([a-z\\d]+|zwOog|kleurOog|kompas) (==|!=|<|>) ([a-z\\d]+) \\{");
    private static final Pattern zolangPattern = Pattern.compile("^zolang ([a-z\\d]+) (==|!=|<|>) ([a-z\\d]+) \\{");

    private static final Pattern stapPattern = Pattern.compile("^stap(Vooruit|Achteruit)$");
    private static final Pattern draaiPattern = Pattern.compile("^draai(Links|Rechts)$");

    /**
     * Checks whether the given input contains Twenty code with valid syntax.
     *
     * @param input the input code.
     */
    public static void checkSyntax(final String input) {
        if (input.isEmpty()) {
            return;
        }

        final ArrayList<Character> variables = new ArrayList<>();

        String[] lines = input.split("\n");

        int lastOpeningBracketLineIndex = 0;
        int openingBrackets = 0;
        int closingBrackets = 0;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) {
                continue;
            }

            int lineIndex = i + 1;

            if (line.startsWith("gebruik")) {
                if (!gebruikPattern.matcher(line).matches()) {
                    System.out.println(1);
                    throw new TwentyInvalidSyntaxException(lineIndex, "Invalid 'gebruik' syntax.");
                }

                final String[] arr = line.split("\\s+");

                if (arr[1].matches("[a-z]+") &&
                        !(arr[1].matches("kompas") || arr[1].matches("zwOog") || arr[1].matches("kleurOog"))) {
                    if (arr[1].length() > 1) {
                        throw new TwentyInvalidSyntaxException(lineIndex, "Variable has to be a single letter between 'a' and 'z'.");
                    }

                    char variable = arr[1].charAt(0);
                    System.out.println("Registered variable " + variable);
                    variables.add(variable);
                    continue;
                }

                if (!(arr[1].equals("kompas") || arr[1].equals("zwOog") || arr[1].equals("kleurOog"))) {
                    throw new TwentyInvalidSyntaxException(lineIndex, "Invalid 'gebruik' syntax.");
                }
                continue;
            }

            else if (line.startsWith("als")) {
                if (!alsPattern.matcher(line).matches()) {
                    throw new TwentyInvalidSyntaxException(lineIndex, "Invalid 'als' syntax.");
                }

                final String[] arr = line.split("\\s+");

                if (arr[1].matches("[a-z]+") &&
                        !(arr[1].matches("kompas") || arr[1].matches("zwOog") || arr[1].matches("kleurOog"))) {
                    if (arr[1].length() > 1) {
                        throw new TwentyInvalidSyntaxException(lineIndex, "Variable has to be a single letter between 'a' and 'z'.");
                    }

                    char variable = arr[1].charAt(0);
                    if (!variables.contains(variable)) {
                        throw new TwentyInvalidSyntaxException(lineIndex, "Unknown variable '%c'.", variable);
                    }
                    continue;
                }

                openingBrackets++;
                lastOpeningBracketLineIndex = lineIndex;
                continue;
            }

            else if (line.startsWith("zolang")) {
                if (!zolangPattern.matcher(line).matches()) {
                    throw new TwentyInvalidSyntaxException(lineIndex, "Invalid 'zolang' syntax.");
                }

                final String[] arr = line.split("\\s+");

                if (arr[1].matches("[a-z]+") &&
                        !(arr[1].matches("kompas") || arr[1].matches("zwOog") || arr[1].matches("kleurOog"))) {
                    if (arr[1].length() > 1) {
                        throw new TwentyInvalidSyntaxException(lineIndex, "Variable has to be a single letter between 'a' and 'z'.");
                    }

                    char variable = arr[1].charAt(0);
                    if (!variables.contains(variable)) {
                        throw new TwentyInvalidSyntaxException(lineIndex, "Unknown variable '%c'.", variable);
                    }
                }

                openingBrackets++;
                lastOpeningBracketLineIndex = lineIndex;
                continue;
            }

            if (line.startsWith("stap")) {
                if (!stapPattern.matcher(line).matches()) {
                    throw new TwentyInvalidSyntaxException(lineIndex, "Invalid 'stap' syntax.");
                }
                continue;
            }

            else if (line.startsWith("draai")) {
                if (!draaiPattern.matcher(line).matches()) {
                    throw new TwentyInvalidSyntaxException(lineIndex, "Invalid 'draai' syntax.");
                }
                continue;
            }

            else if (line.contains("}")) {
                if (!line.equals("}")) {
                    throw new TwentyInvalidSyntaxException(lineIndex, "Closing bracket needs to be on its own line.");
                }
                closingBrackets++;
                continue;
            }

            if (toewijzenVariabelePattern.matcher(line).matches()) {
                char firstChar = line.charAt(0);

                if (!variables.contains(firstChar)) {
                    throw new TwentyInvalidSyntaxException(lineIndex, "Unknown variable '%c'.", firstChar);
                }
            }

            else {
                throw new TwentyInvalidSyntaxException(lineIndex, "Unknown action/command '%s'.", line);
            }
        }

        if (openingBrackets != closingBrackets) {
            System.out.println("Open: " + openingBrackets);
            System.out.println("Close: " + closingBrackets);
            throw new TwentyInvalidSyntaxException(String.format("Missing opening/closing bracket near line #%d.", lastOpeningBracketLineIndex));
        }
    }
}
