package org.example;

public class Children {
     String nombre;
     int edad;
     String genero;
     String identificacion;
     String alergias;
     String nombreAcudiente;
     String numeroAcudiente;


     //Metodo constructor

     public Children(String nombre, int edad, String genero, String identificacion, String alergias,
                     String nombreAcudiente, String numeroAcudiente) {

          this.nombre = nombre;
          this.edad = edad;
          this.genero = genero;
          this.identificacion = identificacion;
          this.alergias = alergias;
          this.nombreAcudiente = nombreAcudiente;
          this.numeroAcudiente = numeroAcudiente;
     }

     //Setters y getters
     public String getNombre() {
          return nombre;
     }
     public void setNombre(String nombre) {
          this.nombre = nombre;
     }
     public int getEdad() {
          return edad;
     }
     public void setEdad(int edad){
          this.edad = edad;
     }
     public String getGenero() {
          return genero;
     }
     public void setGenero(String genero) {
          this.genero = genero;
     }
     public String getIdentificacion() {
          return identificacion;
     }
     public void setIdentificacion(String identificacion) {
          this.identificacion = identificacion;
     }
     public String getAlergias() {
          return alergias;
     }
     public void setAlergias(String alergias) {
          this.alergias = alergias;
     }
     public String getNombreAcudiente() {
          return nombreAcudiente;
     }
     public void setNombreAcudiente(String nombreAcudiente) {
          this.nombreAcudiente = nombreAcudiente;
     }
     public String getNumeroAcudiente() {
          return numeroAcudiente;
     }
     public void setNumeroAcudiente(String numeroAcudiente) {
          this.numeroAcudiente = numeroAcudiente;
     }

     // Sobrescribir equals para comparar por documento de identidad
     @Override
     public boolean equals(Object obj) {
          if (this == obj) return true; // Son el mismo objeto
          if (obj == null || getClass() != obj.getClass()) return false; // No son del mismo tipo

          Children otroChildren = (Children) obj; // Convertir a Niño
          return identificacion.equals(otroChildren.identificacion); // Comparar documento de identidad
     }

     @Override
     public String toString() {
          return "nombre: " + nombre + ", edad: " + edad + ", genero: " + genero
                  + ", identificacion: " + identificacion + ", alergias: " + alergias
                  + ", nombreAcudiente: " + nombreAcudiente + ", numeroAcudiente: " + numeroAcudiente;
     }



}
