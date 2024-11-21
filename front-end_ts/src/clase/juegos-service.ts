import { SERVER } from "../constants";
import { Juego } from "../interfaz/juego";
import { JuegoResponse, JuegosResponse } from "../interfaz/responses";
import { Http } from "./http";

export class JuegosService{
    http: Http = new Http();

    async getJuegos(): Promise<Juego[]>{
        const resp = await this.http.get<JuegosResponse>(`${SERVER}/juegos`);
        return resp.juegos;
    }
}