package main;

import java.nio.file.Path;
import model.Rezept;
import repository.repo_EKG;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws Exception {
        Path jsonPath = args.length > 0 ? Path.of(args[0]) : Path.of("rezepte.json");
        if (!Files.exists(jsonPath)) {
            throw new IllegalStateException(
                    "Rezepte-Datei nicht gefunden: " + jsonPath.toAbsolutePath() +
                            " (uebergib Pfad als erstes Argument oder lege rezepte.json im Projektordner ab)"
            );
        }

        repo_EKG repo = new repo_EKG(jsonPath);

        var rezepte = repo.ladeAlle();

        for (Rezept r : rezepte) {
            System.out.println(r.getName());
            r.getZutaten().forEach(z ->
                    System.out.println("  - " + z.getMenge() + " " +
                            z.getEinheit() + " " + z.getName()));
        }
    }
}
