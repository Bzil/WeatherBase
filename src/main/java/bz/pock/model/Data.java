package bz.pock.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@Document
public class Data implements Serializable {

    @Id
    private Long id;
    private Optional<LocalDateTime> date = Optional.empty();
    private Double value;

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
    public Optional<LocalDateTime> getDate() {
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


    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", date=" + date +
                ", value=" + value +
                '}';
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
        return !(value != null ? !value.equals(data.value) : data.value != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
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


        public Builder id(Long id) {
            data.id = id;
            return this;
        }


        public Builder date(LocalDateTime date) {
            data.date = Optional.ofNullable(date);
            return this;
        }

        public Builder value(Double value) {
            data.value = value;
            return this;
        }

    }
}
