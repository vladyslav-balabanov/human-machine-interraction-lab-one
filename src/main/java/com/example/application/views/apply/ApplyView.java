package com.example.application.views.apply;

import com.example.application.models.DoctorInfo;
import com.example.application.views.AppLayoutTemplateView;
import com.example.application.views.appointmentDetails.AppointmentDetailsView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@PageTitle("Apply form")
@Route(value = "apply", layout = AppLayoutTemplateView.class)
public class ApplyView extends AppLayout {
    private final FlexLayout doctorGrid = new FlexLayout();
    public ApplyView() {
        VerticalLayout content = new VerticalLayout();
        Span title = new Span("Chose doctor with whom you are going to make an appointment");

        content.add(title, createContent());

        setContent(content);
    }
    private FlexLayout createContent() {
        doctorGrid.setWidthFull();
        doctorGrid.setFlexWrap(FlexLayout.FlexWrap.WRAP);

        doctorGrid.add(
                mockDoctorInfo().stream()
                        .sorted(Comparator.comparingInt(DoctorInfo::getAppointmentCost))
                        .map(DoctorItem::new)
                        .peek(d -> d.addSingleClickListener(l -> {
                            doctorGrid.getChildren().forEach(c -> c.getStyle().set("background-color", "white"));
                            d.getStyle().set("background-color", "#00ffff");
                        }))
                        .collect(Collectors.toList())
        );

        return doctorGrid;
    }

    @Getter
    public static class DoctorItem extends VerticalLayout {
        private final DoctorInfo doctorInfo;
        private final Image image;
        private final Span doctorName = new Span();
        private final Span doctorExp = new Span();
        private final Span doctorCost = new Span();

        public DoctorItem(DoctorInfo info) {
            this.doctorInfo = info;
            setAlignItems(Alignment.CENTER);
            Period workPeriod = Period.between(doctorInfo.getStartOfCarrier(), LocalDate.now());

            image = new Image("images/placeholder-image.png", "Doctor's photo");
            doctorName.setText(doctorInfo.getName());
            doctorExp.setText(doctorInfo.getWorkingPeriod());
            doctorCost.setText(String.format("Appointment cost: %d", doctorInfo.getAppointmentCost()));


            //TODO: implement
            addDoubleClickListener(l -> getUI().get().navigate(AppointmentDetailsView.class, doctorInfo.getId()));

            setMaxWidth("240px");
            getStyle().setMargin("18px").setBorder("2px solid black");

            add(image, doctorName, doctorExp, doctorCost);
//            add(new Span("Doctor id: " + doctorInfo.getId()));
        }
    }

    public static List<DoctorInfo> mockDoctorInfo() {
        return List.of(
                new DoctorInfo()
                        .setId(1L)
                        .setName("Alan Walker")
                        .setStartOfCarrier(LocalDate.of(2022, 11, 17))
                        .setAppointmentCost(350),
                new DoctorInfo()
                        .setId(2L)
                        .setName("Goncharova Darina")
                        .setStartOfCarrier(LocalDate.now())
                        .setAppointmentCost(50),
                new DoctorInfo()
                        .setId(3L)
                        .setName("Arhipenko Sofiya")
                        .setStartOfCarrier(LocalDate.of(2004, 11, 13))
                        .setAppointmentCost(250),
                new DoctorInfo()
                        .setId(4L)
                        .setName("John Bigen")
                        .setStartOfCarrier(LocalDate.of(2014, 10, 18))
                        .setAppointmentCost(220),
                new DoctorInfo()
                        .setId(5L)
                        .setName("Saint Peter")
                        .setStartOfCarrier(LocalDate.of(230, 3, 9))
                        .setAppointmentCost(12250),
                new DoctorInfo()
                        .setId(6L)
                        .setName("Jesus Anti-Christ")
                        .setStartOfCarrier(LocalDate.of(1939, 1, 1))
                        .setAppointmentCost(9250),
                new DoctorInfo()
                        .setId(7L)
                        .setName("Snoop Cat")
                        .setStartOfCarrier(LocalDate.of(2020, 2, 7))
                        .setAppointmentCost(3250),
                new DoctorInfo()
                        .setId(8L)
                        .setName("Ivan Ivanov")
                        .setStartOfCarrier(LocalDate.of(1998, 7, 19))
                        .setAppointmentCost(100),
                new DoctorInfo()
                        .setId(9L)
                        .setName("Jester Jefferson")
                        .setStartOfCarrier(LocalDate.of(1999, 9, 9))
                        .setAppointmentCost(1),
                new DoctorInfo()
                        .setId(10L)
                        .setName("Adolf Himtler")
                        .setStartOfCarrier(LocalDate.of(1945, 5, 9))
                        .setAppointmentCost(0)
        );
    }
}
