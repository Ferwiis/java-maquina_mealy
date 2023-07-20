package modelo;

import vista.*;
import controlador.*;

public class Main {

    public static void main(String[] args) {
        VMealy vista = new VMealy();
        VFichero lectura = new VFichero();
        Controlador_Mealy control = new Controlador_Mealy(vista, lectura);
        control.iniciarVentanaPrincipal();
    }
}
