package ir.ah.permissionsonandroid.util

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ir.ah.permissionsonandroid.R


typealias FunctionBlock = () -> Unit

object CheckSelfPermission {
    const val PERMISSION_REQUEST_CAMERA = 201
    const val PERMISSION_REQUEST_STORAGE = 202
    const val PERMISSION_REQUEST_CONTACTS = 203
    const val PERMISSION_REQUEST_CALENDAR = 204
    const val PERMISSION_REQUEST_LOCATION = 205
    const val PERMISSION_REQUEST_RECORD_AUDIO = 206
    const val PERMISSION_REQUEST_Phone = 207
    const val PERMISSION_REQUEST_Sms = 208

    fun AppCompatActivity.checkSelfCameraPermission(startCamera: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is already available, start camera preview
            startCamera()
        } else {
            // Permission is missing and must be requested.
            if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.CAMERA)) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.camera_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->
                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.CAMERA),
                            PERMISSION_REQUEST_CAMERA
                        )
                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.CAMERA),
                    PERMISSION_REQUEST_CAMERA
                )

                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }

    }

    fun AppCompatActivity.checkSelfSmsPermission(startSms: FunctionBlock) {
    }

    fun AppCompatActivity.checkSelfPhonePermission(startPhone: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is already available, start camera preview
            startPhone()
        } else {
            // Permission is missing and must be requested.
            if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.READ_PHONE_STATE)) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.phone_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->
                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.READ_PHONE_STATE),
                            PERMISSION_REQUEST_Phone
                        )
                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.READ_PHONE_STATE),
                    PERMISSION_REQUEST_Phone
                )

                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }

    fun AppCompatActivity.checkSelfRecordAudioPermission(startRecordAudio: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is already available, start camera preview
            startRecordAudio()
        } else {
            // Permission is missing and must be requested.
            if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.RECORD_AUDIO)) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.record_audio_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->
                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.RECORD_AUDIO),
                            PERMISSION_REQUEST_RECORD_AUDIO
                        )
                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.RECORD_AUDIO),
                    PERMISSION_REQUEST_RECORD_AUDIO
                )

                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }

    fun AppCompatActivity.checkSelfCoarseLocationPermission(startLocation: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        /*&& checkSelfPermissionCompat(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED*/
        ) {
            // Permission is already available, start camera preview
            startLocation()
        } else {
            // Permission is missing and must be requested.
            if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.ACCESS_FINE_LOCATION)
            /* && shouldShowRequestPermissionRationaleCompat(Manifest.permission.ACCESS_COARSE_LOCATION)*/
            ) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.location_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->
                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                            PERMISSION_REQUEST_LOCATION
                        )
                        /*  requestPermissionsCompat(
                              arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                              PERMISSION_REQUEST_LOCATION
                          )*/
                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSION_REQUEST_LOCATION
                )
                /* requestPermissionsCompat(
                     arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                     PERMISSION_REQUEST_LOCATION
                 )*/

                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }

    fun AppCompatActivity.checkSelfFindLocationPermission(startLocation: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (
            checkSelfPermissionCompat(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is already available, start camera preview
            startLocation()
        } else {
            // Permission is missing and must be requested.
            if (
                shouldShowRequestPermissionRationaleCompat(Manifest.permission.ACCESS_COARSE_LOCATION)
            ) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.location_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->

                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                            PERMISSION_REQUEST_LOCATION
                        )
                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                    PERMISSION_REQUEST_LOCATION
                )

                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }

    fun AppCompatActivity.checkSelfWriteCalendarPermission(startCalendar: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is already available, start camera preview
            startCalendar()
        } else {
            // Permission is missing and must be requested.
            if (
                shouldShowRequestPermissionRationaleCompat(Manifest.permission.WRITE_CALENDAR)
            ) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.calendar_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->

                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.WRITE_CALENDAR),
                            PERMISSION_REQUEST_CALENDAR
                        )
                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.WRITE_CALENDAR),
                    PERMISSION_REQUEST_CALENDAR
                )

                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }

    fun AppCompatActivity.checkSelfReadCalendarPermission(startCalendar: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED

        ) {
            // Permission is already available, start camera preview
            startCalendar()
        } else {
            // Permission is missing and must be requested.
            if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.READ_CALENDAR)

            ) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.calendar_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->
                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.READ_CALENDAR),
                            PERMISSION_REQUEST_CALENDAR
                        )

                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.READ_CALENDAR),
                    PERMISSION_REQUEST_CALENDAR
                )


                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }

    fun AppCompatActivity.checkSelfContactsPermission(startContacts: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is already available, start camera preview
            startContacts()
        } else {
            // Permission is missing and must be requested.
            if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.READ_CONTACTS)) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.contacts_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->
                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.READ_CONTACTS),
                            PERMISSION_REQUEST_CONTACTS
                        )
                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    PERMISSION_REQUEST_CONTACTS
                )

                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }

    fun AppCompatActivity.checkSelfWriteStoragePermission(startStorage: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission is already available, start camera preview
            startStorage()
        } else {
            // Permission is missing and must be requested.
            if (shouldShowRequestPermissionRationaleCompat(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            ) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.storage_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->

                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                            PERMISSION_REQUEST_STORAGE
                        )
                    }
                    .show()

            } else {
                requestPermissionsCompat(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    PERMISSION_REQUEST_STORAGE
                )

                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }

    fun AppCompatActivity.checkSelfReadStoragePermission(startStorage: FunctionBlock) {
        // Check if the Camera permission has been granted
        if (checkSelfPermissionCompat(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

        ) {
            // Permission is already available, start camera preview
            startStorage()
        } else {
            // Permission is missing and must be requested.
            if (shouldShowRequestPermissionRationaleCompat(Manifest.permission.READ_EXTERNAL_STORAGE)


            ) {
                // Provide an additional rationale to the user if the permission was not granted
                // and the user would benefit from additional context for the use of the permission.
                // Display a SnackBar with a button to request the missing permission.

                MaterialAlertDialogBuilder(this)
                    .setMessage(R.string.storage_access_required)
                    .setNegativeButton(R.string.decline) { dialog, which ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.accept) { dialog, which ->
                        requestPermissionsCompat(
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            PERMISSION_REQUEST_STORAGE
                        )

                    }
                    .show()

            } else {

                requestPermissionsCompat(
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    PERMISSION_REQUEST_STORAGE
                )


                // Request the permission. The result will be received in onRequestPermissionResult().
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun AppCompatActivity.permissionDenied(permissionName: String) {
        if (!shouldShowRequestPermissionRationale(permissionName)) {
            MaterialAlertDialogBuilder(this)
                .setMessage(R.string.camera_access_required)
                .setNegativeButton(R.string.decline) { dialog, which ->
                    dialog.dismiss()
                }
                .setPositiveButton("Ok") { dialog, which ->
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                    dialog.dismiss()
                }
                .show()
        }
    }


}