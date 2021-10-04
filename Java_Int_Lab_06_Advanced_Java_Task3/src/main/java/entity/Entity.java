package entity;

import secured.Secured;

public class Entity {

    @Secured(number = 123)
    public void oneMethod(int x) {
        System.out.println("Публичный метод с параметром x = " + x);
    }

    @Secured(number = 321, type = "default-strict")
    private void twoMethod(int z, int q) {
        System.out.println("Закрытый метод с параметрами z = " + z + " и q = " + q);
    }

    protected void threeMethod() {
        System.out.println("Защищенный метод");
    }
}
