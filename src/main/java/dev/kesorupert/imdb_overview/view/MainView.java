package dev.kesorupert.imdb_overview.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import dev.kesorupert.imdb_overview.model.Episode;
import dev.kesorupert.imdb_overview.model.Series;
import dev.kesorupert.imdb_overview.service.SeriesRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    private final SeriesRetrievalService seriesRetrievalService;

    private TextField searchField;
    private Button searchButton;
    private Div seriesInfo;
    private Grid<Episode> ratingsGrid;
    private Div colorLegend;

    private Series series;

    public MainView(@Autowired SeriesRetrievalService service) {

        this.seriesRetrievalService = service;

        createSearchBar();
        createSeriesInfo();
        createRatingsGrid();
        createColorLegend();

        // Use custom CSS classes to apply styling. This is defined in
        // styles.css.
        addClassName("centered-content");

        add(
                new HorizontalLayout(searchField, searchButton),
                new HorizontalLayout(seriesInfo, ratingsGrid, colorLegend)
        );
    }

    private void createSearchBar() {
        searchField = new TextField();
        searchField.setPlaceholder("Search for a series");
        searchField.setClearButtonVisible(true);

        searchButton = new Button("Search", e -> performSearch());
//        searchButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        searchButton.addClickShortcut(Key.ENTER);
    }

    private void performSearch() {
        String searchTerm = searchField.getValue();

        series = seriesRetrievalService.searchForSeries(searchTerm);
    }

    private void createSeriesInfo() {
        seriesInfo = new Div();
        seriesInfo.addClassName("series-info");
        seriesInfo.setWidth("300px"); // We can also set the width in styles.css with above classname?
    }

    private void createRatingsGrid() {
        ratingsGrid = new Grid<>();
        ratingsGrid.addClassName("ratings-grid");
        ratingsGrid.setVisible(false);
    }

    private void createColorLegend() {
        colorLegend = new Div();
        colorLegend.addClassName("color-legend");
        colorLegend.setVisible(false); // Set true when ratingsgrid is also visible

        Span lowSpan = new Span("Low");
        lowSpan.getElement().getStyle().set("color","red");
        Span mediumSpan = new Span("Medium");
        mediumSpan.getElement().getStyle().set("color","yellow");
        Span highSpan = new Span("High");
        highSpan.getElement().getStyle().set("color","green");

        colorLegend.add(lowSpan, mediumSpan, highSpan);
    }

}
