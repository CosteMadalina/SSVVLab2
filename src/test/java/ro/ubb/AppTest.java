package ro.ubb;

import static org.junit.Assert.assertTrue;

import domain.Student;
import org.junit.Test;
import repository.StudentXMLRepository;
import validation.StudentValidator;
import validation.Validator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void testAddStudent(){
        Validator<Student> studentValidator = new StudentValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        fileRepository1.save(new Student("555","ButnarCoste",932));
        assert (fileRepository1.findOne("555")!=null);

    }

    @Test
    public void testAddStudentFail(){
        //Repository r = new Student
        Validator<Student> studentValidator = new StudentValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        fileRepository1.save(new Student("666","",932));
        assert (fileRepository1.findOne("666")==null);
    }

    @Test
    public void testAddStudent1(){
        Validator<Student> studentValidator = new StudentValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        fileRepository1.save(new Student("383",null,932));
        assert (fileRepository1.findOne("383")==null);

    }

    @Test
    public void testAddStudent2(){
        Validator<Student> studentValidator = new StudentValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        fileRepository1.save(new Student("SSVV", "SSVV",932));
        assert (fileRepository1.findOne("SSVV")!=null);

    }
}
