public class DelbareTall {
    public static void main(String[] args) {
        // ALT.1: Delelighet samlet i tre linjer (tre for loops, en per tall):
        System.out.print("Delelig p� 2: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i+" ");
            }
        }

        System.out.print("\nDelelig p� 3: ");

        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                System.out.print(i+" ");
            }
        }

        System.out.print("\nDelelig p� 4: ");

        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                System.out.print(i+" ");
            }
        }

        System.out.print("\n\n");

        // ALT.2: Alle tall p� hver sin linje (en for loop):
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Tallet " +i +" er delelig p� 2.");
            }

            if (i % 3 == 0) {
                System.out.println("Tallet " +i +" er delelig p� 3.");
            }

            if (i % 4 == 0) {
                System.out.println("Tallet " +i +" er delelig p� 4.");
            }
        }
    }
}
