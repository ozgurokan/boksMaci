public class Match {
    Fighter f1;
    Fighter f2;
    int maxWeight;
    int minWeight;

    Match(Fighter f1, Fighter f2, int maxWeight, int minWeight) {
        // maça kimin başlayacağı kurucu methoh çağırıldığında belirlenir
        if (isFirst()) {
            this.f1 = f1;
            this.f2 = f2;
        } else {
            this.f1 = f2;
            this.f2 = f1;
        }

        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    public void run() {
        System.out.println("Maça " + this.f1.name + " Başlıyor");

        // siklet konrolü yapılır siklet kontrolu true ise maça başlanır.
        if (isCheck()) {
            // iki rakibipten birinin canı sıfırdan fazla olduğu sürece maç devam eder.
            while (this.f1.health > 0 && this.f2.health > 0) {

                System.out.println("\n======YENİ ROUND=========");
                this.f2.health = this.f1.hit(this.f2);
                System.out.println(this.f2.name + " Can : " + this.f2.health);
                if (isWin()) {
                    break;
                }
                // program rekiplerin hamleleri arasında 0.5 saniye bekletilir
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\n----Sıra Rakipte----\n");


                this.f1.health = this.f2.hit(this.f1);
                System.out.println(this.f1.name + " Can : " + this.f2.health);
                if (isWin()) {
                    break;
                }

                // rauntlar arasında prgoram 0.5 saniye bekletirilir
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        } else {
            System.out.println("Sporcuların Sikletleri Uygun değil.");
        }
    }

    public boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    public boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " Maçı Kazandı");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " Maçı Kazandı");
            return true;
        }
        return false;


    }

    boolean isFirst() {

        double randomChance = Math.random() * 100;
        if (randomChance <= 50) {
            return true;
        }
        return false;

    }
}
