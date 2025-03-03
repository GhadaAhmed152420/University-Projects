package connectivity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Controller;
import javax.swing.*;
import java.sql.*;

public class connection {
    Connection con = null;
    public static Connection GetConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/helper", "root", "mysql");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    
    public static ObservableList<Controller.PressureModel> GetPressureData() {
        Connection conn = GetConnection();
        ObservableList<Controller.PressureModel> PressureList = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from pressure");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PressureList.add(new Controller.PressureModel(rs.getInt("ID"),
                        rs.getInt("Systolic"),
                        rs.getInt("Diastolic"),
                        rs.getInt("Heart Rate"),
                        rs.getString("Date")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return PressureList;
    }
    public static ObservableList<Controller.GlucoseModel> GetGlucoseData() {
        Connection conn = GetConnection();
        ObservableList<Controller.GlucoseModel> GlucoseList = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from diabetes");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GlucoseList.add(new Controller.GlucoseModel(rs.getInt("ID"),
                        rs.getInt("Glucose Value"),
                        rs.getString("The Meal"),
                        rs.getString("Period"),
                        rs.getString("Date")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return GlucoseList;
    }
    public static ObservableList<Controller.WeightModel> GetWeightData() {
        Connection conn = GetConnection();
        ObservableList<Controller.WeightModel> WeightList = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from weight");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                WeightList.add(new Controller.WeightModel(rs.getInt("ID"),
                        rs.getInt("Weight"),
                        rs.getString("Date")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return WeightList;
    }
    public static ObservableList<Controller.MedicineModel> GetMedicineData() {
        Connection conn = GetConnection();
        ObservableList<Controller.MedicineModel> MedicineList = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from medicine");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               MedicineList.add(new Controller.MedicineModel(rs.getString("Medicine")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return MedicineList;
    }


    public static ObservableList<Controller.NotesModel> GetNotesData() {
        Connection conn = GetConnection();
        ObservableList<Controller.NotesModel> NotesList = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from notes");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NotesList.add(new Controller.NotesModel(rs.getString("Notes")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return NotesList;
    }
}
