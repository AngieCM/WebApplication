package Manejador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Angie_
 */
public class Alumnos {

    //Variables globales.
    private int codi;
    private String nom;
    private String asignaturas = "";
    private String tutorias = "";

    /**
     * Constructor vacio.
     */
    public Alumnos() {

    }

    /**
     * Constructor con los parametros globales.
     *
     * @param codi
     * @param nom
     */
    public Alumnos(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;
    }

    //Getters y Setters correspondientes a las variables globales de la clase.
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String asignaturas) {
        this.asignaturas += " / " + asignaturas + " / ";//Con el + va agregando mas datos a asignaturas.
    }

    public String getTutorias() {
        return tutorias;
    }

    public void setTutorias(String tutorias) {
        this.tutorias += " / " + tutorias + " / ";//Con el + va agregando mas datos a tutorias.
    }

    /**
     * Metodo toString que me devuelve los datos de alumno.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Alumno: " + nom + ", codigo: " + codi;
    }

}
