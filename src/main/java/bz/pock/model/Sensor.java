package bz.pock.model;

import org.jscience.geography.coordinates.LatLong;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.measure.unit.Unit;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Document
public class Sensor implements Serializable {
    /**
     * Id du capteur.
     */
    private Long id;
    /**
     * Non du capteur.
     */
    private String name;
    /**
     * Date d'ajout.
     */
    private LocalDate date;
    /**
     * Unité de la donnée.
     */
    private Unit unity;
    /**
     * Etat de la batterie, faux par défaut.
     */
    private Boolean lowBattery;
    /**
     * Localisation sur capteur en degrée.
     */
    private LatLong localization;
    /**
     * Fréquence de mesure.
     */
    private Long frequency;
    /**
     * Liste des données enregistrée par le capteur.
     */
    private Set<Data> datas = new LinkedHashSet<>();

    /**
     * Private constructeur, use Builder.
     */
    private Sensor() {
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for property 'date'.
     *
     * @return Value for property 'date'.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Getter for property 'unity'.
     *
     * @return Value for property 'unity'.
     */
    public Unit getUnity() {
        return unity;
    }

    /**
     * Getter for property 'lowBattery'.
     *
     * @return Value for property 'lowBattery'.
     */
    public Boolean isLowBattery() {
        return lowBattery;
    }

    /**
     * Getter for property 'localization'.
     *
     * @return Value for property 'localization'.
     */
    public LatLong getLocalization() {
        return localization;
    }

    /**
     * Getter for property 'frequency'.
     *
     * @return Value for property 'frequency'.
     */
    public Long getFrequency() {
        return frequency;
    }

    /**
     * Getter for property 'datas'.
     *
     * @return Value for property 'datas'.
     */
    public Set<Data> getDatas() {
        return datas;
    }

    /**
     * Builder.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder.
     *
     * @param sensor sensor à construire
     * @return builder
     */
    public static Builder builder(Sensor sensor) {
        return new Builder(sensor);
    }

    public static class Builder {
        private Sensor sensor;

        /**
         * Constructeur.
         */
        private Builder() {
            sensor = new Sensor();
        }

        /**
         * Constructeur.
         *
         * @param sensor sensor à construire
         */
        private Builder(Sensor sensor) {
            this.sensor = sensor;
        }

        /**
         * Set id to sensor.
         *
         * @param id id to set
         * @return builder
         */
        public Builder id(Long id) {
            sensor.id = id;
            return this;
        }

        /**
         * Set name to sensor.
         *
         * @param name name to set
         * @return builder
         */
        public Builder name(String name) {
            sensor.name = name;
            return this;
        }

        /**
         * Set date to sensor.
         *
         * @param date date to set
         * @return builder
         */
        public Builder date(LocalDate date) {
            sensor.date = date;
            return this;
        }

        /**
         * Set unity to sensor.
         *
         * @param unity unity to set
         * @return builder
         */
        public Builder unity(Unit unity) {
            sensor.unity = unity;
            return this;
        }

        /**
         * Set lowBattery to sensor.
         *
         * @param lowBattery lowBattery to set
         * @return builder
         */
        public Builder lowBattery(Boolean lowBattery) {
            sensor.lowBattery = lowBattery;
            return this;
        }

        /**
         * Set localization to sensor.
         *
         * @param localization localization to set
         * @return builder
         */
        public Builder localization(LatLong localization) {
            sensor.localization = localization;
            return this;
        }

        /**
         * Set frequency to sensor.
         *
         * @param frequency frequency to set
         * @return builder
         */
        public Builder frequency(Long frequency) {
            sensor.frequency = frequency;
            return this;
        }

        /**
         * Set datas to sensor.
         *
         * @param datas datas to set
         * @return builder
         */
        public Builder datas(Set<Data> datas) {
            sensor.datas = datas;
            return this;
        }

        /**
         * Add datas to sensor.
         *
         * @param datas datas to set
         * @return builder
         */
        public Builder addDatas(Set<Data> datas) {
            sensor.datas.addAll(datas);
            return this;
        }

        /**
         * Build.
         *
         * @return the object
         */
        public Sensor build() {
            return sensor;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sensor)) {
            return false;
        }

        Sensor sensor = (Sensor) o;

        if (id != null ? !id.equals(sensor.id) : sensor.id != null) {
            return false;
        }
        if (name != null ? !name.equals(sensor.name) : sensor.name != null) {
            return false;
        }
        if (date != null ? !date.equals(sensor.date) : sensor.date != null) {
            return false;
        }
        if (unity != null ? !unity.equals(sensor.unity) : sensor.unity != null) {
            return false;
        }
        if (lowBattery != null ? !lowBattery.equals(sensor.lowBattery) : sensor.lowBattery != null) {
            return false;
        }
        if (localization != null ? !localization.equals(sensor.localization) : sensor.localization != null) {
            return false;
        }
        if (frequency != null ? !frequency.equals(sensor.frequency) : sensor.frequency != null) {
            return false;
        }
        return !(datas != null ? !datas.equals(sensor.datas) : sensor.datas != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (unity != null ? unity.hashCode() : 0);
        result = 31 * result + (lowBattery != null ? lowBattery.hashCode() : 0);
        result = 31 * result + (localization != null ? localization.hashCode() : 0);
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        result = 31 * result + (datas != null ? datas.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", unity=" + unity +
                ", lowBattery=" + lowBattery +
                ", localization=" + localization +
                ", frequency=" + frequency +
                ", datas=" + datas +
                '}';
    }
}
