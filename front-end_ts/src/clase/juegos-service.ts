import { SERVER } from "../constants";
import { Juego } from "../interfaz/juego";
import { JuegoResponse, JuegosResponse } from "../interfaz/responses";
import { Http } from "./http";

export class JuegosService {
    http: Http = new Http();

    async getJuegos(): Promise<Juego[]> {
        const response = await this.http.get<JuegosResponse>(`${SERVER}/juegos`);
        return response.juegos;
    }

    async addJuego(juego: Juego): Promise<Juego> {
        const response = await this.http.post<JuegoResponse, Juego>(`${SERVER}/juegos`, juego);

        return response.juego;
    }

    deleteJuego(id: number): Promise<void> {
        return this.http.delete<void>(`${SERVER}/juegos/${id}`);
    }
}