/**
 * Interfaz que define las operaciones básicas de una radio.
 */
public interface RadioInterface {

    /**
     * Enciende la radio.
     */
    void enceder();

    /**
     * Apaga la radio.
     */
    void apagar();

    /**
     * Cambia a la siguiente estación de radio.
     */
    void subirEmisora();

    /**
     * Cambia a la estación de radio anterior.
     */
    void bajarEmisora();

    /**
     * Cambia la frecuencia de la radio entre AM y FM.
     */
    void cambiarBanda();

    /**
     * Guarda la estación actual en un botón preestablecido.
     */
    void guardarEmisora();


    /**
     * Establece la estación actual de la radio.
     *
     * @param value Valor de la estación a establecer.
     */
    void seleccionarEmisora(double value);

    /**
     * Establece el volumen de la radio.
     *
     * @param volume Valor del volumen a establecer.
     */
    void setVolume(int volume);

    /**
     * Verifica si la radio está encendida.
     *
     * @return true si la radio está encendida, false de lo contrario.
     */
    boolean getEncendido();


    /**
     * Devuelve el valor del volumen.
     *
     * @return Retorna el valor del volumen.
     */
    int getVolume();



}
