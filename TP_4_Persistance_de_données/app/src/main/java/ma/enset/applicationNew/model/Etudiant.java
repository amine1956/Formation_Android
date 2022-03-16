package ma.enset.applicationNew.model;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private  int age;
    private  String Nom;
    private  String Prenom;

    @Override
    public String toString() {
        return "Etudiant{" +
                "age=" + age +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                '}';
    }

    public Etudiant(int age, String nom, String prenom) {
        this.age = age;
        Nom = nom;
        Prenom = prenom;
    }

    public Etudiant() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }


}
