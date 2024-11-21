import { Genero } from "./genero";
import { Juego } from "./juego";


export interface JuegosResponse {
    juegos: Juego[];
}

export interface JuegoResponse {
    juego: Juego;
}

export interface GenerosResponse {
    generos: Genero[];
}

export interface GeneroResponse {
    generos: Genero;
}