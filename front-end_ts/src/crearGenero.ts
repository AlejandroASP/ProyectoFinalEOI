import { GenerosService } from './clase/generos-service';
import { Genero } from './interfaz/genero';

const generosService = new GenerosService();

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('formGenero') as HTMLFormElement;
    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const nombre = (form.elements.namedItem('nombre') as HTMLInputElement).value;
        const nuevoGenero: Genero = { nombre };

        try {
            await generosService.addJuego(nuevoGenero);
            window.location.href = "index.html";
            // updateGeneroList();
        } catch (error) {
            console.error('Error al crear el género:', error);
        }
    });
});
