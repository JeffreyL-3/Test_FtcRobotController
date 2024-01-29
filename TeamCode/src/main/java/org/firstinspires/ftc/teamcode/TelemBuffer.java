package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class TelemBuffer {

    int maxSize;
    ArrayList<TempTelem> bufferLog = new ArrayList<TempTelem>();

    public TelemBuffer(int myMaxSize){
        maxSize = myMaxSize;
    }

    public void addData(TempTelem newData){
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
