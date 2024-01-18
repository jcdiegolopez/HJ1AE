import org.junit.Test;
import static org.junit.Assert.*;

public class RadioTest {


    //validar si se cambia el volumen correctamente
    @Test
    public void testCambioVolumen() {
        Radio radio = new Radio();
        int volumenInicial = radio.getVolume();

        radio.volumeUp();
        assertEquals(volumenInicial + 10, radio.getVolume());

        radio.volumeDown();
        assertEquals(volumenInicial, radio.getVolume()); 
    }

    //validar si el cambio de la radio es correcto
    @Test
    public void testCambioEstacion() {
        Radio radio = new Radio();
        double estacionInicial = radio.getActual();

        radio.subirEmisora();
        assertEquals(estacionInicial + 10, radio.getActual(),0.01);

        radio.bajarEmisora();
        assertEquals(estacionInicial, radio.getActual(),0.01); 
    }
    

    //validar si el cambio de la frecuencia es correcta
    @Test
    public void testCambioFrecuencia() {
        Radio radio = new Radio();
        String frecuenciaInicial = radio.getFrequency();

        radio.cambiarBanda();
        assertEquals("FM", radio.getFrequency()); 

        radio.cambiarBanda();
        assertEquals(frecuenciaInicial, radio.getFrequency());
    }


    //Validar si se guardo la radio esperada
    @Test
    public void testGuardarSeleccionarEmisora() {
        Radio radio = new Radio();
        radio.enceder();

        radio.guardarEmisora();
        assertEquals(1, radio.findEmptySlot(0)); 

        radio.cambiarBanda();
        radio.guardarEmisora();
        assertEquals(1, radio.findEmptySlot(1)); 

        radio.cambiarBanda();
        radio.selectSaved(1);
        assertEquals(530, radio.getActual(),0.01); 
    }
}
