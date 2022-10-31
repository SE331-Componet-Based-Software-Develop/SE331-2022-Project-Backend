package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Comment;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.repository.CommentRepository;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    CommentRepository commentRepository;
    @Override
    public Integer getCommentSize() {
        return Math.toIntExact(commentRepository.count());
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment,Long did,Long pid) {
        Doctor doctor = new Doctor();
        Patient patient =  new Patient();
        Comment c = new Comment();
        try{
            doctor = doctorRepository.findById(did).orElse(null);
            patient = patientRepository.findById(pid).orElse(null);
            c = commentRepository.save(Comment.builder()
                    .comment(comment.getComment())
                    .doctor(doctor)
                    .patient(patient).build());
            doctor.getComments().add(c);
            patient.getComments().add(c);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("comment save is error");
        }
        doctorRepository.save(doctor);
        patientRepository.save(patient);
        return commentRepository.save(c);
    }

    @Override
    public List<Comment> FindByPid(Long pid) {
        return commentRepository.findByPatientId(pid);
    }
}
