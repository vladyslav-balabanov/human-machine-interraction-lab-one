package com.example.application.views.main;

import com.example.application.views.AppLayoutTemplateView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Main")
@Route(value = "main", layout = AppLayoutTemplateView.class)
@RouteAlias(value = "", layout = AppLayoutTemplateView.class)
public class MainView extends AppLayout {
    private VerticalLayout welcome;
    private VerticalLayout history;
    private VerticalLayout contacts;
    public MainView() {
        setContent(new VerticalLayout(createWelcome(), createHistory(), createContacts()));
    }

    private VerticalLayout createContacts() {
        contacts = new VerticalLayout();

        H2 title = new H2("How to Find Us?");
        Paragraph text1 = new Paragraph("The dental clinic \"Smile for Health\" is conveniently " +
                "located, ensuring easy access for all our patients. We are situated at [адрес]. " +
                "You can use public transportation or your own vehicle to reach us without any hassle.\n");
        Paragraph text2 = new Paragraph("If you have any questions or need additional information, our " +
                "friendly staff is ready to assist you. You can contact us by phone at [номер телефона] or " +
                "via email at [эл.почта].\n");
        Paragraph text3 = new Paragraph("We invite you to become a part of the \"Smile for Health\" family " +
                "and entrust us with the care of your dental health. Our team of dentists and specialists will " +
                "do everything possible to ensure you have a healthy and beautiful smile. Thank you for your trust!");

        contacts.add(title, text1, text2, text3);
        return contacts;
    }

    private VerticalLayout createHistory() {
        history = new VerticalLayout();

        H2 title = new H2("History of \"Smile for Health\"");
        Paragraph text = new Paragraph("Since our opening, we have been dedicated to " +
                "the mission of creating healthy and beautiful smiles. Over the years, we have " +
                "strived for excellence in the field of dentistry, developing our own treatment " +
                "methods and training our team in the most advanced technologies. We are proud that " +
                "every one of our patients can count on first-class treatment, personal attention, " +
                "and care for their dental health.\n");

        history.add(title, text);
        return history;
    }

    private VerticalLayout createWelcome() {
        welcome = new VerticalLayout();

        H2 title = new H2("Dental Clinic \"Smile for Health\": Your Path to a Healthy Smile!");
        Paragraph text = new Paragraph("Welcome to the unique dental clinic \"Smile for Health\"! " +
                "We take pride in our history, providing high-quality dental " +
                "services and caring for your smile. Our clinic is a place where " +
                "your dental health needs always come first, and we are happy to share " +
                "our history and information on how to reach us with you.\n");

        welcome.add(title, text);
        return welcome;
    }
}
