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

        radio.nextRadio();
        assertEquals(estacionInicial + 10, radio.getActual(),0.01);

        radio.previousRadio();
        assertEquals(estacionInicial, radio.getActual(),0.01); 
    }
    

    //validar si el cambio de la frecuencia es correcta
    @Test
    public void testCambioFrecuencia() {
        Radio radio = new Radio();
        String frecuenciaInicial = radio.getFrequency();

        radio.changeFrecuency();
        assertEquals("FM", radio.getFrequency()); 

        radio.changeFrecuency();
        assertEquals(frecuenciaInicial, radio.getFrequency());
    }


    //Validar si se guardo la radio esperada
    @Test
    public void testGuardarSeleccionarEmisora() {
        Radio radio = new Radio();
        radio.Onradio();

        radio.saveRadio();
        assertEquals(1, radio.findEmptySlot(0)); 

        radio.changeFrecuency();
        radio.saveRadio();
        assertEquals(1, radio.findEmptySlot(1)); 

        radio.changeFrecuency();
        radio.selectSaved(1);
        assertEquals(530, radio.getActual(),0.01); 
    }
}
