import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aray {
//    -------------------------------------------Portal-----------------------------------------------------------------
    public static void portal(){
        System.out.println("  LOGIN PORTAL    ");
        System.out.println("-----------------------E Health Care Management System-------------------------");
        System.out.println("-------------------------------------------------------------------------------\n" +
                " -                                                                            -\n" +
                " -                    1-Admin login                                           -\n" +
                " -                    2-Patient login                                         -\n" +
                " -                    3-Doctor login                                          -\n" +
                " -                                                                            -\n" +
                " -                                                                            -\n" +
                " ------------------------------------------------------------------------------\n");
    }
//    -------------------------------------------Admin-------------------------------------------------------------------------
    public static void admin_potal(){
        System.out.println("   Admin's Dashboard   ");
        System.out.println("-------------------Welcome to the Admin port al----------------------------");
        System.out.println("-------------------------------------------------------------------------------\n" +
                " -                                                                            -\n" +
                " -                    1-view profile                                          -\n" +
                " -                    2-Doctor list                                           -\n" +
                " -                    3-Patient list                                          -\n" +
                " -                    4-Add Doctor                                            -\n" +
                " -                    5-Remove Doctor                                         -\n" +
                " -                    6-Appointment detail                                    -\n" +
                " -                    7-ViewFeedback                                          -\n" +
                " -                    8-ViewReport                                            -\n" +
                " -                    9-Medicines                                             -\n" +
                " -                    10-Add Medicine                                         -\n" +
                " -                    11-Log out                                              -\n" +
                " ------------------------------------------------------------------------------\n");
    }
    public static void account_for_admin() throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.println("If you have already account then press y/Y");
        System.out.println("If you have no account then first create your account ");
        String admin_account= input.nextLine();
        while (true){
            if(admin_account.equals("y")||admin_account.equals("Y")){
                break;
            }else {
                System.out.println("Please Create your account First");
                create_account_for_admin();
                break;
            }
        }
    }
    public static String admin_login() throws IOException {
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/admin_login";
        System.out.println("To open you portal enter you password");
        System.out.println("Enter you password");
        String password= input.nextLine();
        while (true){
            if(read_data_for(path,password)==true){
                System.out.println("successfully login");
                break;
            }else {
                System.out.println("wrong password");
                System.out.println("enter the true password");
                password= input.nextLine();
            }
        }return password;
    }
    public static void create_account_for_admin() throws IOException {
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/admin_login";
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your password to create account");
        String password= input.nextLine();
        while (true){
            if(read_data_for(path,password)==false){
                System.out.println("enter the name");
                String admin_name= take_input();
                String admin_ph_num=phone_number();
                String admin_email= email();
                try(FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/admin_login",true);
                    BufferedWriter file=new BufferedWriter(f);
                    PrintWriter new_file=new PrintWriter(file);)
                {
                    new_file.println(password);
                    new_file.println("Name : "+admin_name);
                    new_file.println("Phone_number : "+admin_ph_num);
                    new_file.println("Email : "+admin_email);
                    new_file.println("----");
                    System.out.println("Your account has been created successfull");
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            }else {
                System.out.println("Password already exist\nPlease try another password to create account");
                password= input.nextLine();
            }
        }
    }

//    ----------------------------------------Doctors---------------------------------------------------------------------------
    public static void doctor_portal(){
        System.out.println("   Doctor's Dashboard   ");
        System.out.println("-------------------Welcome to the Doctor portal----------------------------");
        System.out.println("-------------------------------------------------------------------------------\n" +
                " -                                                                            -\n" +
                " -                    1-view profile                                          -\n" +
                " -                    2-Patient list                                          -\n" +
                " -                    3-Report update                                         -\n" +
                " -                    4-Appointment detail                                    -\n" +
                " -                    5-Log Out                                               -\n" +
                " _                                                                            -\n"+
                " ------------------------------------------------------------------------------\n");

    }
    public static String doctor_login() throws IOException {
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/doctors_record";
        System.out.println("To open you portal enter you password");
        System.out.println("Enter you password");
        String password= input.nextLine();
        while (true){
            if(read_data_for(path,password)==true){
                break;
            }else {
                System.out.println("wrong password");
                System.out.println("enter the true password");
                password= input.nextLine();
            }
        }return password;
    }

    public static void view_doctors(){
        File my_file=new File("/Users/masad/IdeaProjects/e_care_management_system/src/doctors_record");
        try {
            Scanner myfile=new Scanner(my_file);
            while (myfile.hasNextLine()){
                String data =myfile.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            System.out.println("file not found");
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static void add_doctor() throws IOException {
        Scanner input = new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/doctors_record";
        System.out.println("Please enter the surgeon /doctor and other specialist you want to add");
        System.out.println("As you already have like  \nOrthopedic Surgeon\nNeurologist\nMedical Specialist\n" +
                "Cardiologist\nEnt Specialist\nPulmonologist");
        System.out.println("Enter the index");
        String index= input.nextLine();
        while (true){
            if(index.matches("[a-zA-Z\\s+_.-]+")||index.matches("^[!@#$%^&*()_+}{|:<>?~]")){
                System.out.println("Invalid input\ntry again");
                index= input.nextLine();
            }else {
                break;

            }
        }
        while (true){
            if(read_data_for(path,index)==false){
                System.out.println("Specialist");
                String specialist= take_input();
                System.out.println("Enter doctor Name");
                String name = take_input();
                System.out.println("Enter doctor Education");
                String education = take_input();
                System.out.println("Enter doctor Specialisation");
                String specialisation = take_input();
                System.out.println("Enter Satisfaction");
                String satisfaction = id();
                System.out.println("Enter Review");
                String review = id();
                System.out.println("Enter Doctor Experience");
                String experience = id();
                System.out.println("Enter Doctor Email");
                String email = email();
                System.out.println("Enter Doctor Phone_No ");
                String phone_No  = phone_number();
                System.out.println("Enter Doctor start time");
                String start= id();
                System.out.println("Enter Doctor end time");
                String end_time= id();
                System.out.println("enter doctor id");
                String doctor_id= id();
                while (true){
                    String path_2="/Users/masad/IdeaProjects/e_care_management_system/src/doctors_ids.txt";
                    if(read_data_for(path_2,doctor_id)==false){
                        break;
                    }else {
                        System.out.println("Id of the doctor already exist\nPlease try another");
                        index= input.nextLine();
                        if(index.matches("[a-zA-Z\\s+_.-]+")||index.matches("^[!@#$%^&;'/?.,><*()_+}{|:~]")){
                            System.out.println("Invalid input\ntry again");
                            index= input.nextLine();
                        }else {
                        }

                    }
                }
                try(FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/doctors_record",true);
                    BufferedWriter new_file=new BufferedWriter(f);
                    PrintWriter file_write=new PrintWriter(new_file);)
                {
                    file_write.println(index);
                    file_write.println(specialist+"------");
                    file_write.println("Name : " +"Dr"+ name);
                    file_write.println("Education : " +education );
                    file_write.println("Specialist : " + specialisation);
                    file_write.println("Satisfaction : " + satisfaction+"%");
                    file_write.println("Review : " +review+"+");
                    file_write.println("Experience : " + experience+"Year");
                    file_write.println("Emaile : " + email);
                    file_write.println("Phone_number : " + phone_No);
                    file_write.println("Timing : " +"0"+ start+":"+"00"+"pm"+"-"+"0"+end_time+":"+"00"+"pm");
                    file_write.println("Doctor_ID : "+doctor_id);
                    file_write.println("----");
                } catch (Exception e) {
                    System.out.println(e);

                }
                try(FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/doctores_list_for_patient",true);
                     BufferedWriter file=new BufferedWriter(f);
                     PrintWriter new_file=new PrintWriter(file);)
                {
                    new_file.println(index);
                    new_file.println(specialist+"-----");
                    new_file.println("Dr "+name +"( "+education+" )");
                    new_file.println("Timing : " +"0"+ start+":"+"00"+"pm"+"-"+"0"+end_time+":"+"00"+"pm");
                    new_file.println("Doctor_Id : "+doctor_id);
                    new_file.println("----");
                    System.out.println("Doctor has been added successfully");
                    System.out.println("you can view this added doctor from the doctor list");
                }catch (Exception e){
                    System.out.println(e);
                }
                try(FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/doctors_ids.txt",true);
                    BufferedWriter file=new BufferedWriter(f);
                    PrintWriter new_file=new PrintWriter(file);)
                {
                    new_file.println(doctor_id);
                }catch (Exception e){
                    System.out.println(e);
                }
                break;
            }else {
                System.out.println("Index of the doctor already exist\nPlease try another");
                index= input.nextLine();
                if(index.matches("[a-zA-Z\\s+_.-]+")||index.matches("^[!@#$%^&;'/?.,><*()_+}{|:~]")){
                    System.out.println("Invalid input\ntry again");
                    index= input.nextLine();
                }else {
                }

            }
        }

    }
    public static void short_list_of_doctor(){
        File myfile=new File("/Users/masad/IdeaProjects/e_care_management_system/src/doctores_list_for_patient");
        try {
            Scanner my_file=new Scanner(myfile);
            while (my_file.hasNextLine()){
                String data=my_file.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            System.out.println("file not found");
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static void delete_doctor()throws IOException{
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/doctors_record";
        System.out.println("enter doctor index");
        String index= input.nextLine();
//        System.out.println("enter doctor_id index");
//        String doctor_id= input.nextLine();
        while (true){
            if(read_data_for(path,index)==true){
                read_data_for_doctor(path,index);
                System.out.println("has been removed");
                break;
            }else{
                System.out.println("invalid input");
                System.out.println("enter doctor index");
                index= input.nextLine();
//                System.out.println("enter doctor_id index");
//                doctor_id= input.nextLine();
            }
        }
    }
    public static void read_data_for_doctor(String path,String startingpoint)throws IOException {
        String medicine;
//    int  endingpoint=startingpoint+1;
        String endingpoint="----";
        String start=String.valueOf(startingpoint);
        String end =String.valueOf(endingpoint);
        Scanner console1= new Scanner(new File(path));
        while(console1.hasNextLine()){
            if(Objects.equals(console1.nextLine(),start)){
                while (true){
                    medicine =console1.nextLine();
                    if(!Objects.equals(medicine,end)){
                        System.out.println(medicine);
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }

    public static boolean read_data_for(String path, String startingpoint)throws IOException {
        String medicine;
//    int  endingpoint=startingpoint+1;
        String endingpoint="---";
        boolean found=false;
        String start=String.valueOf(startingpoint);
        String end =String.valueOf(endingpoint);
        Scanner console1= new Scanner(new File(path));
        while(console1.hasNextLine()){
            if(Objects.equals(console1.nextLine(),start)){
                while (true){
                    medicine =console1.nextLine();
                    if(!Objects.equals(medicine,end)){
//                        System.out.println(medicine);
                        found=true;
                        break;
                    }
                    else {
                    }
                }
            }
        }return found;
    }
//--------------------------------------Patients-----------------------------------------------------------------------------------
    public static void patient_portal(){
        System.out.println("   Patient_login   ");
        System.out.println("-------------------Welcome to the Patient portal----------------------------");
        System.out.println("-------------------------------------------------------------------------------\n" +
                " -                                                                            -\n" +
                " -                    1-View profile                                          -\n" +
                " -                    2-Doctor list                                           -\n" +
                " -                    3-Book an appointment                                   -\n" +
                " -                    4-Appointment detail                                    -\n" +
                " -                    5-ViewFeedback                                          -\n" +
                " -                    6-Medicines                                             -\n" +
                " -                    7-Give Feedback                                         -\n" +
                " -                    8-Logout                                                -\n" +
                " -                                                                            -\n" +
                " -                                                                            -\n" +
                " ------------------------------------------------------------------------------\n");
    }
    public static void account_for_patient() throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.println("If you have already account then press y/Y");
        System.out.println("If you have no account then first create your account ");
        String admin_account= input.nextLine();
        while (true){
            if(admin_account.equals("y")||admin_account.equals("Y")){
                break;
            }else {
                System.out.println("Please Create your account First");
                creat_account_for_patient();
                break;
            }
        }
    }
    public static void creat_account_for_patient () throws IOException {
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/patients_record";
        System.out.println("enter your password to create account");
        String patient_password= input.nextLine();
        while (true){
            if(read_data_for(path,patient_password)==false){
                System.out.println("enter your Name ");
                String name= take_input();
                System.out.println("enter your Age ");
                String age= id();
                System.out.println("Enter Patient_id");
                String patient_id =id();
                System.out.println(" Enter your Country");
                String country = take_input();
                System.out.println("Enter your Address");
                String address = take_input();
                System.out.println(" Enter your phone number");
                String ph_num = phone_number();
                System.out.println(" Enter sex(male/female)");
                String sex_m_f = take_input();
                System.out.println(" Enter your email Email");
                String email = email();
                try (FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/patients_record",true);
                     BufferedWriter new_file=new BufferedWriter(f);
                     PrintWriter p=new PrintWriter(new_file);)
                {
                    p.println(patient_password);
                    p.println("Name : "+name);
                    p.println("Age :  "+age);
                    p.println("Patient_id : "+patient_id);
                    p.println("Country : "+country);
                    p.println("Address : "+address);
                    p.println("Phone No : "+ph_num);
                    p.println("Sex : "+sex_m_f);
                    p.println("Email : "+email);
                    p.println("----");
                }catch (IOException e){
                    System.out.println(e);
                }
                break;

            }else {
                System.out.println("Password already exist\nPlease choose another ");
                patient_password= input.nextLine();
            }
        }
    }
    public static String patient_login() throws IOException {
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/patients_record";
        System.out.println("To open you portal enter you password");
        System.out.println("Enter you password");
        String password= input.nextLine();
        while (true){
            if(read_data_for(path,password)==true){
                System.out.println("successfully login");
                break;
            }else {
                System.out.println("wrong password");
                System.out.println("enter the true password");
                password= input.nextLine();
            }
        }return password;
    }
    public static void view_patient() {
        File my_file=new File("/Users/masad/IdeaProjects/e_care_management_system/src/patients_record");
        try {
            Scanner myfile=new Scanner(my_file);
            while (myfile.hasNextLine()){
                String data =myfile.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            System.out.println("file not found");
            System.out.println(e);
            e.printStackTrace();
        }
    }

//    -------------------------------------Medicines---------------------------------------------------------------------------
    public static void view_medicine(){
        File my_file=new File("/Users/masad/IdeaProjects/e_care_management_system/src/medicines_record.txt");
        try {
            Scanner myfile=new Scanner(my_file);
            while (myfile.hasNextLine()){
                String data =myfile.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            System.out.println("file not found");
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static void add_medicines() throws IOException {
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/medicines_record.txt";
        System.out.println("Enter medicine index");
        String index= input.nextLine();
        while (true){
            if(index.matches("[a-zA-Z\\s+_.-]+")||index.matches("^[!@#$%^&*()_+}{|:<>?~]")){
                System.out.println("Invalid input\ntry again");
                index= input.nextLine();
            }else {
                break;

            }
        }
        while (true){
            if(read_data_for_medicines(path,index)==false){
                System.out.println("Enter type of the medicine");
                String type= take_input();
                System.out.println("you can add  maximum 5 medicines in each type");
                String medicine_1= take_input();
                String medicine_2= take_input();
                String medicine_3= take_input();
                String medicine_4= take_input();
                String medicine_5= take_input();
                try (FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/medicines_record.txt",true);
                     BufferedWriter new_file=new BufferedWriter(f);
                     PrintWriter p=new PrintWriter(new_file);)
                {
                    p.println(index);
                    p.println("**--"+type+"----");
                    p.println(medicine_1);
                    p.println(medicine_2);
                    p.println(medicine_3);
                    p.println(medicine_4);
                    p.println(medicine_5);
                    p.println("----");
                    System.out.println("Medicines has been added successfully you can view the medicine from the list");
                }catch (IOException e){
                    System.out.println(e);
                }break;
            }else {
                System.out.println("The index of the medicine is already exist\nSo please choose another");
                System.out.println("enter the index of the medicine");
                index= input.nextLine();
                if(index.matches("[a-zA-Z\\s+_.-]+")||index.matches("^[!@#$%^&;'/?.,><*()_+}{|:~]")){
                    System.out.println("Invalid input\ntry again");
                    index= input.nextLine();
                }else {
                }
            }
        }

    }
    public static boolean read_data_for_medicines(String path, String startingpoint)throws IOException {
        String medicine;
        String endingpoint="---";
        boolean found=false;
        String start=String.valueOf(startingpoint);
        String end =String.valueOf(endingpoint);
        Scanner console1= new Scanner(new File(path));
        while(console1.hasNextLine()){
            if(Objects.equals(console1.nextLine(),start)){
                while (true){
                    medicine =console1.nextLine();
                    if(!Objects.equals(medicine,end)){
                        found=true;
                        break;
                    }
                    else {
                    }
                }
            }
        }return found;
    }
//    ---------------------------------------------------Appointments--------------------------------------------------------
public static void read_data_for_appointment(String path,int startingpoint,int endingpoint) throws FileNotFoundException {
    String medicine;
    String start=String.valueOf(startingpoint);
    String end =String.valueOf(endingpoint);
    Scanner console1= new Scanner(new File(path));
    while(console1.hasNextLine()){
        if(Objects.equals(console1.nextLine(),start)){
            while (true){
                medicine =console1.nextLine();
                if(!Objects.equals(medicine,end)){
                    System.out.println(medicine);
                }
                else {
                    break;
                }
            }
        }
    }
}
    public static void read_data(String path,String startingpoint,int endingpoint) throws FileNotFoundException {
        String medicine;
//    int  endingpoint=startingpoint+1;
        String start=String.valueOf(startingpoint);
        String end =String.valueOf(endingpoint);
        Scanner console1= new Scanner(new File(path));
        while(console1.hasNextLine()){
            if(Objects.equals(console1.nextLine(),start)){
                while (true){
                    medicine =console1.nextLine();
                    if(!Objects.equals(medicine,end)){
                        System.out.println(medicine);
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }

    public static void book_appointment() throws IOException {
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/doctores_list_for_patient";
        System.out.println("Appointment Booking");
        System.out.println("We have the following doctor ");
        short_list_of_doctor();
        System.out.println("Select the index for book an appointment");
        String index= input.nextLine();
        while (true){
            if(read_data_for(path,index)==true){
                read_data_for_doctor(path,index);
                System.out.println("doctor specialist");
                String specialist= take_input();
                System.out.println("doctor name");
                String doctor_name= take_input();
                System.out.println("enter doctor id");
                String doctor_id= id();
                while(true){
                    String path_1="/Users/masad/IdeaProjects/e_care_management_system/src/doctors_ids.txt";
                    if(read_data_for(path_1,doctor_id)==true){
                        break;
                    }else {
                        System.out.println("Invalid id\nplease try again");
                        doctor_id=input.nextLine();
                    }
                }
                System.out.println("enter your full name");
                String name= take_input();
                System.out.println("enter your  account password");
                String password=patient_login_1();
                System.out.println("enter your disease/problem");
                String problem= take_input();
                System.out.println("enter the date when you want to book appointment");
                System.out.println("first enter date");
                String date=id();
                System.out.println("enter the month");
                String month= id();
                System.out.println("enter the time for appointment");
                String time= id();
                try (FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/appointnment.txt",true);
                     BufferedWriter new_file=new BufferedWriter(f);
                     PrintWriter p=new PrintWriter(new_file);)
                {
                    p.println(doctor_id);
                    p.println(password);
                    p.println("Name : "+name);
                    p.println("Problem : "+problem);
                    p.println("Booked assignment with:");
                    p.println("Dr "+doctor_name+"  ( "+specialist+" )");
                    p.println("Doctor : ID "+doctor_id);
                    p.println("Appointment data is : "+date +"-"+month+" at "+"0 :"+time +"pm");
                    p.println("----");
                }catch (IOException e){
                    System.out.println(e);
                }
                try (FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/appointment_for_doctor.txt",true);
                      BufferedWriter new_file=new BufferedWriter(f);
                      PrintWriter p=new PrintWriter(new_file);)
                {
                    p.println(doctor_id);
                    p.println("Name : "+name);
                    p.println("Problem : "+problem);
                    p.println("Booked assignment with:");
                    p.println("Dr "+doctor_name+"  ( "+specialist+" )");
                    p.println("Doctor : ID "+doctor_id);
                    p.println("Appointment data is : "+date +" at "+"0 :"+time +"pm");
                    p.println("----");
                }catch (IOException e){
                    System.out.println(e);
                }
                break;

            }else {
                System.out.println("Invalid! input\nTry again");
                index= input.nextLine();
            }
        }
    }
    public static String patient_login_1() throws IOException {
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/patients_record";
        System.out.println("Enter you password");
        String password= input.nextLine();
        while (true){
            if(read_data_for(path,password)==true){
                break;
            }else {
                System.out.println("wrong password");
                System.out.println("enter the true password");
                password= input.nextLine();
            }
        }return password;
    }
    public static void view_appointment() {
        File my_file=new File("/Users/masad/IdeaProjects/e_care_management_system/src/appointnment.txt");
        try {
            Scanner myfile=new Scanner(my_file);
            while (myfile.hasNextLine()){
                String data =myfile.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            System.out.println("file not found");
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static String appointment_for_doctor() throws IOException {
        Scanner input=new Scanner(System.in);
        String path="/Users/masad/IdeaProjects/e_care_management_system/src/appointment_for_doctor.txt";
        System.out.println(" enter you doctor_id");
        String id= input.nextLine();
        while (true){
            if(id.matches("[a-zA-Z\\s+_.-]+")||id.matches("^[!@#$%^&*()_+}{|:<>?~]")){
                System.out.println("Invalid input\ntry again");
                id= input.nextLine();
            }else {
                break;

            }
        }
        while (true){
            if(read_data_for(path,id)==true){
                break;
            }else {
                System.out.println("wrong id");
                System.out.println("enter the true id");
                id= input.nextLine();
                while (true){
                    if(id.matches("[a-zA-Z\\s+_.-]+")||id.matches("^[!@#$%^&*()_+}{|:<>?~]")){
                        System.out.println("Invalid input\ntry again");
                        id= input.nextLine();
                    }else {
                        break;

                    }
                }
            }
        }return id;
    }

//    ---------------------------------------------FeedBack Table--------------------------------------------------------------------
public static void give_feedback(){
    Scanner input=new Scanner(System.in);
    System.out.println("enter your Name ");
    String name= take_input();
    System.out.println("Enter your Address");
    String address = take_input();
    System.out.println("Nature of the doctor");
    String nature = take_input();
    System.out.println("Satisfaction");
    String satisfaction = with_out_alphabets();
    System.out.println("Rate our service from (1-10)");
    String rate = with_out_alphabets();
    System.out.println("Any suggestion");
    String suggestion= take_input();
    try (FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/feedback",true);
         BufferedWriter new_file=new BufferedWriter(f);
         PrintWriter p=new PrintWriter(new_file);)
    {
        p.println();
        p.println("Name : "+name);
        p.println("Address :  "+address);
        p.println("Nature of the doctor : "+nature);
        p.println("Satisfaction : "+satisfaction+"%");
        p.println("Rate our service from (1-10) : "+rate);
        p.println("Any suggestion : "+suggestion);
    }catch (IOException e){
        System.out.println(e);
    }
}
    public static void view_feedback(){
        File my_file=new File("/Users/masad/IdeaProjects/e_care_management_system/src/feedback");
        try {
            Scanner myfile=new Scanner(my_file);
            while (myfile.hasNextLine()){
                String data =myfile.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            System.out.println("file not found");
            System.out.println(e);
            e.printStackTrace();
        }
    }
//----------------------------------------------------Report Table----------------------------------------------------------------
public static void update_report(){
    Scanner input=new Scanner(System.in);
    System.out.println("enter report Id ");
    String report_id= id();
    System.out.println("enter appointmentID");
    String appointment_id = id();
    System.out.println("enter patient Id");
    String patient_id = id();
    System.out.println("Doctor_Id");
    String doctor_id = id();
    System.out.println("MedicinePrescribes");
    String medicine_prescribes = take_input();
    System.out.println("DoctorComment");
    String doctor_comment= take_input();
    try (FileWriter f=new FileWriter("/Users/masad/IdeaProjects/e_care_management_system/src/repotr_table",true);
         BufferedWriter new_file=new BufferedWriter(f);
         PrintWriter p=new PrintWriter(new_file);)
    {
        p.println("---------------------------------------------------------------------------------------------------");
        p.println("Report_id : "+report_id                                                                             );
        p.println("Appointment_id : "+appointment_id                                                                   );
        p.println("Patient_id : "+patient_id                                                                           );
        p.println("Doctor_id : "+doctor_id                                                                             );
        p.println("Medicine_prescribes : "+medicine_prescribes                                                         );
        p.println("Doctor_comment : "+doctor_comment                                                                   );
        p.println(                                                                                                     );
        p.println("---------------------------------------------------------------------------------------------------");
        p.println("---------------------------------------------------------------------------------------------------");

    }catch (IOException e){
        System.out.println(e);
    }
}
    public static void view_report(){
        File my_file=new File("/Users/masad/IdeaProjects/e_care_management_system/src/repotr_table");
        try {
            Scanner myfile=new Scanner(my_file);
            while (myfile.hasNextLine()){
                String data =myfile.nextLine();
                System.out.println(data);
            }
        }catch (IOException e){
            System.out.println("file not found");
            System.out.println(e);
            e.printStackTrace();
        }
    }



//    -------------------------------------------------validation------------------------------------------------------------
    public static String take_input(){
        Scanner input=new Scanner(System.in);
        while (true){
            String name= input.nextLine();
            if(name.matches("[a-zA-Z\\s]+")){
                return name;
            }else {
                System.out.println("Invalid input\ntry again");

            }
        }

    }
    public static String email(){
        Scanner input=new Scanner(System.in);
        String email= input.nextLine();
        while (true){
            if(email.matches("^[a-zA-Z0-9+_.-]+@(.+$)")){
                break;
            }else {
                System.out.println("Invalid input\ntry again");
                email= input.nextLine();

            }
        }return email;

    }
    public static boolean isvalid(String number){
        Scanner input=new Scanner(System.in);
        Pattern pattren=Pattern.compile("^\\d{11}$");
        Matcher m= pattren.matcher(number);
        return m.matches();

    }
    public static String phone_number(){
        Scanner input=new Scanner(System.in);
        String number= input.nextLine();
        while (true){
            if(isvalid(number)){
                break;
            }
            else{
                System.out.println("invalid");
                number= input.nextLine();
            }
        }return number;
    }
    public static String with_out_alphabets(){
        Scanner input=new Scanner(System.in);
        String index= input.nextLine();
        while (true){
            if(index.matches("[a-zA-Z\\s+_.-]+")||index.matches("^[!@#$%^&*()_+}{|:<>?~]")){
                System.out.println("Invalid input\ntry again");
                index= input.nextLine();
            }else {
                break;

            }
        }return index;

    }
    public static String id(){
        Scanner input=new Scanner(System.in);
        String id= input.nextLine();
        while (true){
            if(id.matches("[a-zA-Z\\s+_.-]+")||id.matches("^[!@#$%^&*()_+}{|:<>?~]")){
                System.out.println("Invalid input\ntry again");
                id= input.nextLine();
            }else {
                break;

            }
        }return id;

    }


//    ------------------------------------------------Main method------------------------------------------------------------------

    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner input = new Scanner(System.in);
            portal();
            System.out.println("select the desire option ");
            String option = input.nextLine();
            while (true) {
                if (option.equals("1")) {
                    System.out.println("Admin's Dashboard");
                    account_for_admin();
                    String password_1=admin_login();
                    admin_potal();
                    System.out.println("Select what you want to choose");
                    String opt = input.nextLine();
                    while (true) {
                        if(opt.equals("1")) {
                            String path="/Users/masad/IdeaProjects/e_care_management_system/src/admin_login";
                            read_data_for_doctor(path,password_1);
                            break;
                        }else if (opt.equals("2")) {
                            view_doctors();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("3")) {
                            view_patient();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("4")) {
                            add_doctor();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("5")) {
                            view_doctors();
                            delete_doctor();
                            break;
                        } else if (opt.equals("6")) {
                            System.out.println("appoint detail");
                            view_appointment();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("7")) {
                            view_feedback();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("8")){
                            view_report();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("9")){
                            view_medicine();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        }else if(opt.equals("10")){
                            System.out.println("we have the following medicines");
                            view_medicine();
                            add_medicines();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("11")){
                            System.out.println("Successfully Log Out");
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else {
                            System.out.println("Invalid Input\nPLease Try Again With True Input");
                            opt = input.nextLine();
                        }
                    }break;
//                    System.out.println("Do you want to log in again\nIf yes then");
//                    System.out.println("Press (y/Y) for again or press any key to exit");
//                    String again = input.nextLine();
//                    if (again.equals("y") || again.equals("Y")) {
//                    } else break;
                }else if (option.equals("2")) {
                    account_for_patient();
                    String patient_password=patient_login();
                    patient_portal();
                    System.out.println("Select your desire option");
                    String opt= input.nextLine();
                    while (true){
                        if(opt.equals("1")){
                            String path="/Users/masad/IdeaProjects/e_care_management_system/src/patients_record";
                            read_data_for_doctor(path,patient_password);
                            break;
                        } else if (opt.equals("2")){
                            view_doctors();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("3")){
                            book_appointment();
                            System.out.println("your appointment has been booked");
                            System.out.println("so you can view your appointment from your appointment detail");
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("4")){
                            System.out.println("appointment detail");
                            String path="/Users/masad/IdeaProjects/e_care_management_system/src/appointment_for_doctor.txt";
                            read_data_for_doctor(path,patient_password);
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("5")){
                            System.out.println("FeedBack Form ");
                            view_feedback();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("6")){
                            view_medicine();
                            System.out.println("you can view the different medicines for different disease");
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (opt.equals("7")){
                            System.out.println("Give FeedBack");
                            give_feedback();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        }else if(opt.equals("8")){
                            System.out.println("Successfully Logout");
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        }else {
                            System.out.println("Invalid! input\nPlease choose correct");
                            opt= input.nextLine();
                        }
                    }break;

                } else if (option.equals("3")){
                    String password=doctor_login();
                    String doctor_id=appointment_for_doctor();
                    doctor_portal();
                    System.out.println("Select what you want to choose");
                    String doctor_option = input.nextLine();
                    while (true) {
                        if (doctor_option.equals("1")) {
                            String path="/Users/masad/IdeaProjects/e_care_management_system/src/doctors_record";
                            System.out.println("View Profile");
                            read_data_for_doctor(path,password);
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (doctor_option.equals("2")) {
                            System.out.println("Patient_list");
                            view_patient();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (doctor_option.equals("3")) {
                            System.out.println("The Previous report");
                            view_report();
                            System.out.println("Please the update the report");
                            update_report();
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (doctor_option.equals("4")) {
                            System.out.println("Appointment detail");
                            String path="/Users/masad/IdeaProjects/e_care_management_system/src/appointnment.txt";
                            read_data_for_doctor(path,doctor_id);
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else if (doctor_option.equals("5")) {
                            System.out.println("Successfully Log out");
                            System.out.println("-------------------------------------------------------------------------");
                            break;
                        } else {
                            System.out.println("Invalid Input\nPLease Try Again With True Input");
                            doctor_option = input.nextLine();
                        }
                    }break;
                } else {
                    System.out.println("Invalid! Input\nPlease Try Again With True Input ");
                    option = input.nextLine();
                }
            }
            System.out.println("Do uou want to open the portal again?\nIf yes then");
            System.out.println("Press (y/Y) for again-login or press any key to exit");
            String again= input.nextLine();
            if(again.equals("y")||again.equals("Y")){

            }
            else break;
        }
    }
}
