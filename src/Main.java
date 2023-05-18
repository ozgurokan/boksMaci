public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Ali Baba", 10,120,51,23);
        Fighter f2 = new Fighter("Deli Dumrul", 12, 90,93,42);

        Match match  = new Match(f1,f2,100, 50 );
        match.run();
    }
}