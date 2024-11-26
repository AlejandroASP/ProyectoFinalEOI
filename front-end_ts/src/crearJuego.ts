import { JuegosService } from './clase/juegos-service';
import { GenerosService } from './clase/generos-service';
import { Juego } from './interfaz/juego';
import { Genero } from './interfaz/genero';

const juegosService = new JuegosService();
const generosService = new GenerosService();

document.addEventListener('DOMContentLoaded', async () => {
    try {
        const generos: Genero[] = await generosService.getGeneros();
        const generoSelect = document.getElementById('genero') as HTMLSelectElement;
        generos.forEach(genero => {
            if (genero.id !== undefined) {
                const option = document.createElement('option');
                option.value = genero.id.toString();
                option.text = genero.nombre;
                generoSelect.appendChild(option);
            }
        });
    } catch (error) {
        console.error('Error al obtener los géneros:', error);
    }

    const form = document.getElementById('formEvento') as HTMLFormElement;
    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const nombre = (form.elements.namedItem('nombre') as HTMLInputElement).value;
        const generoId = (form.elements.namedItem('genero') as HTMLSelectElement).value;
        const completado = (form.elements.namedItem('completado') as HTMLSelectElement).value === "true";

        const juego: Juego = {
            nombre,
            completado,
            generoId: parseInt(generoId)
        };

        try {
            const nuevoJuego = await juegosService.addJuego(juego);
            console.log('Juego creado:', nuevoJuego);
            window.location.href = "index.html"; //Al añadir el juego, se manda al index
        } catch (error) {
            console.error('Error al crear el juego:', error);
        }
    });
});
