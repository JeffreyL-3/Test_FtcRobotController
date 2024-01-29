package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;


public class TelemetryController {

    int maxSize;
    ArrayList<TelemetryTemp> bufferLog = new ArrayList<TelemetryTemp>();

    public TelemetryController(int myMaxSize){
        maxSize = myMaxSize;
    }

    public void addData(TelemetryTemp newData){
        bufferLog.add(newData);
        if(bufferLog.size()>maxSize){
            bufferLog.remove(0);
        }
    }

    public ArrayList<TelemetryTemp> getAll(){
        return bufferLog;
    }

    public void clearAll(){
        bufferLog.clear();
    }

    //Updates telemetry with bufferlog
    public static void updateTelemetry(ArrayList<TelemetryTemp> bufferLog, Telemetry telemetry){

        if (bufferLog == null || telemetry == null) {
            throw new IllegalArgumentException("bufferLog and telemetry must not be null");
        }

        for(TelemetryTemp log:bufferLog){
            telemetry.addData(log.caption, log.value);
        }

        telemetry.update();

    }

}
