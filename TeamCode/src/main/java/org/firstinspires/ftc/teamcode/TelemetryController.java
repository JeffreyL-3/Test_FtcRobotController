package org.firstinspires.ftc.teamcode;

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

    public ArrayList getAll(){
        return bufferLog;
    }

    public void clearAll(){
        bufferLog.clear();
    }


}
