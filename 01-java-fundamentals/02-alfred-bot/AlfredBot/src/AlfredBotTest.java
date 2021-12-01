public class AlfredBotTest {

        public static void main(String[] args) {
            AlfredBot alfredBot = new AlfredBot();

            // Make some test greetings, providing any necessary data
            String testGreeting = alfredBot.basicGreeting();
            String testGuestGreeting = alfredBot.guestGreeting("Sacha Rinn", "evening");
            String testDateAnnouncement = alfredBot.dateAnnouncement();

            String alexisTest = alfredBot.respondBeforeAlexis(
                    "Alexis! Play some low-fi beats."
            );
            String alfredTest = alfredBot.respondBeforeAlexis(
                    "I can't find my yo-yo. Maybe Alfred will know where it is.");
            String notRelevantTest = alfredBot.respondBeforeAlexis(
                    "Maybe that's what Batman is about. Not winning. But failing.."
            );

            // Print the greetings to test.
            System.out.println(testGreeting);

            // Uncomment these one at a time as you implement each method.
             System.out.println(testGuestGreeting);
             System.out.println(testDateAnnouncement);
             System.out.println(alexisTest);
             System.out.println(alfredTest);
             System.out.println(notRelevantTest);
        }


}
