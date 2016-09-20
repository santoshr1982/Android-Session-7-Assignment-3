package assignment.db.rsantosh.com.insertandretriveblobdata;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InsertandRetriveBlobData extends Activity {
    private DBhelper mDbHelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertand_retrive_blob_data);
        mDbHelper = new DBhelper(this);
        Employee employee_One = new Employee(BitmapFactory.decodeResource(
                getResources(), R.drawable.photo),"Venkat", 25);
        mDbHelper.open();
        mDbHelper.insertEmpDetails(employee_One);
        mDbHelper.close();
        employee_One = null;
        mDbHelper.open();
        employee_One = mDbHelper.retriveEmpDetails();
        mDbHelper.close();

        TextView empname = (TextView) findViewById(R.id.name);
        empname.setText(employee_One.getName());
        ImageView empphoto = (ImageView) findViewById(R.id.photo);
        empphoto.setImageBitmap(employee_One.getBitmap());
        TextView empage = (TextView) findViewById(R.id.age);
        empage.setText("" + employee_One.getAge());

    }
}
