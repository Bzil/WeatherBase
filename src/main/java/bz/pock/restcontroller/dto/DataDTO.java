package bz.pock.restcontroller.dto;

import bz.pock.model.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataDTO {

    private static final DateTimeFormatter FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public long id;
    public String date;
    public double value;

    public DataDTO(long id, String date, double value) {
        this.id = id;
        this.date = date;
        this.value = value;
    }

    public static DataDTO to(Data d) {
        return new DataDTO(d.getId(), d.getDate().map(t -> t.format(FORMATER)).orElse(""), d.getValue());
    }

    public static Data from(DataDTO dto) {
        return Data.builder().id(dto.id).date(dto.date.isEmpty() ? null : LocalDateTime.parse(dto.date, FORMATER)).value(dto.value).build();
    }
}
