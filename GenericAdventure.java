//Помоги главнокомандующему справиться с войсками (поправить компиляцию, упростить, где можно, но трогать функцию main нельзя)
  public static class GenericAdventure {
    public interface Man {
    }

    public static class Knight implements Man {
      public void cry() {
      }
    }

    public static class Peasant implements Man {
    }

    public interface Army<T extends Man> {
      T getCommander();

      void move();
    }

    public static class Avantgarde<T extends Man> implements Army<T> {
      private T commander;

      public Avantgarde(T commander) {
        this.commander = commander;
      }

      @Override
      public T getCommander() {
        return commander;
      }

      public void fallBack() {
      }

      public void move() {
      }
    }

    public static class Escort<T extends Man> implements Army<T> {
      private T commander;

      public Escort(T commander) {
        this.commander = commander;
      }

      @Override
      public T getCommander() {
        return commander;
      }

      public void move() {
      }
    }

    public static void doScout(Avantgarde<Knight> avantgarde) {
      avantgarde.move();
      avantgarde.fallBack();
    }

    public static void moveEscort(Escort<Man> escort) {
      escort.move();
    }

    public static void moveKnights(Army<Knight> avantgarde) {
      avantgarde.getCommander().cry();
      avantgarde.move();
    }

    public static void moveSomething(Army<? extends Man> army) {
      army.move();
    }

    public static void main(String[] args) {
      final Avantgarde<Knight> knightsAvanLeft = new Avantgarde<>(new Knight());
      final Army<Knight> knightsAvanRight = new Avantgarde<>(new Knight());
      final Escort<Man> peasantsEscortBack = new Escort<>(new Peasant());
      final Escort<Peasant> peasantEscortLeft = new Escort<>(new Peasant());
      final Army<Peasant> peasantEscortRigth = new Escort<>(new Peasant());
      final Army<Knight> knigthsReserve = new Escort<>(new Knight());
      final Avantgarde<Man> raiders = new Avantgarde<>(new Knight());

      doScout(knightsAvanLeft);
      moveKnights(knightsAvanRight);
      moveEscort(peasantsEscortBack);
      moveSomething(peasantEscortLeft);
      moveSomething(knigthsReserve);
      moveKnights(knigthsReserve);
      moveSomething(peasantEscortRigth);
      moveSomething(raiders);
    }
  }
