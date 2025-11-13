public class Main {



    public static String menu(String prompt, String[] options, java.util.Scanner scanner) {
        while (true) {
            System.out.println( "0. Salir del programa");
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d %s\n", i + 1, options[i]);
            }
            System.out.println(prompt);
            final var opcion = scanner.nextInt();
            if( opcion == 0 ){
                System.exit(0);
            }
            if (opcion >= 1 && opcion <= options.length) {
                return options[opcion-1];
            }
        }
    }

    public static void main(String[] args) throws ReflectiveOperationException{
        final String[] games = {"Blackjack", "PlayCatch", "Comet", "PlayCraps", "PlayFallDown", "PlayFrogger", "MathHero", "PlayPong", "PlayTetris"};
        final var scanner = new java.util.Scanner(System.in);
        var juego = menu("Elije un juego, o 0 para salir", games, scanner );
        Class.forName(juego).getMethod("main", String[].class ).invoke( null, (Object)new String[0] );
    }
}