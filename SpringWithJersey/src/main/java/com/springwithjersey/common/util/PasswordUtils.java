package com.springwithjersey.common.util;

public class PasswordUtils {

  private static java.util.Random random = new java.util.Random();

  protected static final int MAX_LENGTH = 9;

  private static final String DIGIT_CHARACTERS = "123456789";
  private static final String LOWERCASE_CHARACTERS = "abcdefghjkmnpqrstuvwxyz";
  private static final String UPPERCASE_CHARACTERS = "ABCDEFGHJKMNPQRSTUVWXYZ";
  private static final String SPECIAL_CHARACTERS = "@#$%=:?";
  private static final String ALL_CHARACTERS =
      DIGIT_CHARACTERS + LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS + SPECIAL_CHARACTERS;
  private static final char[] upperCases = UPPERCASE_CHARACTERS.toCharArray();
  private static final char[] lowerCases = LOWERCASE_CHARACTERS.toCharArray();
  private static final char[] digits = DIGIT_CHARACTERS.toCharArray();
  private static final char[] specialCharacters = SPECIAL_CHARACTERS.toCharArray();
  private static final char[] all = ALL_CHARACTERS.toCharArray();

  public static String generatePassword() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(lowerCases[random.nextInt(lowerCases.length)]);
    stringBuilder.append(upperCases[random.nextInt(upperCases.length)]);
    stringBuilder.append(digits[random.nextInt(digits.length)]);
    stringBuilder.append(specialCharacters[random.nextInt(specialCharacters.length)]);
    appendRemainingCharacters(stringBuilder);

    return stringBuilder.toString();
  }

  private static StringBuilder appendRemainingCharacters(StringBuilder stringBuilder) {
    for (int i = 0; i < MAX_LENGTH - 4; i++) {
      stringBuilder.append(all[random.nextInt(all.length)]);
    }
    return stringBuilder;

  }
}
