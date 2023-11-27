package utils;

public class StringHandling {
	
	// Function to create a spaced string
    public static String createSpacedString(String input, int distance) {
        StringBuilder spacedStringBuilder = new StringBuilder();

        // Loop through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            // Append the character
            spacedStringBuilder.append(input.charAt(i));

            // Add spaces unless it's the last character
            if (i < input.length() - 1) {
                for (int j = 0; j < distance; j++) {
                    spacedStringBuilder.append(' ');
                }
            }
        }

        return spacedStringBuilder.toString();
    }
}
