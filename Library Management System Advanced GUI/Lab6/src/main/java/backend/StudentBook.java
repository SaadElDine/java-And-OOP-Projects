package backend;
import java.time.LocalDate; 

/**
 *
 * @author Saad
 */

public class StudentBook implements Record {
    
    private String studentId;
    private String bookId;
    private LocalDate borrowDate;

    public StudentBook(String studentId, String bookId, LocalDate borrowDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }
    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    @Override
    public String lineRepresentation() {
        return (this.studentId + "," + this.bookId + ","+ this.borrowDate  + "\n");
    }
    
    @Override
    public String getSearchKey() {
        return (this.studentId + "," + this.bookId);
    }

    
}
