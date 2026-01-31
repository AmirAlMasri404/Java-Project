package com.example.amir;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Date;


public class UserInterface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            ArrayList<Visit> visits = new ArrayList<>();
            ArrayList<Patient> patients = new ArrayList<>();
            ArrayList<Clinic> clinics = new ArrayList<>();
            StackPane prog = new StackPane();
            Pane visitUI = VisitUI(prog, visits,clinics);
            Pane clinicUI = ClinicUI(prog,clinics);
            Pane patientUI = PatientUI(prog,patients);
            Pane homeUI = HomeUI(prog,primaryStage);
            prog.getChildren().addAll(homeUI,patientUI,clinicUI,visitUI);
            homeUI.setVisible(true);
            patientUI.setVisible(false);
            clinicUI.setVisible(false);
            visitUI.setVisible(false);
            DarkTheme(prog);
            Scene home = new Scene(prog, 500, 500);
            primaryStage.setTitle("Medical System");
            primaryStage.setScene(home);
            primaryStage.show();
        }
        catch (Exception e) {
            alert(e.getMessage());
        }

    }
    public void DarkTheme(Pane prog){
        prog.setStyle(
                "-fx-background-color: #2b2b2b;" +
                        "-fx-padding: 15;"
        );
    }
    public void ScreenTh(TextArea screen){
        screen.setStyle(
                "-fx-control-inner-background: #2b2b2b;" +
                        "-fx-background-color: #2b2b2b;" +
                        "-fx-text-fill: #e0e0e0;" +
                        "-fx-prompt-text-fill: #888888;" +
                        "-fx-highlight-fill: #555555;" +
                        "-fx-highlight-text-fill: white;" +
                        "-fx-caret-color: white;"   +
                        "-fx-border-color: #222222;" +
                        "-fx-border-width: 1;"
        );
    }
    public Pane HomeUI(Pane prog,Stage primaryStage){

        // Main BorderPane
        BorderPane bph = new BorderPane();
        GridPane gpP = new GridPane();
        GridPane gpC = new GridPane();
        VBox lay = new VBox(12);
        VBox bot = new VBox(4);
        gpP.setVgap(12);
        gpP.setHgap(12);
        gpC.setVgap(12);
        gpC.setHgap(12);

        Rectangle r = new Rectangle(500,20);
        r.setFill(Color.SILVER);
        r.setStroke(null);

        // HBoxes for radio buttons
        HBox hb0 = new HBox(10);
        HBox hb1 = new HBox(10);
        HBox bottom = new HBox(10);
        // Screen
        TextArea screen = new TextArea();
        screen.setEditable(false);
        bph.setTop(screen);
        ScreenTh(screen);

        // Labels
        Label patStatus = new Label("Patient Status:");
        Label ClStatus = new Label("Clinic Status:");
        Label patientName = new Label("Patient Name:");
        Label ClinicName = new Label("Clinic Name:");
        nodesModifications(patStatus,null);
        nodesModifications(ClStatus,null);
        nodesModifications(patientName,null);
        nodesModifications(ClinicName,null);

        // TextFields
        TextField ptName = new TextField();
        TextField CName = new TextField();
        nodesModifications(ptName,"Patient Name:");
        nodesModifications(CName,"Clinic Name:");
        ptName.setEditable(false);
        CName.setEditable(false);

        RadioButton pN = new RadioButton("New");
        RadioButton pE = new RadioButton("Exist");
        RadioButton cN = new RadioButton("New");
        RadioButton cE = new RadioButton("Exist");
        Button pSrc = new Button("Search");
        Button cSrc = new Button("Search");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        nodesModifications(pN,null);
        nodesModifications(pE,null);
        nodesModifications(cN,null);
        nodesModifications(cE,null);
        Ellipse ellipse = new Ellipse(250,10);
        pSrc.setShape(ellipse);
        cSrc.setShape(ellipse);
        reset.setPrefHeight(40);
        reset.setPrefWidth(250);
        exit.setPrefHeight(40);
        exit.setPrefWidth(250);
        pSrc.setPrefWidth(500);
        cSrc.setPrefWidth(500);

        // ToggleGroups
        ToggleGroup ptg = new ToggleGroup();
        ToggleGroup ctg = new ToggleGroup();
        pN.setToggleGroup(ptg);
        pE.setToggleGroup(ptg);
        cN.setToggleGroup(ctg);
        cE.setToggleGroup(ctg);

        // add Components
        hb0.getChildren().addAll(pN, pE);
        hb1.getChildren().addAll(cN, cE);
        bottom.getChildren().addAll(reset,exit);

        gpP.add(patStatus,0,0);
        gpP.add(hb0, 1, 0);
        gpP.add(patientName, 0, 1);
        gpP.add(ptName,1,1);

        gpC.add(ClStatus,0,0);
        gpC.add(hb1, 1, 0);
        gpC.add(ClinicName,0, 1);
        gpC.add(CName,1,1);

        lay.getChildren().addAll(gpP,pSrc,gpC,cSrc);
        gpP.setAlignment(Pos.TOP_LEFT);
        gpC.setAlignment(Pos.TOP_LEFT);
        bottom.setAlignment(Pos.TOP_CENTER);
        bph.setCenter(lay);
        lay.setPadding(new Insets(10,10,10,10));
        bot.getChildren().addAll(r,bottom);
        bph.setBottom(bot);
        screen.setText("""
                ==========================================================
                            Medical Clinic Management System
                ==========================================================
                Welcome
                """);
        screen.setFont(Font.font("Monospaced", 12));
        //Event Handling
        pN.setOnAction(e->{
            bph.setVisible(false);
            prog.getChildren().get(1).setVisible(true);
        });
        cN.setOnAction(e->{
            bph.setVisible(false);
            prog.getChildren().get(2).setVisible(true);
        });
        exit.setOnAction(e->{
            primaryStage.close();
        });
        reset.setOnAction(e->{
            pN.setSelected(false);
            cN.setSelected(false);
            pE.setSelected(false);
            cE.setSelected(false);
            ptName.clear();
            CName.clear();
            ptName.setEditable(false);
            CName.setEditable(false);
        });
        pE.setOnAction(e->{
            ptName.setEditable(true);
        });
        cE.setOnAction(e->{
            CName.setEditable(true);
        });
        return bph;
    }
    public Pane PatientUI(Pane prog,ArrayList<Patient> patients){
        BorderPane patient = new BorderPane();
        patient.setPadding(new Insets(10,10,10,10));
        GridPane gd = new GridPane(9,9);
        HBox ins = new HBox(10);
        HBox g = new HBox(10);
        HBox bot = new HBox(10);
        VBox top = new VBox(10);
        VBox bott = new VBox(10);

        gd.setVgap(12);
        gd.setHgap(12);
        Label patientInfo=new Label("Patient Information");
        headers(patientInfo);
        Rectangle r = new Rectangle(500,20);
        r.setFill(Color.SILVER);
        r.setStroke(null);
        Rectangle r1 = new Rectangle(500,20);
        r1.setFill(Color.SILVER);
        r1.setStroke(null);
        top.getChildren().addAll(patientInfo, r);

        Label ptName = new Label("Patient Name:");
        Label ptID = new Label("National ID");
        Label dOF = new Label("Date Of Birth:");
        Label gender = new Label("Gender:");
        Label phone = new Label("Phone Number:");
        Label city = new Label("City:");
        Label occ = new Label("Occupation:");
        Label bGP = new Label("Blood Group:");
        Label insured = new Label("Insured:");
        nodesModifications(ptName,null);
        nodesModifications(ptID,null);
        nodesModifications(dOF,null);
        nodesModifications(gender,null);
        nodesModifications(phone,null);
        nodesModifications(city,null);
        nodesModifications(occ,null);
        nodesModifications(insured,null);
        nodesModifications(bGP,null);


        TextField name = new TextField();
        TextField id = new TextField();
        TextField ph = new TextField();
        TextField ci = new TextField();
        nodesModifications(name,"Enter Patient Name");
        nodesModifications(id,"Enter Identity or Passport ID");
        nodesModifications(ph,"Enter Phone Number 10 digits starting with 05");
        nodesModifications(ci,"Enter City");

        DatePicker dateOfBirth = new DatePicker();
        dateOfBirth.setPrefWidth(200);
        dateOfBirth.setPromptText(""+new Date());
        RadioButton yes = new RadioButton("Yes");
        RadioButton no = new RadioButton("No");
        ToggleGroup insurance = new ToggleGroup();
        yes.setToggleGroup(insurance);
        no.setToggleGroup(insurance);
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup Gender = new ToggleGroup();
        nodesModifications(yes,null);
        nodesModifications(no,null);
        male.setToggleGroup(Gender);
        female.setToggleGroup(Gender);
        Button save = new Button("Save & Next");
        Button clear = new Button("Clear");
        nodesModifications(save,null);
        nodesModifications(clear,null);
        nodesModifications(male,null);
        nodesModifications(female,null);

        ComboBox<String> bloodGroup = new ComboBox<>();
        bloodGroup.getItems().addAll("O+","O-","A+","A-","B+","B-","AB+","AB-");
        bloodGroup.setPromptText("Choose");
        ComboBox<String>occupation = new ComboBox<>();
        occupation.getItems().addAll("Student","Government Employee","Private Sector Employee","Worker","Not Employed");
        occupation.setPromptText("Choose Occupation");

        ins.getChildren().addAll(yes,no);
        g.getChildren().addAll(male,female);
        gd.addColumn(0,ptName,ptID,dOF,gender,phone,city,occ,bGP,insured);
        gd.addColumn(1,name,id,dateOfBirth,g,ph,ci,occupation,bloodGroup,ins);
        gd.setHgap(15);
        gd.setVgap(15);
        gd.setPadding(new Insets(10,10,10,10));
        bot.getChildren().addAll(save,clear);
        bot.setAlignment(Pos.CENTER);
        bott.getChildren().addAll(r1,bot);
        patient.setCenter(gd);
        patient.setBottom(bott);
        patient.setTop(top);
        top.setAlignment(Pos.CENTER);

        // Event Handling
        clear.setOnAction(e->{
            name.clear();
            id.clear();
            ph.clear();
            ci.clear();
            dateOfBirth.setPromptText(""+new Date());
            Gender.selectToggle(null);
            insurance.selectToggle(null);
            bloodGroup.getSelectionModel().select(2);
            occupation.getSelectionModel().select(1);
            ci.clear();
            ph.clear();
        });
        save.setOnAction(e->{
            String i,gE;
            boolean insure = false;
            Patient p;
           try{
               VerifyText(name,ptName.getText());
               VerifyNumbers(id,ptID.getText());
               VerifyDate(dateOfBirth,dOF.getText());
               VerifyRadio(Gender,gender.getText());
               VerifyText(ci,city.getText());
               VerifyNumbers(ph,phone.getText());
               VerifyRadio(insurance,insured.getText());
               VerifyCombo(occupation,occ.getText());
               VerifyCombo(bloodGroup,bGP.getText());
               Toggle selectedIns =insurance.getSelectedToggle();
               i =((RadioButton) selectedIns).getText();
               if (i.equalsIgnoreCase("Yes")) insure = true;
               Toggle selectedGender = Gender.getSelectedToggle();
                gE=((RadioButton) selectedGender).getText();
               insure = i.equalsIgnoreCase("yes");
               p = new Patient(name.getText(),id.getText(),dateOfBirth.getValue(),gE,ph.getText(),ci.getText(),occupation.getValue(),bloodGroup.getValue(),insure);
               patients.add(p);
               FileManager.Write(p);
               patient.setVisible(false);
               prog.getChildren().getFirst().setVisible(true);
           }
           catch (Exception ex){
                alert(ex.getMessage());
           }
        });
        return patient;
    }
    public Pane ClinicUI(Pane prog,ArrayList<Clinic> clinics){
        BorderPane clinic = new BorderPane();
        clinic.setPadding(new Insets(10,10,10,10));
        GridPane gd = new GridPane();
        gd.setPadding(new Insets(10,10,10,10));
        VBox top = new VBox(10);
        VBox bott = new VBox(10);
        HBox btn = new HBox(10);
        gd.setVgap(12);
        gd.setHgap(12);

        Label clinicInfo=new Label("Clinic Information");
        headers(clinicInfo);
        Label clName = new Label("Clinic Name:");
        Label location = new Label("Clinic Location:");
        Label Telephone = new Label("Telephone:");
        nodesModifications(clName,null);
        nodesModifications(location,null);
        nodesModifications(Telephone,null);


        TextField cl = new TextField();
        TextField loc = new TextField();
        TextField Tel = new TextField();
        nodesModifications(cl,"Enter Clinic Name");
        nodesModifications(loc,"Enter Clinic's Location");
        nodesModifications(Tel,"Enter Telephone 10 digits only");
        loc.setPromptText("Enter Clinic's Location");


        Rectangle r = new Rectangle(500,20);
        r.setFill(Color.SILVER);
        r.setStroke(null);
        Rectangle r1 = new Rectangle(500,20);
        r1.setFill(Color.SILVER);
        r1.setStroke(null);
        Button save = new Button("Save & Next");
        Button clear = new Button("Clear");
        nodesModifications(save,null);
        nodesModifications(clear,null);
        btn.getChildren().addAll(save,clear);
        btn.setAlignment(Pos.CENTER);
        bott.getChildren().addAll(r1,btn);
        gd.addColumn(0, clName,location,Telephone);
        gd.addColumn(1, cl,loc,Tel);
        top.getChildren().addAll(clinicInfo,r);
        top.setAlignment(Pos.TOP_CENTER);

        clinic.setTop(top);
        clinic.setCenter(gd);
        clinic.setBottom(bott);
        // Event Handling
        clear.setOnAction(e->{
            cl.clear();
            loc.clear();
            Tel.clear();

        });
        save.setOnAction(e->{
            String i,gE;
            Clinic c;
            boolean insure = false;
            try{
                VerifyText(cl,clName.getText());
                VerifyText(loc,location.getText());
                VerifyNumbers(Tel,Telephone.getText());
                c = new Clinic(cl.getText(),loc.getText(),Tel.getText());
                clinics.add(c);
                clinic.setVisible(false);
                prog.getChildren().get(3).setVisible(true);
            }
            catch (Exception ex){
                alert(ex.getMessage());
            }
        });
        return clinic;
  }
    public Pane VisitUI(Pane  prog, ArrayList<Visit> visits, ArrayList<Clinic> clinics){
        BorderPane visit = new BorderPane();
        VBox vb = new VBox(10);
        VBox top = new VBox(10);
        GridPane v = new GridPane();
        v.setPadding(new Insets(10,10,10,10));
        v.setVgap(12);
        v.setHgap(12);

        Label visitInfo=new Label("Visit Information");
        headers(visitInfo);
        Rectangle r = new Rectangle(500,20);
        r.setFill(Color.SILVER);
        r.setStroke(null);
        Label sym = new Label("Symptoms:");
        Label Diagnosis = new Label("Diagnosis:");
        Label visDate = new Label("Visit Date:");
        Label t = new Label("Test:");
        Color Dark =new Color(0.1686,0.1686,0.1686,1.0);
        nodesModifications(sym,null);
        nodesModifications(Diagnosis,null);
        nodesModifications(visDate,null);
        nodesModifications(t,null);

        TextArea symptoms = new TextArea();
        symptoms.setPrefHeight(30);
        symptoms.setPrefWidth(250);
        symptoms.setPromptText("Signs & Symptoms");
        TextField dia = new TextField();
        nodesModifications(dia,"Disease/Injury");
        DatePicker d = new DatePicker();
        d.setPromptText(new Date().toString());
        d.setPrefWidth(200);
        ComboBox<String> tests = new ComboBox<>();
        tests.setPrefHeight(20);
        tests.setPrefWidth(250);
        tests.setPromptText("Choose Test");
        tests.getItems().addAll("Blood Test","Alcohol Test","Immunization","Incident");
        v.addColumn(0, sym,visDate,Diagnosis,t);
        v.addColumn(1,symptoms,d,dia,tests);
        top.getChildren().addAll(visitInfo,r);
        visit.setTop(top);
        top.setAlignment(Pos.TOP_CENTER);
        TitledPane Blood = BloodTest(visits,clinics,Dark,Diagnosis,dia,sym,symptoms,visDate,tests);
        Blood.setExpanded(false);
        TitledPane AlcoholTest = AlcoTest(visits,clinics,Dark,Diagnosis,dia,sym,symptoms,visDate,tests);
        AlcoholTest.setExpanded(false);
        TitledPane Immunization = Immunization(visits,clinics,Dark,Diagnosis,dia,sym,symptoms,visDate,tests);
        Immunization.setExpanded(false);
        TitledPane Incident = Incident(visits,clinics,Dark,Diagnosis,dia,sym,symptoms,visDate,tests);
        Incident.setExpanded(false);
        vb.getChildren().addAll(v,Blood,AlcoholTest,Immunization,Incident);
        visit.setCenter(vb);
        Button rtn = new Button("Return Home");
        nodesModifications(rtn,null);
        BorderPane.setAlignment(rtn,Pos.TOP_CENTER);
        visit.setBottom(rtn);
        //Event Handling
        tests.setOnAction(e->{
            if(tests.getValue().equals("Blood Test")){
                Blood.setExpanded(true);
                AlcoholTest.setExpanded(false);
                Immunization.setExpanded(false);
                Incident.setExpanded(false);
            }
            else if(tests.getValue().equals("Alcohol Test")){
                AlcoholTest.setExpanded(true);
                Immunization.setExpanded(false);
                Incident.setExpanded(false);
                Blood.setExpanded(false);
            }
            else if(tests.getValue().equals("Immunization")){
                Immunization.setExpanded(true);
                Blood.setExpanded(false);
                AlcoholTest.setExpanded(false);
                Incident.setExpanded(false);
            }
            else if(tests.getValue().equals("Incident")){
                Incident.setExpanded(true);
                Blood.setExpanded(false);
                AlcoholTest.setExpanded(false);
                Immunization.setExpanded(false);
            }
        });
        rtn.setOnAction(e->{
            dia.clear();
            d.setPromptText(new Date().toString());
            symptoms.clear();
            tests.setPromptText("Choose Test");
            visit.setVisible(false);
            prog.getChildren().getFirst().setVisible(true);

        });
        return visit;
    }
    public TitledPane BloodTest(ArrayList<Visit>visits, ArrayList<Clinic> clinics, Color dark, Label diagnosis, TextField dia, Label sym, TextArea symptoms, Label visDate, ComboBox<String> tests){
        BorderPane blood = new BorderPane();
        GridPane b = new GridPane();
        b.setHgap(12);
        b.setVgap(12);
        b.setPadding(new Insets(10,10,10,10));
        Label rbc = new Label("RBC:");
        Label wbc = new Label("WBC:");
        Label platelets = new Label("Platelets:");
        nodesModifications(rbc,null);
        nodesModifications(wbc,null);
        nodesModifications(platelets,null);

        TextField rb = new TextField();
        TextField wb = new TextField();
        TextField plat = new TextField();
        nodesModifications(rbc,"Red Blood Cells Count in g/dL");
        nodesModifications(wbc,"White Blood Cells Count in µL");
        nodesModifications(platelets,"Platelets Count in µL");

        Button sub = new Button("Submit");
        nodesModifications(sub,null);
        b.addColumn(0,rbc,wbc,platelets);
        b.addColumn(1,rb,wb,plat);
        b.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(sub,Pos.CENTER);
        b.setBackground(new Background(new BackgroundFill(dark,null,null)));
        blood.setCenter(b);
        blood.setBottom(sub);
        blood.setBackground(new Background(new BackgroundFill(dark,null,null)));

        // Event Handling
        sub.setOnAction(e->{
            Visit v;
            try{
                VerifyText(dia,diagnosis.getText());
                VerifyDoubles(rb,rbc.getText());
                VerifyDoubles(wb,wbc.getText());
                VerifyDoubles(plat,platelets.getText());
                v =new BloodTest(symptoms.getText(),dia.getText(),clinics.getLast(),
                        Double.parseDouble(rb.getText()), Double.parseDouble(wb.getText()), Double.parseDouble(plat.getText()));
                visits.add(v);
                FileManager.Write(v);
                dia.clear();
                rb.clear();
                wb.clear();
                plat.clear();
                symptoms.clear();
                tests.setPromptText("Choose Test");
            }
            catch(Exception ex){
                alert(ex.getMessage());
            }
        });
        return new TitledPane("Blood Test",blood);
    }
    public TitledPane AlcoTest(ArrayList<Visit> visits, ArrayList<Clinic> clinics, Color dark, Label diagnosis, TextField dia, Label sym, TextArea symptoms, Label visDate, ComboBox<String> tests){
        BorderPane alco = new BorderPane();
        GridPane a = new GridPane();
        HBox test = new HBox(10);
        a.setHgap(12);
        a.setVgap(12);
        a.setPadding(new Insets(10,10,10,10));
        Label alc = new Label("Alcohol Concentration:");
        Label res = new Label("Test Result:");
        nodesModifications(alc,null);
        nodesModifications(res,null);
        TextField con = new TextField();
        RadioButton pos = new RadioButton("Positive");
        RadioButton neg = new RadioButton("Negative");
        ToggleGroup group = new ToggleGroup();
        pos.setToggleGroup(group);
        neg.setToggleGroup(group);
        nodesModifications(pos,null);
        nodesModifications(neg,null);
        nodesModifications(con,"Alcohol Concentration in millimeter");
        group.selectToggle(neg);
        Button sub = new Button("Submit");
        nodesModifications(sub,null);
        test.getChildren().addAll(pos,neg);
        a.addColumn(0,alc,res);
        a.addColumn(1,con,test);
        a.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(sub,Pos.CENTER);
        a.setBackground(new Background(new BackgroundFill(dark,null,null)));
        alco.setCenter(a);
        alco.setBottom(sub);
        alco.setBackground(new Background(new BackgroundFill(dark,null,null)));
        //Event Handling
        sub.setOnAction(e->{
            String r;
            boolean result = false;
            Visit v;
            try{
                VerifyText(dia,diagnosis.getText());
                VerifyDoubles(con,alc.getText());
                VerifyRadio(group,res.getText());
                Toggle selectedRes =group.getSelectedToggle();
                r =((RadioButton) selectedRes).getText();
                if (r.equalsIgnoreCase("pos")) result = true;
                v = new AlcoholTest(symptoms.getText(),dia.getText(),clinics.getLast(),
                        Double.parseDouble(con.getText()),result);
                visits.add(v);
                FileManager.Write(v);
                dia.clear();
                con.clear();
                group.selectToggle(null);
                symptoms.clear();
                tests.setPromptText("Choose Test");
            }
            catch(Exception ex){
                alert(ex.getMessage());
            }
        });
        return new TitledPane("Alcohol Test",alco);
    }
    public TitledPane Immunization(ArrayList<Visit> visits, ArrayList<Clinic> clinics, Color dark, Label diagnosis, TextField dia, Label sym, TextArea symptoms, Label visDate, ComboBox<String> tests){
        BorderPane immune = new BorderPane();
        GridPane i = new GridPane();
        i.setHgap(12);
        i.setVgap(12);
        i.setPadding(new Insets(10,10,10,10));
        Label vaccineName = new Label("Vaccine Name:");
        Label dos = new Label("Dose:");
        nodesModifications(vaccineName,null);
        nodesModifications(dos,null);
        TextField name = new TextField();
        TextField dose = new TextField();
        nodesModifications(name,"Vaccine Generic Name");
        nodesModifications(dose,"Dose in millimeters");
        Button sub = new Button("Submit");
        nodesModifications(sub,null);
        i.addColumn(0,vaccineName,dos);
        i.addColumn(1,name,dose);
        i.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(sub,Pos.CENTER);
        i.setBackground(new Background(new BackgroundFill(dark,null,null)));
        immune.setCenter(i);
        immune.setBottom(sub);
        immune.setBackground(new Background(new BackgroundFill(dark,null,null)));
        //Event Handling
        sub.setOnAction(e->{
            Visit v;
            try{
                VerifyText(dia,diagnosis.getText());
                VerifyText(name,vaccineName.getText());
                VerifyDoubles(dose,dos.getText());
                v = new Immunization(symptoms.getText(),dia.getText(),clinics.getLast(),name.getText(),Double.parseDouble(dose.getText()));
                visits.add(v);
                FileManager.Write(v);
                dia.clear();
                name.clear();
                dose.clear();
                symptoms.clear();
                tests.setPromptText("Choose Test");
            }
            catch(Exception ex){
                alert(ex.getMessage());
            }
        });

        return new TitledPane("Immunization", immune);
    }
    public TitledPane Incident(ArrayList<Visit> visits, ArrayList<Clinic> clinics, Color dark, Label diagnosis, TextField dia, Label sym, TextArea symptoms, Label visDate, ComboBox<String> tests){
        BorderPane ins = new BorderPane();
        GridPane s = new GridPane();
        HBox severity = new HBox(10);
        s.setHgap(12);
        s.setVgap(12);
        s.setPadding(new Insets(10,10,10,10));
        Label bodyPart = new Label("Body Part:");
        Label sev = new Label("Severity:");
        nodesModifications(bodyPart,null);
        nodesModifications(sev,null);
        TextField bp = new TextField();
        RadioButton low = new RadioButton("LOW");
        RadioButton medium = new RadioButton("MEDIUM");
        RadioButton high = new RadioButton("HIGH");
        ToggleGroup tg = new ToggleGroup();
        low.setToggleGroup(tg);
        medium.setToggleGroup(tg);
        high.setToggleGroup(tg);
        tg.selectToggle(low);
        nodesModifications(low,null);
        nodesModifications(medium,null);
        nodesModifications(high,null);
        nodesModifications(bp,"Body Organ Or Region of injury");
        Button sub = new Button("Submit");
        nodesModifications(sub,null);
        severity.getChildren().addAll(low,medium,high);
        s.addColumn(0,bodyPart,sev);
        s.addColumn(1,bp,severity);
        s.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(sub,Pos.CENTER);
        s.setBackground(new Background(new BackgroundFill(dark,null,null)));
        ins.setCenter(s);
        ins.setBottom(sub);
        ins.setBackground(new Background(new BackgroundFill(dark,null,null)));
        //Event Handling
        sub.setOnAction(e->{
            String r;
            Visit v;
            try{
                VerifyText(dia,diagnosis.getText());
                VerifyText(bp,bodyPart.getText());
                VerifyRadio(tg,sev.getText());
                Toggle selectedSev =tg.getSelectedToggle();
                r =((RadioButton) selectedSev).getText();
                v = new Incident(symptoms.getText(),dia.getText(),clinics.getLast(),r,bp.getText());
                visits.add(v);
                FileManager.Write(v);
                dia.clear();
                bp.clear();
                tg.selectToggle(null);
                symptoms.clear();
                tests.setPromptText("Choose Test");
            }
            catch(Exception ex){
                alert(ex.getMessage());
            }
        });
        return new TitledPane("Incident",ins);
    }
    public void nodesModifications(Node node, String promeText){
        if(node instanceof Label l) {
            l.setTextFill(Color.WHITE);
            Font f = new Font("Times New Roman", 16);
            l.setFont(f);
        }
        else if (node instanceof TextField t) {
            t.setPromptText(promeText);
            t.setPrefWidth(250);
            t.setPrefHeight(20);
        }
        else if (node instanceof RadioButton r) {
            r.setTextFill(Color.WHITE);
        }
        else if (node instanceof Button b) {
            b.setTextFill(Color.BLACK);
            b.setPrefHeight(30);
            b.setPrefWidth(100);
        }
    }
    public void headers(Label label){
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
    }
    public void VerifyText(TextField field,String text) throws Exception{
        String in = field.getText().trim();
        if(in.isEmpty()){
            throw new Exception("Empty Input");
        }
        if(!(in.matches("[a-zA-Z\\s]+"))){
            throw new Exception(text+" must contain alphabetical characters");
        }
    }
    public void alert(String label){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Invalid Input");
        a.setHeaderText(null);
        a.setContentText(label);
        a.showAndWait();
    }
    public void VerifyNumbers(TextField field,String text) throws Exception{
        String in = field.getText().trim();
        if(in.isEmpty()){
            throw new Exception("Empty Input");
        }
        if(!(in.matches("[0-9]+"))){
            throw new Exception(text+" must contain number");
        }
    }
    public void VerifyDoubles(TextField field,String text) throws Exception{
        String in = field.getText().trim();
        if(in.isEmpty()){
            throw new Exception("Empty Input");
        }
        if (!in.matches("\\d+(\\.\\d+)?")) {
            throw new Exception(text + " must be a valid decimal number.");
        }
    }
    public void VerifyCombo(ComboBox<?> cb, String fieldName) throws Exception {
        // If the user hasn't picked anything, getValue() returns null
        if (cb.getValue() == null || cb.getValue().toString().isEmpty()) {
            throw new Exception(fieldName + " must be selected!");
        }
    }
    public void VerifyRadio(ToggleGroup field,String text) throws Exception{
        String in =field.getSelectedToggle().toString();
            if(in.isEmpty()){
                throw new Exception("Empty Input");
            }
        }
    public void VerifyDate(DatePicker field,String text) throws Exception{
        String in =field.getValue().toString();
        if(in.isEmpty()){
            throw new Exception("Empty Input");
        }
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}