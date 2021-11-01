package com.example.mobil_elso_beadando

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager
    private val sel : OrientationSensorEventListener = OrientationSensorEventListener();
    private lateinit var tv: TextView
    private lateinit var mOrientation: Sensor
    private lateinit var iv: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        tv = findViewById(R.id.degreeTextView)
        iv = findViewById(R.id.imageView)
        mOrientation = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)
        sensorManager.registerListener(sel, mOrientation, SensorManager.SENSOR_DELAY_NORMAL)
        sel.setTv(tv)
        sel.setIv(iv)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(sel, mOrientation, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(sel)
    }
}