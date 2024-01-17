/**
 * Clase que representa una radio con funciones básicas.
 * Implementa la interfaz RadioInterface.
 */
public class Radio implements RadioInterface {
    private boolean on = false;
    private String frequency = "AM";
    private int volume = 50;
    private double[][] saved = new double[2][12];
    private double actual = 530;

    /**
     * Muestra el volumen actual de la radio.
     */
    public void showVolume() {
        System.out.println("El volumen actual es: " + this.volume);
    }

    /**
     * Verifica si la radio está encendida.
     *
     * @return true si la radio está encendida, false de lo contrario.
     */
    public boolean isOn() {
        return on;
    }


    /**
     * Devuelve el de la estacion.
     *
     * @return Retorna la estacion actual.
     */
    public double getActual() {
        return this.actual;
    }

    /**
     * Devuelve la frecuencia actual
     *
     * @return Retorna la frecuencia actual
     */
    public String getFrequency() {
        return this.frequency;
    }

    /**
     * Devuelve el valor del volumen.
     *
     * @return Retorna el valor del volumen.
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * Muestra la frecuencia y estación actual de la radio.
     */
    public void showActual() {
        System.out.println("Frecuencia: " + this.frequency + ", Estacion: " + this.actual);
    }

    /**
     * Enciende la radio.
     */
    public void Onradio() {
        this.on = true;
        System.out.println("Radio encendida");
    }

    /**
     * Apaga la radio.
     */
    public void OffRadio() {
        this.on = false;
        System.out.println("Radio apagada");
    }

    /**
     * Establece el volumen de la radio.
     *
     * @param value Valor del volumen a establecer.
     */
    public void setVolume(int value) {
        if (value <= 100 && value >= 0) {
            this.volume = value;
        } else {
            System.out.println("Ha llegado al límite de volumen");
        }
        showVolume();
    }

    /**
     * Establece la estación actual de la radio.
     *
     * @param value Valor de la estación a establecer.
     */
    public void setActual(double value) {
        this.actual = value;
        showActual();
    }

    /**
     * Aumenta el volumen de la radio.
     */
    public void volumeUp() {
        if (this.volume < 100) {
            setVolume(this.volume + 10);
        } else {
            setVolume(0);
        }
    }

    /**
     * Disminuye el volumen de la radio.
     */
    public void volumeDown() {
        if (this.volume > 0) {
            setVolume(this.volume - 10);
        } else {
            setVolume(100);
        }
    }

    /**
     * Cambia a la siguiente estación de radio.
     */
    public void nextRadio() {
        if (this.frequency.equals("AM")) {
            if (this.actual < 1610) {
                setActual(this.actual + 10);
            } else {
                System.out.println("Ya no hay más estaciones");
            }
        } else if (this.frequency.equals("FM")) {
            if (this.actual < 107.9) {
                setActual(this.actual + 0.2);
            } else {
                System.out.println("Ya no hay más estaciones");
            }
        }
    }

    /**
     * Cambia a la estación de radio anterior.
     */
    public void previousRadio() {
        if (this.frequency.equals("AM")) {
            if (this.actual > 530) {
                setActual(this.actual - 10);
            } else {
                System.out.println("Ya no hay más estaciones");
            }
        } else if (this.frequency.equals("FM")) {
            if (this.actual > 87.9) {
                setActual(this.actual - 0.2);
            } else {
                System.out.println("Ya no hay más estaciones");
            }
        }
    }

    /**
     * Cambia la frecuencia de la radio entre AM y FM.
     */
    public void changeFrecuency() {
        if (this.frequency.equals("FM")) {
            this.frequency = "AM";
            setActual(530);
        } else if (this.frequency.equals("AM")) {
            this.frequency = "FM";
            setActual(87.9);
        }
    }

    /**
     * Guarda la estación actual en un botón preestablecido.
     */
    public void saveRadio() {
        int listIndex = 0;
        if (this.frequency.equals("AM")) {
            listIndex = 0;
        } else if (this.frequency.equals("FM")) {
            listIndex = 1;
        }

        int emptySlot = findEmptySlot(listIndex);

        if (emptySlot != -1) {
            this.saved[listIndex][emptySlot] = this.actual;
            System.out.println("Emisora guardada en el botón " + (emptySlot + 1));
        } else {
            System.out.println("Todas las emisoras ya están ocupadas. No se pudo guardar.");
        }
    }

    /**
     * Encuentra la primera ranura vacía en la lista de emisoras guardadas.
     *
     * @param listIndex Índice de la lista de emisoras guardadas (AM o FM).
     * @return Índice de la primera ranura vacía, o -1 si no hay ranuras vacías.
     */
    public int findEmptySlot(int listIndex) {
        for (int i = 0; i < 12; i++) {
            if (this.saved[listIndex][i] == 0.0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Muestra las emisoras guardadas para la frecuencia actual.
     */
    public void showSavedRadios() {
        int listIndex = 0;
        if (this.frequency.equals("AM")) {
            listIndex = 0;
        } else if (this.frequency.equals("FM")) {
            listIndex = 1;
        }
        System.out.println("-------------------- EMISORAS GUARDADAS EN " + this.actual + " --------------------");
        for (int i = 0; i < 12; i++) {
            if (this.saved[listIndex][i] != 0.0) {
                System.out.println((i + 1) + ". " + this.saved[listIndex][i]);
            }
        }
    }

    /**
     * Selecciona una emisora guardada y la establece como la estación actual.
     *
     * @param index Índice de la emisora guardada.
     */
    public void selectSaved(int index) {
        int listIndex = 0;
        if (this.frequency.equals("AM")) {
            listIndex = 0;
        } else if (this.frequency.equals("FM")) {
            listIndex = 1;
        }
        double send = this.saved[listIndex][index];
        if (send != 0.0) {
            setActual(send);
        } else {
            System.out.println("No hay ninguna emisora guardada aquí");
        }
    }
}
