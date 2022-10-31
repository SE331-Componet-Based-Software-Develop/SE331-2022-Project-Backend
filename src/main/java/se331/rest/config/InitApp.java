package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.Comment;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.repository.CommentRepository;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;
import se331.rest.repository.VaccineRepository;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    VaccineRepository vaccineRepository;
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;
    User user1 = new User();
    User user2 = new User();
    User user3 = new User();
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Doctor dor1 = new Doctor();
        List<String> dor1image = new ArrayList<>();
        dor1image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20142052952-d1.jpg?generation=1667110855185130&alt=media"));

        dor1 = doctorRepository.save(Doctor.builder()
                .name("Si")
                .sur_name("Li")
                .age("40")
                .hometown("DC")
                .imageUrl(dor1image)
                .build());
        List<String> dor2image = new ArrayList<>();
        dor2image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20142107634-d2.jpg?generation=1667110869830017&alt=media"));
        Doctor dor2;
        dor2 = doctorRepository.save(Doctor.builder()
                .name("Hua")
                .sur_name("Li")
                .age("50")
                .hometown("Ningxia")
                .imageUrl(dor2image)
                .build());
        List<String> dor3image = new ArrayList<>();
        dor3image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20142125662-d3.jpg?generation=1667110887855094&alt=media"));
        Doctor dor3;
        dor3 = doctorRepository.save(Doctor.builder()
                .name("San")
                .sur_name("Zhang")
                .age("56")
                .hometown("Beijing")
                .imageUrl(dor3image)
                .build());
        List<String> dor4image = new ArrayList<>();
        dor4image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20142140381-d4.jpg?generation=1667110902548368&alt=media"));
        Doctor dor4;
        dor4 = doctorRepository.save(Doctor.builder()
                .name("Wu")
                .sur_name("Wang")
                .age("67")
                .hometown("Shanghai")
                .imageUrl(dor4image)
                .build());
        Patient p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
        List<String> p1image = new ArrayList<>();
        p1image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20140520215-1.jpg?generation=1667109925717140&alt=media"));
        p1 = patientRepository.save(Patient.builder()
                .name("Shengzhe")
                .sur_name("Huang")
                .age("20")
                .hometown("Zhejiang_China")
                .doctor(dor1)
                .imageUrl(p1image)
                .build());
        List<String> p2image = new ArrayList<>();
        p2image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20141322210-2.jpg?generation=1667110405323330&alt=media"));
        p2 = patientRepository.save(Patient.builder()
                .name("Haolong")
                .sur_name("Huai")
                .age("21")
                .hometown("Henan_China")
                .doctor(dor1)
                .imageUrl(p2image)
                .build());
        List<String> p3image = new ArrayList<>();
        p3image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20141345340-3.jpg?generation=1667110427551486&alt=media"));
        p3 = patientRepository.save(Patient.builder()
                .name("Yaqi")
                .sur_name("Ren")
                .age("23")
                .hometown("Henan_China")
                .doctor(dor1)
                .imageUrl(p3image)
                .build());
        List<String> p4image = new ArrayList<>();
        p4image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20141404425-4.jpg?generation=1667110446677999&alt=media"));
        p4 = patientRepository.save(Patient.builder()
                .name("Yangyang")
                .sur_name("Ren")
                .age("19")
                .hometown("Ningxia_China")
                .doctor(dor2)
                .imageUrl(p4image)
                .build());
        List<String> p5image = new ArrayList<>();
        p5image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20141421413-5.jpg?generation=1667110463705382&alt=media"));
        p5 = patientRepository.save(Patient.builder()
                .name("Yifan")
                .sur_name("Yao")
                .age("18")
                .hometown("Jiangsu_China")
                .doctor(dor2)
                .imageUrl(p5image)
                .build());
        List<String> p6image = new ArrayList<>();
        p6image.add(new String("https://storage.googleapis.com/download/storage/v1/b/projectimageupload-96213.appspot.com/o/2022-10-30%20141435060-6.jpg?generation=1667110477406833&alt=media"));
        p6 = patientRepository.save(Patient.builder()
                .name("Chong")
                .sur_name("Zeng")
                .age("20")
                .hometown("Shanghai_China")
                .doctor(dor2)
                .imageUrl(p6image)
                .build());
        p7 = patientRepository.save(Patient.builder()
                .name("Yongwei")
                .sur_name("Zhang")
                .age("25")
                .hometown("Gansu_China")
                .doctor(dor3)
                .build());
        p8 = patientRepository.save(Patient.builder()
                .name("Runlong")
                .sur_name("Zhou")
                .age("23")
                .hometown("Yunnan_China")
                .doctor(dor3)
                .build());
        p9 = patientRepository.save(Patient.builder()
                .name("Jing")
                .sur_name("Wang")
                .age("27")
                .hometown("Guizhou_China")
                .doctor(dor3)
                .build());
        p10 = patientRepository.save(Patient.builder()
                .name("Shixiong")
                .sur_name("Qu")
                .age("28")
                .hometown("Hubei_China")
                .doctor(dor4)
                .build());
        p11 = patientRepository.save(Patient.builder()
                .name("Chaoyi")
                .sur_name("Wang")
                .age("24")
                .hometown("New York")
                .doctor(dor4)
                .build());
        p12 = patientRepository.save(Patient.builder()
                .name("Dengtao")
                .sur_name("Wei")
                .age("20")
                .hometown("Sichuan_China")
                .doctor(dor4)
                .build());

        Vaccine v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12;
        v1 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("inactivated vaccine")
                .firstdose_time("02-19,2022")
                .vaccined_status("FirstDose")
                .patient(p1).build());
        v2 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("vector vaccine")
                .firstdose_time("09-3,2021")
                .seconddose_name("vector vaccine")
                .seconddose_time("10-4,2021")
                .vaccined_status("SecondDose")
                .patient(p2).build());
        v3 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("live attenuated vaccine")
                .firstdose_time("05-19,2022")
                .seconddose_name("live attenuated vaccine")
                .seconddose_time("06-20,2022")
                .vaccined_status("SecondDose")
                .patient(p3).build());
        v4 = vaccineRepository.save(Vaccine.builder()
                .vaccined_status("Not Vaccinated")
                .patient(p4).build());
        v5 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("inactivated vaccine")
                .firstdose_time("05-19,2022")
                .vaccined_status("FirstDose")
                .patient(p5).build());
        v6 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("live attenuated vaccine")
                .firstdose_time("08-19,2021")
                .seconddose_name("live attenuated vaccine")
                .seconddose_time("09-21,2021")
                .vaccined_status("SecondDose")
                .patient(p6).build());
        v7 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("inactivated vaccine")
                .firstdose_time("04-25,2021")
                .seconddose_name("inactivated vaccine")
                .seconddose_time("05-25,2021")
                .vaccined_status("SecondDose")
                .patient(p7).build());
        v8 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("live attenuated vaccine")
                .firstdose_time("05-20,2021")
                .seconddose_name("live attenuated vaccine")
                .seconddose_time("06-20,2021")
                .vaccined_status("SecondDose")
                .patient(p8).build());
        v9 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("vector vaccine")
                .firstdose_time("07-5,2022")
                .seconddose_name("vector vaccine")
                .seconddose_time("08-5,2022")
                .vaccined_status("SecondDose")
                .patient(p9).build());
        v10 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("RNA vaccine")
                .firstdose_time("06-7,2022")
                .seconddose_name("RNA vaccine")
                .seconddose_time("07-8,2022")
                .vaccined_status("SecondDose")
                .patient(p10).build());
        v11 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("live attenuated vaccine")
                .firstdose_time("05-5,2022")
                .vaccined_status("FirstDose")
                .patient(p11).build());
        v12 = vaccineRepository.save(Vaccine.builder()
                .firstdose_name("recombinant protein vaccine")
                .firstdose_time("07-25,2021")
                .seconddose_name("recombinant protein vaccine")
                .seconddose_time("08-25,2021")
                .vaccined_status("SecondDose")
                .patient(p12).build());
