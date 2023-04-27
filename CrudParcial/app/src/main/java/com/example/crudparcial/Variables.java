package com.example.crudparcial;

public class Variables {
    private  static Variables instance;

    private  static  int codigo=0;
    private  static  String nombre="";
    private  static  String telefono="";

    public  int codigo() {
        return codigo;
    }

    public  void set_codigousuario(int codigo) {
        Variables.codigo = codigo;
    }


    public  void set_telefono(String telefono) {
        Variables.telefono = telefono;
    }

    public  String getNombre() {
        return nombre;
    }

    public  void set_nombre(String _email) {
        Variables.nombre = nombre;
    }


    public static synchronized Variables getInstance() {
        if (instance == null) {
            instance = new Variables();
        }
        return instance;
    }
}
