import { SERVER } from "../constants";
import { Genero } from "../interfaz/genero";
import { GeneroResponse, GenerosResponse } from "../interfaz/responses";
import { Http } from "./http";

export class GenerosService {
    http: Http = new Http();

    async getGeneros(): Promise<Genero[]> {
        const response = await this.http.get<Genero[]>(`${SERVER}/generos`);
        console.log('Respuesta del servidor:', response);
        return response;
    }

    async addJuego(genero: Genero): Promise<Genero> {
        const response = await this.http.post<GeneroResponse, Genero>(`${SERVER}/generos`, genero);

        return response.generos;
    }

    deleteJuego(id: number): Promise<void> {
        return this.http.delete<void>(`${SERVER}/generos/${id}`);
    }
}