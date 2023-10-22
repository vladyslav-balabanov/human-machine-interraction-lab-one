package com.example.application.models;

import com.vaadin.flow.component.template.Id;
import lombok.Data;
import lombok.Generated;
import lombok.experimental.Accessors;

import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

@Data
@Accessors(chain = true)
public class DoctorInfo {
    private Long id;
    private String name;
    private Integer appointmentCost;
    private LocalDate startOfCarrier;
    private byte[] picture = readPlaceholderImage();
    private Integer age;
    private String education;

    private byte[] readPlaceholderImage() {
        try(InputStream inputStream = DoctorInfo.class.getResourceAsStream("/META-INF/resources/images/placeholder-image.png")) {
            assert inputStream != null;
            return inputStream.readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getWorkingPeriod() {
        Period period = Period.between(startOfCarrier, LocalDate.now());

        if (period.getYears() == 0 && period.getMonths() == 0) {
            return "Doesn't have working experience.";
        }

        StringBuilder sb = new StringBuilder("Had worked for ");

        switch (period.getYears()) {
            case 0:
                break;
            case 1:
                sb.append(period.getYears()).append(" year");
                break;
            default:
                sb.append(period.getYears()).append(" years");
                break;
        }
        if(period.getYears() != 0 && period.getMonths() != 0) {
            sb.append(" ");
        }
        switch (period.getMonths()) {
            case 0:
                break;
            case 1:
                sb.append(period.getMonths()).append(" month");
                break;
            default:
                sb.append(period.getMonths()).append(" months");
        }
        sb.append(" as dentist.");

        return sb.toString();
    }
}
