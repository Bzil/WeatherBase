package bz.pock.restcontroller.dto;

import bz.pock.model.Sensor;

import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

import static javax.measure.unit.SI.RADIAN;

public class SensorDTO {
    /**
     * Classe pour représenter la possition d'un object sur terre.
     */
    static class LatLongDTO {
        public double latitude;
        public double longitude;
        public String radius; // RADIAN or DEGREE

        /**
         * Constructeur.
         *
         * @param latitude  latitude
         * @param longitude longitude
         * @param radius    radius
         */
        private LatLongDTO(double latitude, double longitude, String radius) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.radius = radius;
        }
    }

    private static final DateTimeFormatter FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public long id;
    public String name;
    public String date;
    public String unity;
    public boolean lowBattery;
    public LatLongDTO localization;
    public long frequency;
    public Set<DataDTO> datas;

    /**
     * Constructeur.
     *
     * @param id           id
     * @param name         name
     * @param date         date
     * @param unity        unity
     * @param lowBattery   lowBattery
     * @param localization localization
     * @param frequency    frequency
     * @param datas        datas
     */
    private SensorDTO(long id, String name, String date, String unity, boolean lowBattery, LatLongDTO localization, long frequency, Set<DataDTO> datas) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.unity = unity;
        this.lowBattery = lowBattery;
        this.localization = localization;
        this.frequency = frequency;
        this.datas = datas;
    }

    /**
     * Transforme un capteur en dto.
     *
     * @param s capteur
     * @return dto correspondant
     */
    public static SensorDTO to(Sensor s) {
        return new SensorDTO(
                s.getId(),
                s.getName(),
                s.getDate().format(FORMATER), s.getUnity().toString(),
                s.isLowBattery(),
                new LatLongDTO(s.getLocalization().latitudeValue(RADIAN),
                        s.getLocalization().longitudeValue(RADIAN), "radian"),
                s.getFrequency(),
                s.getDatas().stream().map(DataDTO::to).collect(Collectors.toSet()));
    }

    /**
     * Transforme un dto en capteur.
     *
     * @param dto capteur
     * @return capteur correspondant
     */
    public static Sensor from(SensorDTO dto) {
        return null;
        // return Sensor.builder().id(dto.id).date(dto.date.isEmpty() ? null : LocalDateTime.parse(dto.date, FORMATER)).value(dto.value).build();
    }
}