//        patientRepository.AddVaccine(v1.getId(),p1.getId());
//        patientRepository.AddVaccine(v2.getId(),p2.getId());
        //一个病人对应一个疫苗信息
        p1.setVaccineinfo(v1);
        p2.setVaccineinfo(v2);
        p3.setVaccineinfo(v3);
        p4.setVaccineinfo(v4);
        p5.setVaccineinfo(v5);
        p6.setVaccineinfo(v6);
        p7.setVaccineinfo(v7);
        p8.setVaccineinfo(v8);
        p9.setVaccineinfo(v9);
        p10.setVaccineinfo(v10);
        p11.setVaccineinfo(v11);
        p12.setVaccineinfo(v12);
        //六条留言，四个医生，12个病人，
        Comment c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
        c1 = commentRepository.save(Comment.builder()
                .comment("No vigorous exercise")
                .doctor(dor1)
                .patient(p1).build());
        c2 = commentRepository.save(Comment.builder()
                .comment("No spicy food")
                .doctor(dor1)
                .patient(p2).build());
        c3 = commentRepository.save(Comment.builder()
                .comment("No drinking")
                .doctor(dor1)
                .patient(p2).build());
        c4 = commentRepository.save(Comment.builder()
                .comment("No bathing")
                .doctor(dor1)
                .patient(p2).build());
        c5 = commentRepository.save(Comment.builder()
                .comment("Please have more rest.")
                .doctor(dor1)
                .patient(p2).build());
        c6 = commentRepository.save(Comment.builder()
                .comment("Please have light food.")
                .doctor(dor1)
                .patient(p2).build());
        c7 = commentRepository.save(Comment.builder()
                .comment("Please keep in a good mood.")
                .doctor(dor1)
                .patient(p2).build());
        c8 = commentRepository.save(Comment.builder()
                .comment("Please don't stay up late.")
                .doctor(dor1)
                .patient(p2).build());
        c9 = commentRepository.save(Comment.builder()
                .comment("Please take more walks.")
                .doctor(dor1)
                .patient(p2).build());
        c10 = commentRepository.save(Comment.builder()
                .comment("Please eat more fruit.")
                .doctor(dor1)
                .patient(p2).build());
        c11 = commentRepository.save(Comment.builder()
                .comment("Please supplement protein.")
                .doctor(dor1)
                .patient(p2).build());
        c12 = commentRepository.save(Comment.builder()
                .comment("Please drink more water.")
                .doctor(dor1)
                .patient(p2).build());
        //四个医生的留言集合。
        List<Comment> commentListP1 = new ArrayList<>();
        List<Comment> commentListP2 = new ArrayList<>();
        List<Comment> commentListP3 = new ArrayList<>();
        List<Comment> commentListP4 = new ArrayList<>();
        //一条留言对应一个接种者。
        List<Comment> commentList1 = new ArrayList<>();
        List<Comment> commentList2 = new ArrayList<>();
        List<Comment> commentList3 = new ArrayList<>();
        List<Comment> commentList4 = new ArrayList<>();
        List<Comment> commentList5 = new ArrayList<>();
        List<Comment> commentList6 = new ArrayList<>();
        List<Comment> commentList7 = new ArrayList<>();
        List<Comment> commentList8 = new ArrayList<>();
        List<Comment> commentList9 = new ArrayList<>();
        List<Comment> commentList10 = new ArrayList<>();
        List<Comment> commentList11 = new ArrayList<>();
        List<Comment> commentList12 = new ArrayList<>();
        //添加到对应的医生留言集合。
        commentListP1.add(c1);
        commentListP1.add(c2);
        commentListP1.add(c3);
        commentListP2.add(c4);
        commentListP2.add(c5);
        commentListP2.add(c6);
        commentListP3.add(c7);
        commentListP3.add(c8);
        commentListP3.add(c9);
        commentListP4.add(c10);
        commentListP4.add(c11);
        commentListP4.add(c12);
        //留言添加到对应的接种者中。
        commentList1.add(c1);
        commentList2.add(c2);
        commentList3.add(c3);
        commentList4.add(c4);
        commentList5.add(c5);
        commentList6.add(c6);
        commentList7.add(c7);
        commentList8.add(c8);
        commentList9.add(c9);
        commentList10.add(c10);
        commentList11.add(c11);
        commentList12.add(c12);
        //添加留言到接种者对象中
        p1.setComments(commentList1);
        p2.setComments(commentList2);
        p3.setComments(commentList3);
        p4.setComments(commentList4);
        p5.setComments(commentList5);
        p6.setComments(commentList6);
        p7.setComments(commentList7);
        p8.setComments(commentList8);
        p9.setComments(commentList9);
        p10.setComments(commentList10);
        p11.setComments(commentList11);
        p12.setComments(commentList12);
        dor1.setComments(commentListP1);
        dor1.getPatients().add(p1);
        dor1.getPatients().add(p2);
        dor1.getPatients().add(p3);
