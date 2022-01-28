package com.example.friendbookver1;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    public TextField textGetName;
    public TextField textGetAge;
    public TextField fileNamer;
    public ListView friendList = new ListView<Friend>();
    public Label namef;
    public Label agef;

    private boolean modified = false;


    public void makeFriend(ActionEvent actionEvent) {

        Friend friend = new Friend(textGetName.getText(), Integer.parseInt(textGetAge.getText()));

        friendList.getItems().add(friend);
        textGetAge.clear();
        textGetName.clear();

        modified = true;


    }


    public void displayFriend(MouseEvent mouseEvent) {
        Friend friend;
        friend = (Friend) friendList.getSelectionModel().getSelectedItem();
        namef.setText(friend.getName());
        agef.setText(String.valueOf(friend.getAge()));

    }

    public void killFriend(ActionEvent actionEvent) {
        Friend friend;
        friend = (Friend) friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(friend);

        modified = true;

    }


    public void save(ActionEvent actionEvent) throws IOException {
        ObservableList<Friend> temp = friendList.getItems();

        for(Friend f : temp){
            f.writeToFile(fileNamer.getText());
        }
        friendList.getItems().clear();




    }


    public void load(ActionEvent actionEvent) throws IOException {

        modified = false;

        friendList.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createAllFriends(fileNamer.getText());
        for(Friend f : friends){
            friendList.getItems().add(f);
        }




    }
}