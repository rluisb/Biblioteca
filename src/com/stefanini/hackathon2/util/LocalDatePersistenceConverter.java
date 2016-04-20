package com.stefanini.hackathon2.util;

import java.sql.Date;
import java.time.LocalDate;

import javax.faces.convert.FacesConverter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
@FacesConverter("conversorLocalDateToDate")
public class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {

    public Date convertToDatabaseColumn(LocalDate entityValue) {
        return (entityValue == null) ? null : Date.valueOf(entityValue);
    }

    public LocalDate convertToEntityAttribute(Date databaseValue) {
    	return (databaseValue == null) ? null : databaseValue.toLocalDate();
    }
}
