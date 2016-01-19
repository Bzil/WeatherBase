package bz.pock.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Data implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;
    private Double value;
    @ManyToOne
    private Sensor sensor;

    /**
     * Private constructeur, use Builder.
     */
    private Data() {
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
     * Getter for property 'date'.
     *
     * @return Value for property 'date'.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Getter for property 'value'.
     *
     * @return Value for property 'value'.
     */
    public Double getValue() {
        return value;
    }

    /**
     * Getter for property 'sensor'.
     *
     * @return Value for property 'sensor'.
     */
    public Sensor getSensot() {
        return sensor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Data)) {
            return false;
        }

        Data data = (Data) o;

        if (id != null ? !id.equals(data.id) : data.id != null) {
            return false;
        }
        if (date != null ? !date.equals(data.date) : data.date != null) {
            return false;
        }
        if (value != null ? !value.equals(data.value) : data.value != null) {
            return false;
        }
        return sensor != null ? sensor.equals(data.sensor) : data.sensor == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (sensor != null ? sensor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", date=" + date +
                ", value=" + value +
                ", sensor=" + sensor.getId() +
                '}';
    }

    /**
     * Builder.
     *
     * @return builder
     */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Data data;

        /**
         * Constructeur.
         */
        private Builder() {
            data = new Data();
        }

        /**
         * Build.
         *
         * @return the object
         */
        public Data build() {
            return data;
        }

        /**
         * Set id to data.
         *
         * @param id id to set
         * @return builder
         */
        public Builder id(Long id) {
            data.id = id;
            return this;
        }

        /**
         * Set date to data.
         *
         * @param date date to set
         * @return builder
         */
        public Builder date(LocalDateTime date) {
            data.date = date;
            return this;
        }

        /**
         * Set value to data.
         *
         * @param value value to set
         * @return builder
         */
        public Builder value(Double value) {
            data.value = value;
            return this;
        }

        /**
         * Set sensor to data.
         *
         * @param sensor value to set
         * @return builder
         */
        public Builder value(Sensor sensor) {
            data.sensor = sensor;
            return this;
        }

    }
}