//        dor2.getPatients().add(p4);
        dor2.getPatients().add(p5);
        dor2.getPatients().add(p6);
        dor3.getPatients().add(p7);
        dor3.getPatients().add(p8);
        dor3.getPatients().add(p9);
        dor4.getPatients().add(p10);
        dor4.getPatients().add(p11);
        dor4.getPatients().add(p12);
        //存储12个接种者的信息。
        patientRepository.save(p1);
        patientRepository.save(p2);
        patientRepository.save(p3);
        patientRepository.save(p4);
        patientRepository.save(p5);
        patientRepository.save(p6);
        patientRepository.save(p7);
        patientRepository.save(p8);
        patientRepository.save(p9);
        patientRepository.save(p10);
        patientRepository.save(p11);
        patientRepository.save(p12);
        //存储四个医生的信息。
        doctorRepository.save(dor1);
        doctorRepository.save(dor2);
        doctorRepository.save(dor3);
        doctorRepository.save(dor4);


        addUser();
        dor1.setUser(user1);
        user1.setDoctor(dor1);

        dor2.setUser(user2);
        user2.setDoctor(dor2);

        p1.setUser(user3);
        user3.setPatient(p1);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        doctorRepository.AddUser(user1.getId(),dor1.getId());

        doctorRepository.AddUser(user2.getId(),dor2.getId());
        patientRepository.AddUser(user3.getId(),p1.getId());
