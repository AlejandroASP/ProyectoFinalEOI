import { GenerosService } from './clase/generos-service';
import { Genero } from './interfaz/genero';

const generosService = new GenerosService();

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('formGenero') as HTMLFormElement;
    // const generoList = document.getElementById('generoList') as HTMLUListElement;

    // // Función para actualizar la lista de géneros
    // const updateGeneroList = async () => {
    //     try {
    //         const generos: Genero[] = await generosService.getGeneros();
    //         generoList.innerHTML = '';
    //         generos.forEach(genero => {
    //             const li = document.createElement('li');
    //             li.textContent = genero.nombre;
    //             const deleteButton = document.createElement('button');
    //             deleteButton.textContent = 'Eliminar';
    //             deleteButton.addEventListener('click', async () => {
    //                 await generosService.deleteJuego(genero.id!);
    //                 updateGeneroList();
    //             });
    //             li.appendChild(deleteButton);
    //             generoList.appendChild(li);
    //         });
    //     } catch (error) {
    //         console.error('Error al obtener los géneros:', error);
    //     }
    // };

    // // Inicializar la lista de géneros
    // updateGeneroList();

    // Manejar el envío del formulario para crear un nuevo género
    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const nombre = (form.elements.namedItem('nombre') as HTMLInputElement).value;
        const nuevoGenero: Genero = { nombre };

        try {
            await generosService.addJuego(nuevoGenero);
            form.reset();
            // updateGeneroList();
        } catch (error) {
            console.error('Error al crear el género:', error);
        }
    });
});
