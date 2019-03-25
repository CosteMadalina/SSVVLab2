package ro.ubb;

import static org.junit.Assert.assertTrue;

import domain.Student;
import domain.Tema;
import jdk.nashorn.internal.ir.Assignment;
import org.junit.Test;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.StudentValidator;
import validation.TemaValidator;
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

    @Test
    public void testAddAssignment(){
        Validator<Tema> TemaValidator = new TemaValidator();

        TemaXMLRepository fileRepository1 = new TemaXMLRepository(TemaValidator, "teme.xml");
        fileRepository1.save(new Tema("13", "SSVV",932,931));
        assert (fileRepository1.findOne("13")==null);
    }

    @Test
    public void testAddAssignmentFail(){
        Validator<Tema> TemaValidator = new TemaValidator();

        TemaXMLRepository fileRepository1 = new TemaXMLRepository(TemaValidator, "teme.xml");
        fileRepository1.save(new Tema("13", "SSVV",6,5));
        assert (fileRepository1.findOne("13")!=null);
    }
}
