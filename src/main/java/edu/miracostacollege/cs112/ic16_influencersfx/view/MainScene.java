package edu.miracostacollege.cs112.ic16_influencersfx.view;

import edu.miracostacollege.cs112.ic16_influencersfx.controller.Controller;
import edu.miracostacollege.cs112.ic16_influencersfx.model.Influencer;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * The <code>MainScene</code> represents the very first scene for the Influencers application.
 * The <code>MainScene</code> also allows for a user to add a new influencer or remove
 * existing influencers.
 */
public class MainScene extends Scene {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private ImageView influencerIV = new ImageView();
    private ComboBox<String> influencerTypeCB = new ComboBox<>();
    private TextField nameTF = new TextField();
    private Label nameErrLabel = new Label("Name is required.");

    private TextField countryTF = new TextField();
    private Label countryErrLabel = new Label("Country is required.");

    private TextField followersTF = new TextField();
    private Label followersErrLabel = new Label("Followers are required.");

    private TextField worthTF = new TextField();
    private Label worthErrLabel = new Label("Worth is required.");

    private Label sponsorCompanyLabel = new Label("Sponsors:");
    private TextField sponsorCompanyTF = new TextField();
    private Label sponsorCompanyErrLabel = new Label("Sponsor/Company is required.");

    private ListView<Influencer> influencersLV = new ListView<>();

    private Button removeButton = new Button("- Remove Influencer");
    private Button addButton = new Button("+ Add Influencer");

    private Controller controller = Controller.getInstance();
    private ObservableList<Influencer> influencersList;
    private Influencer selectedInfluencer;

    /**
     * Constructs a new <code>MainScene</code>, representing the very first scene for the Influencers application.
     *
     * The <code>MainScene</code> also allows for a user to add a new influencer or remove an existing influencer.
     */
    public MainScene() {
        super(new GridPane(), WIDTH, HEIGHT);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        // TODO: Create a folder named res (short for resources)
        // TODO: Place the influencers.png file in this folder
        // TODO: Go to File->Project Structure and designate res as a "resource directory"
        // TODO: Now, set the image of the influencer image view to influencers.png
        // TODO: Finally, set the fit width of the image view to match the width of the scene


        pane.add(influencerIV, 0, 0, 3, 1);

        // TODO: Add the Celebrity and CEO items to the influencer type combo box
        // TODO: Then add a listener on the selectedItemProperty
        // TODO: If the user selects Celebrity, change the text of the sponsorCompanyLabel to "Sponsors:"
        // TODO: Otherwise, change the text to "Company:"
        // TODO: Finally, select "Celebrity" by default

        pane.add(new Label("Influencer Type:"), 0, 1);
        pane.add(influencerTypeCB, 1, 1);

        pane.add(new Label("Name:"), 0, 2);
        pane.add(nameTF, 1, 2);
        pane.add(nameErrLabel, 2, 2);
        nameErrLabel.setTextFill(Color.RED);
        nameErrLabel.setVisible(false);

        pane.add(new Label("Country:"), 0, 3);
        pane.add(countryTF, 1, 3);
        pane.add(countryErrLabel, 2, 3);
        countryErrLabel.setTextFill(Color.RED);
        countryErrLabel.setVisible(false);

        pane.add(new Label("# of Followers:"), 0, 4);
        pane.add(followersTF, 1, 4);
        pane.add(followersErrLabel, 2, 4);
        followersErrLabel.setTextFill(Color.RED);
        followersErrLabel.setVisible(false);

        pane.add(new Label("Worth $"), 0, 5);
        pane.add(worthTF, 1, 5);
        pane.add(worthErrLabel, 2, 5);
        worthErrLabel.setTextFill(Color.RED);
        worthErrLabel.setVisible(false);

        pane.add(sponsorCompanyLabel, 0, 6);
        pane.add(sponsorCompanyTF, 1, 6);
        pane.add(sponsorCompanyErrLabel, 2, 6);
        sponsorCompanyErrLabel.setTextFill(Color.RED);
        sponsorCompanyErrLabel.setVisible(false);

        pane.add(addButton, 1, 7);
        influencersLV.setPrefWidth(WIDTH);
        pane.add(influencersLV, 0, 8, 3, 1);
        pane.add(removeButton, 0, 9);

        // TODO: Uncomment after adding completing the Controller class
        //influencersList = controller.getAllInfluencers();
        influencersLV.setItems(influencersList);
        // TODO: For the influencers list view, add a listener when the selected item changes.
        // TODO: In the changed(..) method, assign the selectedInfluencer to the new value
        // TODO: Disable/enable the removeButton according to whether the selectedInfluencer is null


        removeButton.setDisable(true);
        removeButton.setOnAction(event -> removeInfluencer());
        addButton.setOnAction(event -> addInfluencer());

        this.setRoot(pane);
    }

    /**
     * Allows the user to remove an existing influencer.
     * However, if the selected influencer is null, just return (do nothing)
     * Make sure to update the display after removing the influencer.
     */
    private void removeInfluencer() {
        //TODO: If the selected influencer is null, return
        //TODO: Otherwise, remove the selected influencer from the list
        //TODO: Update the display when done

        updateDisplay();
    }

    /**
     * Allows the user to add a new influencer.
     * Make sure to update the display after adding the new influencer.
     */
    private void addInfluencer() {
        String name, country, sponsorCompany;
        int followers=0;
        double worth=0.0;
        
        name = nameTF.getText();
        nameErrLabel.setVisible(name.isEmpty());
        
        country = countryTF.getText();
        countryErrLabel.setVisible(country.isEmpty());

        try {
            followers = Integer.parseInt(followersTF.getText());
            if (followers < 0) followersErrLabel.setVisible(true);
        } catch (NumberFormatException e ) { followersErrLabel.setVisible(true); }

        try {
            worth = Double.parseDouble(worthTF.getText());
            if (worth < 0.0) worthErrLabel.setVisible(true);
        } catch (NumberFormatException e ) { worthErrLabel.setVisible(true); }

        sponsorCompany = sponsorCompanyTF.getText();
        sponsorCompanyErrLabel.setVisible(sponsorCompany.isEmpty());

        if (nameErrLabel.isVisible() || countryErrLabel.isVisible() || followersErrLabel.isVisible() ||
        worthErrLabel.isVisible() || sponsorCompanyErrLabel.isVisible())
            return;

        // TODO: If the selected item in the influencer type combo box is "Celebrity"
        // TODO: Instantiate new Celebrity object and add it to the list of influencers
        // TODO: Otherwise, instantiate new CEO object and add it to the list of influencers


        updateDisplay();
    }

    /**
     * Updates the display after adding/removing an influencer.
     * The list view should refresh to show the new/modified influencer.
     */
    private void updateDisplay()
    {
        influencersLV.refresh();
    }

}
