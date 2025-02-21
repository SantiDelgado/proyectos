package org.example;
public class Estudiante {

        private int identificacion;
        private String nombre;
        private String apellido;
        private String correo;
        private int edad;
        private long telefono;

        //constructor
        public Estudiante(int identificacion, String nombre, String apellido, String correo, int edad, long telefono) {
            this.identificacion = identificacion;
            this.nombre = nombre;
            this.apellido = apellido;
            this.correo = correo;
            this.edad = edad;
            this.telefono = telefono;

            }


        @Override
        public String toString() {
            return "id: " + identificacion + " nombre: " + nombre + " apellido: " + apellido + "correo: " + correo + "edad: "
                    + edad + "telefono: " + telefono ;
        }

        }







