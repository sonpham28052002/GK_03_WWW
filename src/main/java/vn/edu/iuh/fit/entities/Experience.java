package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Experience {
    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "from_date", columnDefinition = "date")
    private LocalDate fromDate;

    @Column(name = "to_date", columnDefinition = "date")
    private LocalDate toDate;

    @Column(name = "company", length = 120)
    private String companyName;

    @Column(name = "work_desc", length = 400)
    private String workDescription;

    @Column(name = "role")
    private Role roles;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    public Experience() {
    }

    public Experience(long id, LocalDate fromDate, LocalDate toDate, String companyName, String workDescription, Role roles, Candidate candidate) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.companyName = companyName;
        this.workDescription = workDescription;
        this.roles = roles;
        this.candidate = candidate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", companyName='" + companyName + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", roles=" + roles +
                '}';
    }
}
