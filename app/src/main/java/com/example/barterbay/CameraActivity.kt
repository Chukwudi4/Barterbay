package com.example.barterbay

import android.content.Context
import android.graphics.ImageFormat
import android.graphics.SurfaceTexture
import android.hardware.camera2.*
import android.media.ImageReader
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Size
import android.util.SparseIntArray
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.util.*

class CameraActivity: AppCompatActivity(), View.OnClickListener{

    private val TAG = "AndroidCamperaApi"
    private var cameraDevice: CameraDevice? = null
    private lateinit var textureView:TextureView
    private lateinit var button: Button
    private lateinit var cameraCaptureSession: CameraCaptureSession
    private val ORIENTATIONS: SparseIntArray = SparseIntArray()
    private lateinit var cameraId:String
    private lateinit var captureRequest: CaptureRequest
    private lateinit var imageDimension:Size
    private lateinit var imageReader: ImageReader

    //save to file
    private lateinit var file:File
    private val REQUEST_CAMERA_PERMISSION = 200
    private var flashSupported:Boolean = false



    init {
        ORIENTATIONS.append(Surface.ROTATION_0, 90)
        ORIENTATIONS.append(Surface.ROTATION_90, 0)
        ORIENTATIONS.append(Surface.ROTATION_180, 270)
        ORIENTATIONS.append(Surface.ROTATION_270, 180)
    }

    private val stateCallback = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        object: CameraDevice.StateCallback(){
            override fun onOpened(camera: CameraDevice) {
                cameraDevice = camera
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDisconnected(camera: CameraDevice) {
                cameraDevice?.close()
            }

            override fun onError(camera: CameraDevice, error: Int) {
                cameraDevice?.close()
                cameraDevice = null
            }
        }
    } else {
        TODO("VERSION.SDK_INT < LOLLIPOP")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_camera)

        textureView = findViewById(R.id.textureView)
        textureView.surfaceTextureListener = TextureListener()
        button = findViewById(R.id.capture)
        button.setOnClickListener(this)


    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onClick(v: View?) {
        this.takePicture()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun takePicture():Unit {
        if (cameraDevice == null) return

        var manager: CameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        try {
            var characteristics = manager.getCameraCharacteristics(cameraDevice?.id)
            var map  = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
            var jpegSizes = Arrays.asList(*map.getOutputSizes(ImageFormat.JPEG))

        }catch (ex: CameraAccessException){
            ex.printStackTrace()
        }

    }

    class TextureListener: TextureView.SurfaceTextureListener{
        override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
            openCamera()
        }

        private fun openCamera() {

        }

    }
}