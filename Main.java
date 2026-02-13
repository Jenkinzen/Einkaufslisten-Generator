public class Main {
    public static void main(String[] args) throws Exception {

        RezeptRepository repo =
                new RezeptRepository(Path.of("../python/rezepte.json"));

        var rezepte = repo.ladeAlle();

        for (Rezept r : rezepte) {
            System.out.println(r.getName());
            r.getZutaten().forEach(z ->
                    System.out.println("  - " + z.getMenge() + " " +
                            z.getEinheit() + " " + z.getName()));
        }
    }
}