//Stale zmienne zeby nie music za kazdym razem wpisywac

package control;

public final class WazneDane {
    public WazneDane() {}
    
    static public String getDB() {
        return "jdbc:derby://localhost/komputery-db";
    }
    static public String logDB() {
        return "root";
    }
    static public String passDB() {
        return "root";
    }
}
