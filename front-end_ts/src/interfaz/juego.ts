export interface Juego{
    [x: string]: any;
    id?: number;
    nombre: string;
    completado: boolean;
    generoId: number;
}