package com.rest.template;

/**
 * @auther gz
 * @date 2022-04-28  10:39
 * @description
 */

public class TestRestTemplate {
    public static void main(String[] args) {
        String s = sanitizeSource("{name}");
        System.out.println(s);
/*        String variableName = getVariableName("name:34");
        System.out.println(variableName);*/
    }

    private static String sanitizeSource(String source) {
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : source.toCharArray()) {
            if (c == '{') {
                level++;
            }
            if (c == '}') {
                level--;
            }
            if (level > 1 || (level == 1 && c == '}')) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private static String getVariableName(String match) {
        int colonIdx = match.indexOf(':');
        return (colonIdx != -1 ? match.substring(0, colonIdx) : match);
    }

}
