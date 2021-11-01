package com.example.mobil_elso_beadando

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.ImageView
import android.widget.TextView

class OrientationSensorEventListener : SensorEventListener {
    private var tv: TextView? = null
    private var iv: ImageView?= null

    fun setTv(tv: TextView?) {
        this.tv = tv
    }

    fun setIv(iv: ImageView){
        this.iv=iv
    }

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        val degree = sensorEvent.values[0]
        tv!!.setText(degree.toString())
    }

    override fun onAccuracyChanged(sensor: Sensor?, i: Int) {
        //TODO
    }
}