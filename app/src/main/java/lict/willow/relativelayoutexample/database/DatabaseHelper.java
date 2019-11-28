package lict.willow.relativelayoutexample.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import lict.willow.relativelayoutexample.model.Student;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "wglict.db";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TableAtributes tableAtributes = new TableAtributes();
        try {
            db.execSQL(tableAtributes.createQuery());
        } catch (SQLException e) {
            Log.e("Create", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertStudent(Student std) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableAtributes.STUDENT_NAME, std.getName());
        contentValues.put(TableAtributes.STUDENT_EMAIL, std.getEmail());
        contentValues.put(TableAtributes.STUDENT_PHONENO, std.getPhoneNo());
        contentValues.put(TableAtributes.STUDENT_CGPA, std.getCgpa());

        try {
            db.insert(TableAtributes.TABLE_NAME, null, contentValues);
            Log.i("Insert", "Hoise");
        } catch (SQLException e) {
            Log.e("Insert Eroor", e.toString());
        }
    }

    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM "+TableAtributes.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            int userID = cursor.getInt(cursor.getColumnIndex(TableAtributes.STUDENT_ID));
            String name = cursor.getString(cursor.getColumnIndex(TableAtributes.STUDENT_NAME));
            String email = cursor.getString(cursor.getColumnIndex(TableAtributes.STUDENT_EMAIL));
            String phoneNo = cursor.getString(cursor.getColumnIndex(TableAtributes.STUDENT_PHONENO));
            Float cgpa = cursor.getFloat(cursor.getColumnIndex(TableAtributes.STUDENT_CGPA));

            Student std = new Student(userID, name, email, phoneNo, cgpa);
            arrayList.add(std);

            cursor.moveToNext();
        }
        return arrayList;
    }
}
