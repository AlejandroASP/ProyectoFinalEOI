import { JuegosService } from "./clase/juegos-service";
import { Juego } from "./interfaz/juego";

const juegoServ = new JuegosService();

const juegoTemplate = document.getElementById("juego") as HTMLTemplateElement;

const contenedor = document.getElementById("contenedor") as HTMLDivElement;

async function cargarJuegos() {
    try {
        const juegos = await juegoServ.getJuegos();
        console.log('Juegos obtenidos:', juegos); // Depuración
        if (!Array.isArray(juegos)) {
            console.error('Error: la respuesta no es un array.', juegos);
            return;
        }
        contenedor.innerHTML = "";
        juegos.forEach(addJuego);
        
    } catch (error) {
        console.log("Ha ocurrido un error a la hora de cargar los juegos");
    }
}

function addJuego(juego: Juego) {
    const mirror = juegoTemplate.content.cloneNode(true) as DocumentFragment;

    mirror.querySelector(".card-title")!.textContent = juego.nombre;
    mirror.querySelector(".card-text")!.textContent = juego.completado ? "Sí" : "No";

    const columna = mirror.firstChild!;
    mirror.querySelector("button.delete")!.addEventListener("click", async () => {
        try {
            await juegoServ.deleteJuego(juego.id!);
            await cargarJuegos();
        } catch (error) {
            console.error("Error al eliminar el juego")
        }
    });

    contenedor.append(mirror);
}


cargarJuegos();