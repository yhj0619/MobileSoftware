package mobile.example.dbtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateContactActivity extends Activity {

    private ContactDB contactDB;
    EditText etName;
    EditText etPhone;
    EditText etCategory;
    private Contact updateContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        contactDB = ContactDB.getInstance(this);

        etName = (EditText)findViewById(R.id.editText1);
        etPhone = (EditText)findViewById(R.id.editText2);
        etCategory = (EditText)findViewById(R.id.editText3);

        Intent intent = getIntent();
        updateContact = (Contact)intent.getSerializableExtra("contact");

        etName.setText(updateContact.getName());
        etPhone.setText(updateContact.getPhone());
        etCategory.setText(updateContact.getCategory());
    }


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnUpdateContactSave:
                updateContact.setName(etName.getText().toString());
                updateContact.setPhone(etPhone.getText().toString());
                updateContact.setCategory(etCategory.getText().toString());

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        contactDB.contactDao().update(updateContact);
                    }
                }).start();

                finish();
                break;
            case R.id.btnUpdateContactClose:
                finish();
                break;
        }

    }

}