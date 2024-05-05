import java.util.Scanner;

class Beleg1N_ebause{

    public Beleg1N_ebause(){

        formatText();

    }

    public static String getUserInputText(){

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Bitte geben Sie den Text ein, welcher in Blöcke der Länge n zerlegt werden soll: ");
        String userTextInput = sc.nextLine();
        return userTextInput;
    }

    public static int getUserInputNum(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Bitte geben Sie die Länge n an, in die der Text zerlegt werden soll: ");
        System.out.println("");
        int splitNumber = sc.nextInt();
        if(splitNumber <= 0){
            System.out.println("Sie dürfen keine 0 angeben.");
            getUserInputNum();
        }
        return splitNumber;
    }

    public static void showRemovedSpaces(String userInput) {

        int removedSpaces = checkSpaces(userInput);
        System.out.println("Die entfernten Leerzeichen Ihrer Zeichenkette beträgt " + removedSpaces + ".");
        System.out.println("");
        
    }

    public static void formatText(){
        
        String userInput = getUserInputText();
        showRemovedSpaces(userInput);
        String shortedText = removeSpaces(userInput).toLowerCase();
        splitText(shortedText, getUserInputNum());

   }      

    public static int checkSpaces(String userTextInput){
        
        int spaceCounter = 0;
        
        for (int i = 0; i < userTextInput.length(); i++) {
            if (userTextInput.charAt(i) == ' ') {
                spaceCounter++;
            }
        }
        
        return spaceCounter;
    }

    public static String removeSpaces(String userTextInput){
        String shortedText = userTextInput.replaceAll("\\s", "");
        return shortedText;
    }

    public static void splitText(String shortedText, int splitNumber){

        int currentIndex = 0;
        int endIndex = splitNumber;

        while(currentIndex < shortedText.length()){
            endIndex = Math.min(endIndex,shortedText.length());
            System.out.print(shortedText.substring(currentIndex, endIndex));
            System.out.print(" ");
            currentIndex = currentIndex + splitNumber;
            endIndex = endIndex + splitNumber;
        }
    }
}
