
//Помоги главнокомандующему справиться с войсками (поправить компиляцию, упростить, где можно, но трогать функцию main нельзя)
public class GenericAdventure {
    public interface Man {
    }

    public static class Knight implements Man {
    }

    public static class Peasant implements Man {
    }

    public interface Army<T> {
        void move();
    }

    public static class Avantgarde<T> implements Army<T> {
        private T comander;
        public Avantgarde(T comander) {
            this.comander = comander;
        }

        public void move(){}
    }

    public static class Escort<T> implements Army<T> {
        private T comander;
        public Escort(T comander) {
            this.comander = comander;
        }

        public void move(){}
    }


    public static void moveAvangarde(Avantgarde<Man> avantgarde) {
        avantgarde.move();
    }

    public static void moveEscort(Escort<Man> escort) {
        escort.move();
    }

    public static void moveKnights(Avantgarde<Knight> avantgarde) {
        avantgarde.move();
    }

    public static void moveKnights(Escort<Knight> escort) {
        escort.move();
    }

    public static void moveSomething(Avantgarde<Peasant> army) {
        army.move();
    }

    public static void moveSomething(Escort<Knight> army) {
        army.move();
    }


    public static void main(String[] args) {
        final Army<Man> knightsAvanLeft = new Avantgarde<>(new Knight());
        final Army<Knight> knightsAvanRight = new Avantgarde<>(new Knight());
        final Escort<Man> peasantsEscortBack = new Escort<>(new Peasant());
        final Escort<Peasant> peasantEscortLeft = new Escort<>(new Peasant());
        final Army<Peasant> peasantEscortRigth = new Escort<>(new Peasant());
        final Army<Man> knigthsReserve = new Escort<>(new Knight());
        final Avantgarde<Man> raiders = new Avantgarde<>(new Knight());

        moveAvangarde(knightsAvanLeft);
        moveKnights(knightsAvanRight);
        moveEscort(peasantsEscortBack);
        moveSomething(peasantEscortLeft);
        moveSomething(knigthsReserve);
        moveKnights(knigthsReserve);
        moveSomething(peasantEscortRigth);
        moveSomething(raiders);
    }
}