//        patientRepository.save(p1);
    }

    private void addUser(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        Authority authPatient = Authority.builder().name(AuthorityName.ROLE_PATIENT).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        user1 = User.builder()
                .username ( "admin")
                .password ( encoder.encode ( "admin" ) )
                .firstname ( "admin" )
                .lastname ( "admin")
                .email ( "admin@admin.com" ).enabled (true)
                .lastPasswordResetDate(Date.from(LocalDate.of (2021,01,
                        01).atStartOfDay(ZoneId.systemDefault ()).toInstant()))
                .build();


        user2 = User.builder()
                .username ( "doctor")
                .password ( encoder.encode ( "doctor" ) )
                .firstname ( "doctor" )
                .lastname ( "doctor")
                .email ( "enabled@doctor.com" ).enabled (true)
                .lastPasswordResetDate(Date.from(LocalDate.of (2021,01,
                        01).atStartOfDay(ZoneId.systemDefault ()).toInstant()))
                .build();

        user3 = User.builder()
                .username ( "patient")
                .password ( encoder.encode ( "patient" ) )
                .firstname ( "patient" )
                .lastname ( "patient")
                .email ( "enableUser@patient.com" ).enabled (true)
                .lastPasswordResetDate(Date.from(LocalDate.of (2021,01,
                        01).atStartOfDay(ZoneId.systemDefault ()).toInstant()))
                .build();
        authorityRepository.save(authAdmin);
        authorityRepository.save(authDoctor);
        authorityRepository.save(authPatient);
        user1.getAuthorities().add(authAdmin);
        user1.getAuthorities().add(authDoctor);
        user1.getAuthorities().add(authPatient);
        user2.getAuthorities().add(authDoctor);
        user3.getAuthorities().add(authPatient);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
