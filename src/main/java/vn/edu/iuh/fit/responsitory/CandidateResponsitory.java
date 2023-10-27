package vn.edu.iuh.fit.responsitory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.connectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.Role;

import java.util.List;

public class CandidateResponsitory {
    private EntityManager entityManager;

    public CandidateResponsitory() {
        entityManager = ConnectionDB.getConnectionDB().getManagerFactory().createEntityManager();
    }

    public List<Candidate> getAll(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            List<Candidate> ds =entityManager.createQuery("select  cd from Candidate cd", Candidate.class).getResultList();
            transaction.commit();
            return ds;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
        return null;
    }public List<Candidate> getAllByRole(Role role){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            List<Candidate> ds =entityManager.createQuery("select  cd from Candidate cd where cd.id in (select ex from Experience ex where ex.roles = "+role+")", Candidate.class).getResultList();
            transaction.commit();
            return ds;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
        return null;
    }public List<Candidate> getAllByGmail(){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            List<Candidate> ds =entityManager.createQuery("select  cd from Candidate cd where cd.email like '%gmail%'", Candidate.class).getResultList();
            transaction.commit();
            return ds;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    public Candidate findOne(long id){
        return entityManager.find(Candidate.class,id);
    }
}
