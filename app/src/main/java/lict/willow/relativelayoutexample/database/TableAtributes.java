package lict.willow.relativelayoutexample.database;

public class TableAtributes {

    public static final String TABLE_NAME = "students";
    public static final String STUDENT_ID = "id";
    public static final String STUDENT_NAME = "name";
    public static final String STUDENT_EMAIL = "email";
    public static final String STUDENT_PHONENO = "phoneNo";
    public static final String STUDENT_CGPA = "cgpa";

    public String createQuery(){
        return "CREATE TABLE "+TABLE_NAME+"("+
                STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                STUDENT_NAME + " TEXT,"+
                STUDENT_EMAIL + " TEXT,"+
                STUDENT_PHONENO + " TEXT,"+
                STUDENT_CGPA + " DOUBLE)";
    }
}
