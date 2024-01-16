/**
 * Interfaz que define las operaciones básicas de una radio.
 */
public interface RadioInterface {

    /**
     * Enciende la radio.
     */
    void Onradio();

    /**
     * Apaga la radio.
     */
    void OffRadio();

    /**
     * Aumenta el volumen de la radio.
     */
    void volumeUp();

    /**
     * Disminuye el volumen de la radio.
     */
    void volumeDown();

    /**
     * Cambia a la siguiente estación de radio.
     */
    void nextRadio();

    /**
     * Cambia a la estación de radio anterior.
     */
    void previousRadio();

    /**
     * Cambia la frecuencia de la radio entre AM y FM.
     */
    void changeFrecuency();

    /**
     * Guarda la estación actual en un botón preestablecido.
     */
    void saveRadio();

    /**
     * Muestra el volumen actual de la radio.
     */
    void showVolume();

    /**
     * Muestra la frecuencia y estación actual de la radio.
     */
    void showActual();

    /**
     * Establece la estación actual de la radio.
     *
     * @param value Valor de la estación a establecer.
     */
    void setActual(double value);

    /**
     * Establece el volumen de la radio.
     *
     * @param volume Valor del volumen a establecer.
     */
    void setVolume(int volume);

    /**
     * Selecciona una emisora guardada y la establece como la estación actual.
     *
     * @param index Índice de la emisora guardada.
     */
    void selectSaved(int index);

    /**
     * Muestra las emisoras guardadas.
     */
    void showSavedRadios();

    /**
     * Verifica si la radio está encendida.
     *
     * @return true si la radio está encendida, false de lo contrario.
     */
    boolean isOn();


    /**
     * Devuelve el valor del volumen.
     *
     * @return Retorna el valor del volumen.
     */
    int getVolume();

    /**
     * Devuelve el valor de la estacion.
     *
     * @return Retorna la estacion actual.
     */
    double getActual();

    /**
     * Devuelve la frecuencia actual
     *
     * @return Retorna la frecuencia actual
     */
    String getFrequency();


}
