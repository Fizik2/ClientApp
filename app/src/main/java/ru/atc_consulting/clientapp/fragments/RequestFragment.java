package ru.atc_consulting.clientapp.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import ru.atc_consulting.clientapp.R;

import static android.app.Activity.RESULT_OK;

public class RequestFragment extends Fragment {

    private static final String MAIL = "ndmelentev@yandex.ru";
    private static final int RESULT_LOAD_IMAGE = 1;
    private View mView;
    private TextView mFioText;
    private TextView mCompanyText;
    private TextView mPhoneText;
    private TextView mMailText;
    private TextView mDescText;
    private Button mPhotoButton;
    private Button mSubmitButton;
    private String mPhotoPath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_request, container, false);
        mFioText = (TextView) mView.findViewById(R.id.request_fio);
        mCompanyText = (TextView) mView.findViewById(R.id.request_company);
        mPhoneText = (TextView) mView.findViewById(R.id.request_phone);
        mMailText = (TextView) mView.findViewById(R.id.request_mail);
        mDescText = (TextView) mView.findViewById(R.id.request_desc);

        mSubmitButton = (Button) mView.findViewById(R.id.request_submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // send e-mail with data
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{MAIL});
                i.putExtra(Intent.EXTRA_SUBJECT, "Заявка на расчет");
                i.putExtra(Intent.EXTRA_TEXT, String.format("ФИО: %s;\n" +
                        "Компания: %s;\n" +
                        "Телефон: %s;\n" +
                        "E-mail: %s;\n" +
                        "Описание: %s.", mFioText.getText(), mCompanyText.getText(), mPhoneText.getText(), mMailText.getText(), mDescText.getText()));

                if (!Objects.equals(mPhotoPath, "")) {
                    i.putExtra(Intent.EXTRA_STREAM, Uri.parse(mPhotoPath));
                }

                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }


            }
        });

        mPhotoButton = (Button) mView.findViewById(R.id.request_photo);
        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // start open photo intent
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        return mView;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            if (selectedImage != null) {
                mPhotoPath = selectedImage.toString();

                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();

                    // show image to user
                    ImageView imageView = (ImageView) mView.findViewById(R.id.request_photo_frame);
                    imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }
            }

        }
    }
}