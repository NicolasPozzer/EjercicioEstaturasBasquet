package com.demo.EjercicioEstaturasBasquet.controller;

import com.demo.EjercicioEstaturasBasquet.model.Jugador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {

    @PostMapping("/jugadores")
    public String calcularPromedioEstatura(@RequestBody List<Jugador> listaJugadores){

        //Declaramos las variables locales para hacer la resolucion de la logica
        double acum_alturas= 0.0;
        double promedio_alturas= 0.0;


        /*Guardamos la lista en nuestra db logica en forma de Arraylist
        * para cumplir con lo que pide el POST, que es un alta*/
        List<Jugador> listaJuga = new ArrayList<Jugador>();
        listaJuga = listaJugadores;

        //acumulamos las estaturas
        for (Jugador jug : listaJuga){
            acum_alturas = acum_alturas + jug.getEstatura();
        }

        /*sacamos el promedio con el acumulador de alturas dividido por
        * el total de jugadores, con size obtenemos el tamanio de la lista*/
        promedio_alturas = acum_alturas / (listaJuga.size());


        //como "Response" retornamos como dato las alturas de los jugadores
        return "Jugadores Registrados correctamente. El promedio de estatura de los mismos es: " + promedio_alturas;
    }

}
