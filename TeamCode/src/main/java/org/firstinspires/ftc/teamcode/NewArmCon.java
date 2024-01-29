package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


//Driver-Controlled Period
@TeleOp
public class NewArmCon extends LinearOpMode {

    int count = 0;

    boolean updating = false;

    TelemBuffer bufferLog = new TelemBuffer(10);
    @Override
    public void runOpMode() {
        //Set delay between adding to telemetry data (in ms)
        //Min is 250ms, max is anything you want
        int delay = 250;
        telemetry.setMsTransmissionInterval(delay);
        bufferLog.addData(new TempTelem("INIT CONFIG", delay + " Telem Refresh"));

        GeneralDrive myRobot = new GeneralDrive(hardwareMap);
        Telemetry telemetry;
        telemetry = this.telemetry;

        waitForStart();
        ElapsedTime runtime = new ElapsedTime();
        double lastTime = runtime.milliseconds();


        while ( opModeIsActive() ) {

            //maxSpeed (0.0 - 1.0)
            double maxSpeed = 1.0;

            //curSpeed is adjusted to max out at maxSpeed
            //stick y: down is positive, up is negative
            double curSpeed = gamepad1.right_stick_y * maxSpeed;

            if (curSpeed > maxSpeed){
                curSpeed = maxSpeed;
            }

            if (Math.abs(gamepad1.right_stick_y)>0.2){
                //armMove(myRobot, curSpeed);
            }

            else{
                myRobot.stopMotors();
            }

            double curTime = runtime.milliseconds();
            if (curTime >= lastTime + delay) {
                bufferLog.addData(new TempTelem("Status " + count, "curSpeed: " + roundDec2(curSpeed) + ", realY: " + roundDec2(gamepad1.right_stick_y)));
                count ++;
                updateTelem(bufferLog.getAll(), telemetry);
                lastTime = curTime;
            }


        }
    }

    public void armMove(GeneralDrive myRobot, double speed){
        myRobot.setLeftDrivePower(speed);
        myRobot.setRightDrivePower(speed);
    }

    public static double roundDec2(double num){
        return (int)(num*100)/100.0;
    }

    //Updates telemetry with bufferlog every delayMs
    public static void updateTelem(ArrayList<TempTelem> bufferLog, Telemetry telemetry){
        for(TempTelem log:bufferLog){
            telemetry.addData(log.caption, log.value);
        }

        telemetry.update();

    }

}

