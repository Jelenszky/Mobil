package com.example.mobil_elso_beadando

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.ImageView
import android.widget.TextView

class OrientationSensorEventListener : SensorEventListener {
    private var tv: TextView
    private var iv: ImageView

    constructor(tv: TextView, iv: ImageView) {
        this.tv = tv
        this.iv = iv
    }


    override fun onSensorChanged(sensorEvent: SensorEvent) {
        val degree = sensorEvent.values[0]
        tv.setText(degree.toString())
        iv.setRotation(-degree)
    }

    override fun onAccuracyChanged(sensor: Sensor?, i: Int) {
        //TODO
    }
}