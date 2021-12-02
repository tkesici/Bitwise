/*
 * @author Tevfik Kesici
 * @since 24.11.2021
 */

import java.util.*;

public class Main {
    /**
     * Main method
     */
    public static int input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstInt, secondInt;
        String firstString, secondString;
        double firstDouble, secondDouble;
        System.out.println("Give the type of input? " +
                "int=0, string=1, double=2");
        int input1 = sc.nextInt();
        input = input1;
        if (input1 == 0) {
            System.out.println("Give the type of input? or=0, and=1, " +
                    "xor=2, complement=3, right shift=4, left shift=5");
        } else {
            System.out.println("Give the type of input? or=0, and=1, " +
                    "xor=2");
        }
        int input2 = sc.nextInt();
        if (input1 == 0) {
            if (input2 == 0) {
                System.out.println("First Integer Number : ");
                firstInt = sc.nextInt();
                System.out.println("Second Integer Number : ");
                secondInt = sc.nextInt();
                System.out.println
                        (or(String.valueOf(firstInt),
                                String.valueOf(secondInt)));
            }
            if (input2 == 1) {
                System.out.println("First Integer Number : ");
                firstInt = sc.nextInt();
                System.out.println("Second Integer Number : ");
                secondInt = sc.nextInt();
                System.out.println
                        (and(String.valueOf(firstInt),
                                String.valueOf(secondInt)));

            }
            if (input2 == 2) {
                System.out.println("First Integer Number : ");
                firstInt = sc.nextInt();
                System.out.println("Second Integer Number : ");
                secondInt = sc.nextInt();
                System.out.println
                        (xor(String.valueOf(firstInt),
                                String.valueOf(secondInt)));

            }
            if (input2 == 3) {
                System.out.println("Integer Number : ");
                firstInt = sc.nextInt();
                System.out.println(complement(String.valueOf(firstInt)));
            }
            if (input2 == 4) {
                System.out.println("Integer Number : ");
                firstInt = sc.nextInt();
                System.out.println("Shift Number : ");
                secondInt = sc.nextInt();
                System.out.println(rs(String.valueOf(firstInt), secondInt));
            }
            if (input2 == 5) {
                System.out.println("Integer Number : ");
                firstInt = sc.nextInt();
                System.out.println("Shift Number : ");
                secondInt = sc.nextInt();
                System.out.println(ls(String.valueOf(firstInt), secondInt));
            }
        }
        if (input1 == 1) {
            if (input2 == 0) {
                System.out.println("First String : ");
                firstString = sc.next();
                sc.nextLine();
                System.out.println("Second String : ");
                secondString = sc.nextLine();
                System.out.println(or(firstString, secondString));
            }
            if (input2 == 1) {
                System.out.println("First String : ");
                firstString = sc.next();
                sc.nextLine();
                System.out.println("Second String : ");
                secondString = sc.nextLine();
                System.out.println(and(firstString, secondString));
            }
            if (input2 == 2) {
                System.out.println("First String : ");
                firstString = sc.next();
                sc.nextLine();
                System.out.println("Second String : ");
                secondString = sc.nextLine();
                System.out.println(xor(firstString, secondString));
            }
        }
        if (input1 == 2) {
            if (input2 == 0) {
                System.out.println("First Double Number : ");
                firstDouble = sc.nextDouble();
                System.out.println("Second Double Number : ");
                secondDouble = sc.nextDouble();
                System.out.println(or(String.valueOf(firstDouble),
                        String.valueOf(secondDouble)));
            }
            if (input2 == 1) {
                System.out.println("First Double Number : ");
                firstDouble = sc.nextDouble();
                System.out.println("Second Double Number : ");
                secondDouble = sc.nextDouble();
                System.out.println(and(String.valueOf(firstDouble),
                        String.valueOf(secondDouble)));
            }
            if (input2 == 2) {
                System.out.println("First Double Number : ");
                firstDouble = sc.nextDouble();
                System.out.println("Second Double Number : ");
                secondDouble = sc.nextDouble();
                System.out.println(xor(String.valueOf(firstDouble),
                        String.valueOf(secondDouble)));
            }
        }
    }

    /**
     * A method that performs the | operation between first and second
     *
     * @param first  - First String parameter (bits)
     * @param second - Second String parameter (bits)
     * @return returns (first|second) operation (bits)
     */

    public static String or(String first, String second) {
        switch (input) {
            case 0:
                return split(integerToBinaryDigits
                        (Integer.parseInt(first)), 8) +
                        "|\n" + split(integerToBinaryDigits
                        (Integer.parseInt(second)), 8)
                        + "\n------------------------------------\n" +
                        split(integerToBinaryDigits((Integer.parseInt(first)
                                | Integer.parseInt(second))), 8)
                        + "= " + (Integer.parseInt(first)
                        | Integer.parseInt(second));
            case 1: {
                first = stringToBinaryDigits(first);
                second = stringToBinaryDigits(second);
                String result = "";
                String strRes;
                int j = first.length() - second.length();
                if (j < 0) {
                    for (int i = 0; i < Math.abs(j); i++) {
                        first = "0" + first;
                    }
                } else {
                    for (int i = 0; i < Math.abs(j); i++) {
                        second = "0" + second;
                    }
                }
                for (int i = 0; i < first.length(); i++) {
                    if (first.charAt(i) == '1' || second.charAt(i) == '1') {
                        result += "1";
                    } else
                        result += "0";

                }
                strRes = binaryToString(result);
                return split(first, 8) + "|\n"
                        + split(first, 8) + "\n" +
                        "------------------------------------\n" +
                        split(first, 8) +
                        "= " + strRes;
            }
            default: {
                return split(first, 8) + "|\n" +
                        split(first, 8) + "\n" +
                        "------------------------------------\n" +
                        split(first, 8);
            }
        }
    }

    /**
     * A method that performs the & operation between first and second
     *
     * @param first  - First String parameter (bits)
     * @param second - Second String parameter (bits)
     * @return returns (first&second) operation (bits)
     */

    public static String and(String first, String second) {
        switch (input) {
            case 0:
                return split(integerToBinaryDigits
                        (Integer.parseInt(first)), 8) +
                        "&\n" + split(integerToBinaryDigits
                        (Integer.parseInt(second)), 8)
                        + "\n------------------------------------\n" +
                        split(integerToBinaryDigits((Integer.parseInt(first)
                                & Integer.parseInt(second))), 8)
                        + "= " + (Integer.parseInt(first)
                        & Integer.parseInt(second));
            case 1: {
                first = stringToBinaryDigits(first);
                second = stringToBinaryDigits(second);
                String result = "";
                String str;
                int j = first.length() - second.length();
                if (j < 0) {
                    for (int i = 0; i < Math.abs(j); i++) {
                        first = "0" + first;
                    }
                } else {
                    for (int i = 0; i < Math.abs(j); i++) {
                        second = "0" + second;
                    }
                }
                for (int i = 0; i < first.length(); i++) {
                    if (first.charAt(i) == '1' && second.charAt(i) == '1') {
                        result += "1";
                    } else
                        result += "0";

                }
                str = binaryToString(result);
                return split(first, 8) + "&\n" +
                        split(first, 8) + "\n" +
                        "------------------------------------\n" +
                        split(first, 8) + "= " + str;

            }
            default: {
                return split(first, 8) + "&\n" +
                        split(first, 8) + "\n" +
                        "------------------------------------\n" +
                        split(first, 8);
            }
        }
    }

    /**
     * A method that performs the ^ operation between first and second
     *
     * @param first  - First String parameter (bits)
     * @param second - Second String parameter (bits)
     * @return returns (first^second) operation (bits)
     */

    public static String xor(String first, String second) {
        switch (input) {
            case 0:
                return split(integerToBinaryDigits
                        (Integer.parseInt(first)), 8) +
                        "^\n" + split(integerToBinaryDigits
                        (Integer.parseInt(second)), 8)
                        + "\n------------------------------------\n" +
                        split(integerToBinaryDigits((Integer.parseInt(first)
                                ^ Integer.parseInt(second))), 8)
                        + " = " + (Integer.parseInt(first)
                        ^ Integer.parseInt(second));
            case 1: {
                first = stringToBinaryDigits(first);
                second = stringToBinaryDigits(second);
                String result = "";
                String strRes;
                int j = first.length() - second.length();
                if (j < 0) {
                    for (int i = 0; i < Math.abs(j); i++) {
                        first = "0" + first;
                    }
                } else {
                    for (int i = 0; i < Math.abs(j); i++) {
                        second = "0" + second;
                    }
                }
                for (int i = 0; i < first.length(); i++) {
                    if (first.charAt(i) == '1' &&
                            second.charAt(i) == '1') {
                        result += "0";
                    } else if (first.charAt(i) == '0'
                            && second.charAt(i) == '0')
                        result += "0";
                    else
                        result += "1";
                }
                strRes = binaryToString(result);
                return split(first, 8) + "^\n" +
                        split(first, 8) + "\n" +
                        "------------------------------------\n" +
                        split(first, 8) + " = " + strRes;
            }
            default: {
                return split(first, 8) + "^\n" +
                        split(first, 8) + "\n" +
                        "------------------------------------\n"
                        + split(first, 8);
            }
        }
    }

    /**
     * A method that performs the ~ operation to first
     *
     * @param first - First String parameter (bits)
     * @return (~ first) operation (bits)
     */

    public static String complement(String first) {
        return "~" + split(integerToBinaryDigits
                (Integer.parseInt(first)), 8)
                + "= " + split(integerToBinaryDigits
                (~Integer.parseInt(first)), 8)
                + "= " + ~Integer.parseInt(first);
    }

    /**
     * A method that performs the >> operation between first and second
     *
     * @param first  - First String parameter (bits)
     * @param second - Second int parameter for the number of shift operation
     * @return returns (>>first) right shifted (bits)
     */

    public static String rs(String first, int second) {
        return first + " >> " + second + " = " +
                split(integerToBinaryDigits((Integer.parseInt
                        (first) >> second)), 8)
                + "= " + (Integer.parseInt(first) >> second);
    }

    /**
     * A method that performs the << operation between first and second
     *
     * @param first  - First String parameter (bits)
     * @param second - Second int parameter for the number of shift operation
     * @return returns (<<first) left shifted (bits)
     */

    public static String ls(String first, int second) {
        return first + " << " + second + " = " +
                split(integerToBinaryDigits
                        ((Integer.parseInt(first) << second)), 8)
                + "= " + (Integer.parseInt(first) << second);
    }

    /**
     * A method that splits the String every n character
     *
     * @param text - Variable to split
     * @param size - Integer to split between characters
     * @return Splitted string
     */

    public static String split(String text, int size) {
        String s = "";
        for (int i = 0; i < text.length(); i += size) {
            s += text.substring(i, Math.min(text.length(), i + size)) + " ";
        }
        return s;
    }

    /**
     * A method that converts Integer value to binary digits
     *
     * @param input - Variable to convert
     * @return Binary value of an integer input
     */

    public static String integerToBinaryDigits(int input) {
        String s = "";
        for (int i = 0; i < 32 - Integer.toBinaryString(input).length(); i++) {

            s += 0;
        }
        s += Integer.toBinaryString(input);

        return s;
    }

    /**
     * A method that converts String value to binary digits
     *
     * @param input - Variable to convert
     * @return Binary value of a String input
     */

    public static String stringToBinaryDigits(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            sb.append(
                    String.format("%8s", Integer.toBinaryString(aChar))
                            .replaceAll(" ", "0")
            );
        }
        return sb.toString();
    }

    /**
     * A method that converts binary value to String
     *
     * @param input - Variable to convert
     * @return String value of a binary input
     */

    public static String binaryToString(String input) {
        StringBuilder sb = new StringBuilder();
        for (String s : input.split("(?<=\\G.{8})")) {
            sb.append((char) Integer.parseInt(s, 2));
        }
        String string = sb.toString();
        return string;
    }

}
