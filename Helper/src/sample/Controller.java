package sample;

import connectivity.connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;
import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button home;

    @FXML
    private Button history;

    @FXML
    private Button medicine;

    @FXML
    private Button weight;

    @FXML
    private Button note;

    @FXML
    private Pane pane7;

    @FXML
    private TextField glucose_txt;

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private ComboBox<String> combo2;

    @FXML
    private Button Glucose_submit;

    @FXML
    private Pane pane6;

    @FXML
    private TextField blood_txt2;

    @FXML
    private TextField Blood_txt1;

    @FXML
    private TextField heart_txt;

    @FXML
    private Button blood_submit;

    @FXML
    private DatePicker blood_date;

    @FXML
    private DatePicker glucose_date;

    @FXML
    private Pane pane5;

    @FXML
    private TextArea note_txt;

    @FXML
    private Pane pane4;

    @FXML
    private TextField weight_txt;

    @FXML
    private DatePicker weight_date;

    @FXML
    private Pane pane3;

    @FXML
    private Button medicine_save;

    @FXML
    private TextArea medicine_txt;

    @FXML
    private AnchorPane pane2;

    @FXML
    private Pane pane2_5;

    @FXML
    private TableView<MedicineModel> medicine_table;

    @FXML
    private TableColumn<MedicineModel, String> MedicineHistory;

    @FXML
    private Button prev4;

    @FXML
    private Pane pane2_4;

    @FXML
    private TableView<NotesModel> notes_table;

    @FXML
    private TableColumn<NotesModel, String> NotesHistory;

    @FXML
    private Button next4;

    @FXML
    private Button prev3;

    @FXML
    private Pane pane2_3;

    @FXML
    private TableView<WeightModel> weight_table;

    @FXML
    private TableColumn<WeightModel, Integer> weight_id;

    @FXML
    private TableColumn<WeightModel, Integer> WeightHistory;

    @FXML
    private TableColumn<WeightModel, String> weight_date_col;

    @FXML
    private TextField WeightSearch_txt;

    @FXML
    private Button prev2;

    @FXML
    private Button next3;

    @FXML
    private Pane pane2_2;

    @FXML
    private TableView<GlucoseModel> glucose_table;

    @FXML
    private TableColumn<GlucoseModel, Integer> glucose_id;

    @FXML
    private TableColumn<GlucoseModel, Integer> value;

    @FXML
    private TableColumn<GlucoseModel, String> meal;

    @FXML
    private TableColumn<GlucoseModel, String> period;

    @FXML
    private TableColumn<GlucoseModel, String> glucose_date_col;

    @FXML
    private TextField GlucoseSearch_txt;

    @FXML
    private Button next2;

    @FXML
    private Button prev1;

    @FXML
    private Pane pane2_1;

    @FXML
    private TableView<PressureModel> pressure_table;

    @FXML
    private TableColumn<PressureModel, Integer> pressure_id;

    @FXML
    private TableColumn<PressureModel, Integer> systolic;

    @FXML
    private TableColumn<PressureModel, Integer> diastolic;

    @FXML
    private TableColumn<PressureModel, Integer> HeartRate;

    @FXML
    private TableColumn<PressureModel, String> pressure_date_col;

    @FXML
    private TextField PressureSearch_txt;

    @FXML
    private Button next1;

    @FXML
    private Pane pane1;

    @FXML
    private Button blood;

    @FXML
    private Button glucose;

    int index = -1;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    //---------------------------to take list from DB model---------------------------------------//

    ObservableList<PressureModel> PressureList;
    ObservableList<GlucoseModel> GlucoseList;
    ObservableList<WeightModel> WeightList;
    ObservableList<MedicineModel> MedicineList;
    ObservableList<NotesModel> NotesList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list1 = FXCollections.observableArrayList("Breakfast", "Lunch", "Dinner");
        ObservableList<String> list2 = FXCollections.observableArrayList("After", "Before");
        combo1.setItems(list1);
        combo2.setItems(list2);

        //-------------------------------------------------Refresh Data from DB----------------------------------//
        refreshPresserTable();
        PressureSearch();
        refreshGlucoseTable();
        GlucoseSearch();
        refreshWeightTable();
        WeightSearch();
        refreshMedicineTable();
        refreshNotesTable();
        //----------------------------------------- update Pressure table----------------------------------------//

        pressure_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        systolic.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter()));
        diastolic.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        HeartRate.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        pressure_date_col.setCellFactory(TextFieldTableCell.forTableColumn());

        //----------------------------------------- update Pressure table----------------------------------------//

        glucose_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        value.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter()));
        meal.setCellFactory(TextFieldTableCell.forTableColumn());
        period.setCellFactory(TextFieldTableCell.forTableColumn());
        glucose_date_col.setCellFactory(TextFieldTableCell.forTableColumn());

        //----------------------------------------- update Glucose table----------------------------------------//

        weight_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        WeightHistory.setCellFactory(TextFieldTableCell.forTableColumn( new IntegerStringConverter()));
        weight_date_col.setCellFactory(TextFieldTableCell.forTableColumn());

        //----------------------------------------- update Medicine table----------------------------------------//

        MedicineHistory.setCellFactory(TextFieldTableCell.forTableColumn());

        //----------------------------------------- update Notes table----------------------------------------//

        NotesHistory.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    void click(ActionEvent event) throws SQLException {
        if (event.getSource() == home) {
            pane1.toFront();
        } else if (event.getSource() == history) {
            pane2.toFront();
        } else if (event.getSource() == next1) {
            pane2_2.toFront();
        } else if (event.getSource() == next2) {
            pane2_3.toFront();
        } else if (event.getSource() == prev1) {
            pane2_1.toFront();
        } else if (event.getSource() == prev2) {
            pane2_2.toFront();
        } else if (event.getSource() == next3) {
            pane2_4.toFront();
        } else if (event.getSource() == next4) {
            pane2_5.toFront();
        } else if (event.getSource() == prev3) {
            pane2_3.toFront();
        } else if (event.getSource() == prev4) {
            pane2_4.toFront();
        } else if (event.getSource() == medicine) {
            pane3.toFront();
        } else if (event.getSource() == weight) {
            pane4.toFront();
        } else if (event.getSource() == note) {
            pane5.toFront();
        } else if (event.getSource() == blood) {
            pane6.toFront();
        } else if (event.getSource() == glucose) {
            pane7.toFront();
        }
    }


    @FXML
    void SubmitPressureData(ActionEvent event) throws SQLException {
        if (event.getSource() == blood_submit) {
            con = connection.GetConnection();
            try {
                String sql = "insert into pressure ( `Systolic`, `Diastolic`, `Heart Rate`, `Date`) values ('" + Integer.parseInt(Blood_txt1.getText())
                        + "','" + Integer.parseInt(blood_txt2.getText()) + "','" + Integer.parseInt(heart_txt.getText()) + "','" + blood_date.getValue() + "')";
                pst = con.prepareStatement(sql);
                pst.execute(sql);
                JOptionPane.showMessageDialog(null, "Done");
                Blood_txt1.clear();
                blood_txt2.clear();
                heart_txt.clear();
                blood_date.setValue(null);
                refreshPresserTable();
                PressureSearch();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @FXML
    void SubmitGlucoseData(ActionEvent event) throws SQLException {
        if (event.getSource() == Glucose_submit) {
            con = connection.GetConnection();
            try {
                String sql = "insert into diabetes (`Glucose Value`, `The Meal`, `Period`, `Date`) values ('" + Integer.parseInt(glucose_txt.getText())
                        + "','" + combo1.getValue() + "','" + combo2.getValue() + "','" + glucose_date.getValue() + "')";
                pst = con.prepareStatement(sql);
                pst.execute(sql);
                JOptionPane.showMessageDialog(null, "Done");
                glucose_txt.clear();
                combo1.setValue(null);
                combo2.setValue(null);
                glucose_date.setValue(null);
                refreshGlucoseTable();
                GlucoseSearch();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    @FXML
    void SubmitWeightData(ActionEvent event) {
        con = connection.GetConnection();
        try {
            String sql = "insert into weight ( `Weight`, `Date`)values('" + Integer.parseInt(weight_txt.getText())
                    + "','" + weight_date.getValue() + "')";
            pst = con.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, "Done");
            weight_txt.clear();
            weight_date.setValue(null);
            refreshWeightTable();
            GlucoseSearch();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @FXML
    void SaveMedicine(ActionEvent event) {
        con = connection.GetConnection();
        try {
            String sql = "insert into medicine ( `Medicine`)values('" + medicine_txt.getText() + "')";
            pst = con.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, "Done");
            medicine_txt.clear();
            refreshMedicineTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @FXML
    void SaveNotes(ActionEvent event) {
        con = connection.GetConnection();
        try {
            String sql = "insert into notes ( `Notes`)values('" + note_txt.getText() + "')";
            pst = con.prepareStatement(sql);
            pst.execute(sql);
            JOptionPane.showMessageDialog(null, "Done");
            note_txt.clear();
            refreshNotesTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @FXML
    void pressure_Delete(ActionEvent event) {
        con = connection.GetConnection();
        index = pressure_table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String sql = "delete from pressure where ID = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(pressure_id.getCellData(index)));
            pst.execute();
            refreshPresserTable();
            PressureSearch();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @FXML
    void glucose_Delete(ActionEvent event) {
        con = connection.GetConnection();
        index = glucose_table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String sql = "delete from diabetes where ID = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(glucose_id.getCellData(index)));
            pst.execute();
            refreshGlucoseTable();
            GlucoseSearch();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @FXML
    void weight_Delete(ActionEvent event) {
        con = connection.GetConnection();
        index = weight_table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String sql = "delete from weight where ID = ?";
       try{
           pst = con.prepareStatement(sql);
           pst.setString(1, String.valueOf(weight_id.getCellData(index)));
           pst.execute();
          refreshWeightTable();
          WeightSearch();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
       }
    }

    @FXML
    void notes_Delete(ActionEvent event) {
        con = connection.GetConnection();
        index = notes_table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String sql = "delete from notes where Notes = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(NotesHistory.getCellData(index)));
            pst.execute();
            refreshNotesTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @FXML
    void medicine_Delete(ActionEvent event) {
        con = connection.GetConnection();
        index = medicine_table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        String sql = "delete from medicine where medicine = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(MedicineHistory.getCellData(index)));
            pst.execute();
            refreshMedicineTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void refreshPresserTable() {
        pressure_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        systolic.setCellValueFactory(new PropertyValueFactory<>("Systolic"));
        diastolic.setCellValueFactory(new PropertyValueFactory<>("Diastolic"));
        HeartRate.setCellValueFactory(new PropertyValueFactory<>("HeartRate"));
        pressure_date_col.setCellValueFactory(new PropertyValueFactory<>("Date"));
        PressureList = connection.GetPressureData();
        pressure_table.setItems(PressureList);
    }

    public void refreshGlucoseTable() {
        glucose_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        value.setCellValueFactory(new PropertyValueFactory<>("Value"));
        meal.setCellValueFactory(new PropertyValueFactory<>("Meal"));
        period.setCellValueFactory(new PropertyValueFactory<>("Period"));
        glucose_date_col.setCellValueFactory(new PropertyValueFactory<>("Date"));
        GlucoseList = connection.GetGlucoseData();
        glucose_table.setItems(GlucoseList);
    }

    public void refreshWeightTable() {
        weight_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        WeightHistory.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        weight_date_col.setCellValueFactory(new PropertyValueFactory<>("Date"));
        WeightList = connection.GetWeightData();
        weight_table.setItems(WeightList);
    }

    public void refreshMedicineTable() {
        MedicineHistory.setCellValueFactory(new PropertyValueFactory<>("Medicine"));
        MedicineList = connection.GetMedicineData();
        medicine_table.setItems(MedicineList);
    }

    public void refreshNotesTable() {
        NotesHistory.setCellValueFactory(new PropertyValueFactory<>("Note"));
        NotesList = connection.GetNotesData();
        notes_table.setItems(NotesList);
    }

    public static class GlucoseModel {
        String Period, Date, Meal;
        int ID, Value;

        public GlucoseModel(int id, int glucose_value, String the_meal, String period, String date) {
            ID = id;
            Value = glucose_value;
            Meal = the_meal;
            Period = period;
            Date = date;
        }

        public String getPeriod() {
            return Period;
        }

        public void setPeriod(String period) {
            Period = period;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }

        public String getMeal() {
            return Meal;
        }

        public void setMeal(String meal) {
            Meal = meal;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getValue() {
            return Value;
        }

        public void setValue(int value) {
            Value = value;
        }
    }

    public static class MedicineModel {
        String Medicine;

        public MedicineModel(String medicine) {
            this.Medicine = medicine;
        }

        public String getMedicine() {
            return Medicine;
        }

        public void setMedicine(String medicine) {
            this.Medicine = medicine;
        }
    }

    public static class NotesModel {

        String Note;

        public NotesModel(String note) {
            this.Note = note;
        }

        public void setNote(String note) {
            this.Note = note;
        }

        public String getNote() {
            return Note;
        }
    }

    public static class PressureModel {
        String Date;
        int ID, Systolic, Diastolic, HeartRate;

        public PressureModel(int id, int systolic, int diastolic, int heart_rate, String date) {
            ID = id;
            Systolic = systolic;
            Diastolic = diastolic;
            HeartRate = heart_rate;
            Date = date;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getSystolic() {
            return Systolic;
        }

        public void setSystolic(int systolic) {
            Systolic = systolic;
        }

        public int getDiastolic() {
            return Diastolic;
        }

        public void setDiastolic(int diastolic) {
            Diastolic = diastolic;
        }

        public int getHeartRate() {
            return HeartRate;
        }

        public void setHeartRate(int heartRate) {
            HeartRate = heartRate;
        }
    }

    public static class WeightModel {
        int ID, Weight;
        String Date;

        public WeightModel(int id, int weight, String date) {
            ID = id;
            Weight = weight;
            Date = date;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public int getWeight() {
            return Weight;
        }

        public void setWeight(int weight) {
            Weight = weight;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }

    }

    void PressureSearch(){
       pressure_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
       systolic.setCellValueFactory(new PropertyValueFactory<>("Systolic"));
       diastolic.setCellValueFactory(new PropertyValueFactory<>("Diastolic"));
       HeartRate.setCellValueFactory(new PropertyValueFactory<>("HeartRate"));
       pressure_date_col.setCellValueFactory(new PropertyValueFactory<>("Date"));
       PressureList = connection.GetPressureData();
       pressure_table.setItems(PressureList);

       // Wrap the ObservableList in a FilteredList (initially display all data).

       FilteredList<PressureModel>filteredData = new FilteredList<>(PressureList,b -> true);

       // Set the filter Predicate whenever the filter changes.

       PressureSearch_txt.textProperty().addListener((observable,oldValue,newValue) -> {
         filteredData.setPredicate(Pressure -> {
             if(newValue == null || newValue.isEmpty()){
             return true;
             }

             // Compare Date of every record with filter text

             String DateFilter = newValue.toLowerCase();

             if (Pressure.getDate().toLowerCase()
                     .contains(DateFilter)) {
                 return true; // Filter matches Date.
             }
             return false; // Does not match.
         });
       });
       SortedList<PressureModel>sortedData = new SortedList<>(filteredData);
       sortedData.comparatorProperty().bind(pressure_table.comparatorProperty());
       pressure_table.setItems(sortedData);
   }

    void GlucoseSearch(){
        glucose_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        value.setCellValueFactory(new PropertyValueFactory<>("Value"));
        meal.setCellValueFactory(new PropertyValueFactory<>("Meal"));
        period.setCellValueFactory(new PropertyValueFactory<>("Period"));
        glucose_date_col.setCellValueFactory(new PropertyValueFactory<>("Date"));
        GlucoseList = connection.GetGlucoseData();
        glucose_table.setItems(GlucoseList);

        // Wrap the ObservableList in a FilteredList (initially display all data).

        FilteredList<GlucoseModel>filteredData = new FilteredList<>(GlucoseList,b -> true);

        // Set the filter Predicate whenever the filter changes.

        GlucoseSearch_txt.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredData.setPredicate(Glucose -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                // Compare Date of every record with filter text

                String DateFilter = newValue.toLowerCase();

                if (Glucose.getDate().toLowerCase()
                        .contains(DateFilter)) {
                    return true; // Filter matches Date.
                }
                return false; // Does not match.
            });
        });
        SortedList<GlucoseModel>sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(glucose_table.comparatorProperty());
        glucose_table.setItems(sortedData);
    }

    void WeightSearch(){
        weight_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        WeightHistory.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        weight_date_col.setCellValueFactory(new PropertyValueFactory<>("Date"));
        WeightList = connection.GetWeightData();
        weight_table.setItems(WeightList);

        // Wrap the ObservableList in a FilteredList (initially display all data).

        FilteredList<WeightModel>filteredData = new FilteredList<>(WeightList,b -> true);

        // Set the filter Predicate whenever the filter changes.

        WeightSearch_txt.textProperty().addListener((observable,oldValue,newValue) -> {
            filteredData.setPredicate(Weight -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                // Compare Date of every record with filter text

                String DateFilter = newValue.toLowerCase();

                if (Weight.getDate().toLowerCase()
                        .contains(DateFilter)) {
                    return true; // Filter matches Date.
                }
                return false; // Does not match.
            });
        });
        SortedList<WeightModel>sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(weight_table.comparatorProperty());
        weight_table.setItems(sortedData);
    }
}

