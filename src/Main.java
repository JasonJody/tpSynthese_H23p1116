//https://github.com/JasonJody/tpSynthese_H23p1116.git
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
public class Main {
	// TODO 15 : public static List<Personne> lireFichier(String fichier)
    // TODO 16: public static void ecrireFichier(List<Personne> personnes, String fichier)
    public static class Personne {
        private String nom;
        private int age;
        private String courriel;
        public Personne(String nom, int age, String courriel) {
            this.nom = nom;
            this.age = age;
            this.courriel = courriel;
        }
        public String getNom() {
            return nom;
        }
        public int getAge() {
            return age;
        }
        public String getCourriel() {
            return courriel;
        }
    }
     
       
 
    public static void main(String[] args) throws FileNotFoundException {
        // TODOs 11 à 14
        new CalculatriceSwing(); // démarre une calculatrice dont le fonctionnement et l'interface
                            // sont expliqués dans un clip: https://www.loom.com/share/b92c35aead684f3f872197a0558cb99a
       String fichier = "entrees.txt";
        // TODO 15
        List<Personne> personnes = lireFichier(fichier); // la classe Personne est fournie
        System.out.println("Données extraites du fichier :");
        for (Personne person : personnes) {
            System.out.println("Nom : " + person.getNom());
            System.out.println("Âge : " + person.getAge());
            System.out.println("Courriel : " + person.getCourriel());
            System.out.println();
        }
        // TODO 16
        ecrireFichier(personnes, "sorties.html"); // exemple fourni


    }

    public static List<Personne> lireFichier(String cheminFichier) {
        List<Personne> personnes = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(cheminFichier));

            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                String[] informations = ligne.split(",");

                String nom = informations[0].trim();
                int age = Integer.parseInt(informations[1].trim());
                String courriel = informations[2].trim();

                Personne personne = new Personne(nom, age, courriel);
                personnes.add(personne);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé : " + e.getMessage());
        }

        return personnes;
    }

    public static void ecrireFichier(List<Personne> personnes, String cheminFichier) {
        try {
            PrintWriter writer = new PrintWriter(cheminFichier);

            writer.println("<html>");
            writer.println("<body>");

            for (Personne personne : personnes) {
                writer.println("<p>");
                writer.println("Nom: <strong>" + personne.getNom() + "</strong><br>");
                writer.println("Age: " + personne.getAge() + "<br>");
                writer.println("Email: <a href=\"" + personne.getCourriel() + "\">" + personne.getCourriel() + "</a><br>");
                writer.println("</p>");
            }

            writer.println("</body>");
            writer.println("</html>");

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
