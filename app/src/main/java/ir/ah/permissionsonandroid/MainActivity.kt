package ir.ah.permissionsonandroid

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar
import ir.ah.permissionsonandroid.util.CheckSelfPermission.PERMISSION_REQUEST_CALENDAR
import ir.ah.permissionsonandroid.util.CheckSelfPermission.PERMISSION_REQUEST_CAMERA
import ir.ah.permissionsonandroid.util.CheckSelfPermission.PERMISSION_REQUEST_CONTACTS
import ir.ah.permissionsonandroid.util.CheckSelfPermission.PERMISSION_REQUEST_LOCATION
import ir.ah.permissionsonandroid.util.CheckSelfPermission.PERMISSION_REQUEST_Phone
import ir.ah.permissionsonandroid.util.CheckSelfPermission.PERMISSION_REQUEST_RECORD_AUDIO
import ir.ah.permissionsonandroid.util.CheckSelfPermission.PERMISSION_REQUEST_STORAGE
import ir.ah.permissionsonandroid.util.CheckSelfPermission.checkSelfCalendarPermission
import ir.ah.permissionsonandroid.util.CheckSelfPermission.checkSelfCameraPermission
import ir.ah.permissionsonandroid.util.CheckSelfPermission.checkSelfContactsPermission
import ir.ah.permissionsonandroid.util.CheckSelfPermission.checkSelfLocationPermission
import ir.ah.permissionsonandroid.util.CheckSelfPermission.checkSelfPhonePermission
import ir.ah.permissionsonandroid.util.CheckSelfPermission.checkSelfRecordAudioPermission
import ir.ah.permissionsonandroid.util.CheckSelfPermission.checkSelfSmsPermission
import ir.ah.permissionsonandroid.util.CheckSelfPermission.checkSelfStoragePermission
import ir.ah.permissionsonandroid.util.CheckSelfPermission.permissionDenied

class MainActivity : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = findViewById(R.id.main_layout)

        findViewById<Button>(R.id.Camera).setOnClickListener {

            checkSelfCameraPermission {
                startCamera()
            }
        }
        findViewById<Button>(R.id.STORAGE).setOnClickListener {

            checkSelfStoragePermission {
                startStorage()
            }
        }
        findViewById<Button>(R.id.CONTACTS).setOnClickListener {

            checkSelfContactsPermission {
                startContacts()
            }
        }
        findViewById<Button>(R.id.CALENDAR).setOnClickListener {

            checkSelfCalendarPermission {
                startCalendar()
            }
        }
        findViewById<Button>(R.id.LOCATION).setOnClickListener {

            checkSelfLocationPermission {
                startLocation()
            }
        }
        findViewById<Button>(R.id.RECORD_AUDIO).setOnClickListener {

            checkSelfRecordAudioPermission {
                startRecordAudio()
            }
        }
        findViewById<Button>(R.id.Phone).setOnClickListener {

            checkSelfPhonePermission {
                startPhone()
            }
        }
        findViewById<Button>(R.id.Sms).setOnClickListener {

            checkSelfSmsPermission {
                startSms()

            }
        }
    }


    private fun startSms() {
        Toast.makeText(this, "start Sms ", Toast.LENGTH_LONG).show()
    }

    private fun startPhone() {
        Toast.makeText(this, "start Phone ", Toast.LENGTH_LONG).show()
    }

    private fun startRecordAudio() {
        Toast.makeText(this, "start Record Audio", Toast.LENGTH_LONG).show()
    }

    private fun startLocation() {
        Toast.makeText(this, "start Location", Toast.LENGTH_LONG).show()
    }

    private fun startCalendar() {
        Toast.makeText(this, "start Calendar", Toast.LENGTH_LONG).show()
    }

    private fun startContacts() {
        Toast.makeText(this, "start Contacts", Toast.LENGTH_LONG).show()
    }

    private fun startStorage() {
        Toast.makeText(this, "start Storage", Toast.LENGTH_LONG).show()
    }


    private fun startCamera() {
        Toast.makeText(this, "start Camera", Toast.LENGTH_LONG).show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        Log.e("test", "" + requestCode)
        when (requestCode) {
            PERMISSION_REQUEST_CAMERA -> {
                // Request for camera permission.
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission has been granted. Start camera preview Activity.
                    Snackbar.make(layout, R.string.camera_permission_granted, Snackbar.LENGTH_SHORT)
                        .show()
                    startCamera()
                } else {
                    // Permission request was denied.
                    permissionDenied(Manifest.permission.CAMERA)

                    Snackbar.make(layout, R.string.camera_permission_denied, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
            PERMISSION_REQUEST_STORAGE -> {
                // Request for camera permission.
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission has been granted. Start camera preview Activity.
                    Snackbar.make(layout, R.string.camera_permission_granted, Snackbar.LENGTH_SHORT)
                        .show()
                    startStorage()
                } else {
                    // Permission request was denied.
                    permissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)

                    Snackbar.make(layout, R.string.camera_permission_denied, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
            PERMISSION_REQUEST_CONTACTS -> {
                // Request for camera permission.
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission has been granted. Start camera preview Activity.
                    Snackbar.make(layout, R.string.camera_permission_granted, Snackbar.LENGTH_SHORT)
                        .show()
                    startContacts()
                } else {
                    // Permission request was denied.
                    permissionDenied(Manifest.permission.READ_CONTACTS)

                    Snackbar.make(layout, R.string.camera_permission_denied, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
            PERMISSION_REQUEST_CALENDAR -> {
                // Request for camera permission.
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission has been granted. Start camera preview Activity.
                    Snackbar.make(layout, R.string.camera_permission_granted, Snackbar.LENGTH_SHORT)
                        .show()
                    startCalendar()
                } else {
                    // Permission request was denied.
                    permissionDenied(Manifest.permission.WRITE_CALENDAR)

                    Snackbar.make(layout, R.string.camera_permission_denied, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
            PERMISSION_REQUEST_LOCATION -> {
                // Request for camera permission.
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission has been granted. Start camera preview Activity.
                    Snackbar.make(layout, R.string.camera_permission_granted, Snackbar.LENGTH_SHORT)
                        .show()
                    startLocation()
                } else {
                    // Permission request was denied.
                    permissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)

                    Snackbar.make(layout, R.string.camera_permission_denied, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
            PERMISSION_REQUEST_RECORD_AUDIO -> {
                // Request for camera permission.
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission has been granted. Start camera preview Activity.
                    Snackbar.make(layout, R.string.camera_permission_granted, Snackbar.LENGTH_SHORT)
                        .show()
                    startRecordAudio()
                } else {
                    // Permission request was denied.
                    permissionDenied(Manifest.permission.RECORD_AUDIO)

                    Snackbar.make(layout, R.string.camera_permission_denied, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
            PERMISSION_REQUEST_Phone -> {
                // Request for camera permission.
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission has been granted. Start camera preview Activity.
                    Snackbar.make(layout, R.string.camera_permission_granted, Snackbar.LENGTH_SHORT)
                        .show()
                    startPhone()
                } else {
                    // Permission request was denied.
                    permissionDenied(Manifest.permission.READ_PHONE_STATE)

                    Snackbar.make(layout, R.string.camera_permission_denied, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }
}