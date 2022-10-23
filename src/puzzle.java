import java.util.*;

public class puzzle {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String ulang="";

        do {
            int totalSkor = 0, level;
            ArrayList<ArrayList<Character>> huruf = new ArrayList<>();

            huruf.add(new ArrayList<>(Arrays.asList('d', 'e', 't', 't', 'l', 'i')));
            huruf.add(new ArrayList<>(Arrays.asList('s', 'e', 'c', 'a', 'e', 'n')));
            huruf.add(new ArrayList<>(Arrays.asList('h', 'k', 'r', 'n', 'e', 'o')));

            ArrayList<ArrayList<String>> kata = new ArrayList<>();

            kata.add(new ArrayList<String>(Arrays.asList("die", "led", "lei", "let", "lid","lie", "lit","tie", "deli", "diet", "edit", "idle", "lied", "tide", "tied", "tilt", "tilde", "tiled", "title", "tilted", "titled")));

            kata.add(new ArrayList<String>(Arrays.asList("sec", "can", "cane", "scan", "scene","case", "cease", "seen", "ace", "nee", "sea" )));

            kata.add(new ArrayList<String>(Arrays.asList("honk", "honker", "roe", "ore", "her","hen", "one","hero", "hone", "kern", "hern", "neo", "hon", "nor", "hoe", "ken", "oner")));

            System.out.println(kata.get(0));
            System.out.println("Coepoe Word Puzzle");
            System.out.println("===============================");
            System.out.println("\nRules :");
            System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters.");
            System.out.println("2. Each level, You have 10 chances to answer correctly.");
            System.out.println("3. Every correct answer, you will be given score 10 points.");
            System.out.println("4. To get through to next level, you have to score 70 points each level.");
            System.out.println("5. You can't input the same word.");

            level = 1;

            for (int i = 0; i < huruf.size(); i++) {
                int skor = 0;
                ArrayList<String> jawabBenar = new ArrayList<>();
                System.out.print("\n");
                System.out.println("Level " + (i + 1));
                System.out.println("-------");
                huruf.get(i).forEach(character -> {
                    System.out.print(character + "    ");
                });

                System.out.println("\n");

                for (int j = 1; j <= 10; j++) {
                    String jawab="";
                    System.out.print(j + "> Your Answer : ");
                    jawab = input.nextLine();

                    Boolean benar = true;
                    if (!jawabBenar.contains(jawab)) {

                        if(!kata.get(i).contains(jawab)){
                            benar = false;
                        }
                        if (benar) {
                            skor += 10;
                            jawabBenar.add(jawab);
                            System.out.println("#Right. Score : " + skor);
                        }
                    } else {
                        System.out.println("You had already type this word before..");
                        j--;
                    }
                }
                totalSkor += skor;
                System.out.println("You had answered 10 times with " + jawabBenar.size() + " right answers..");
                if (skor < 70) {
                    level = 0;
                    break;
                }else {
                	System.out.println("Correct Answers :");
                	System.out.println(kata.get(i));
                }
            }
            if (level == 0) {
                System.out.println("You Lose!! Try Again...");
                do {
                    System.out.println("Do you want to retry?[y/t]");
                    ulang = input.nextLine();
                } while ((!ulang.equals("y") && !ulang.equals("Y")) && (!ulang.equals("t") && !ulang.equals("T")));

            } else {
                System.out.println("Overall score : " + totalSkor);
                System.out.println("You WIN!!");
                System.out.println("Press ENTER to exit");
            }
        }while((ulang.equals("y") || ulang.equals("Y")) );

    }
}
