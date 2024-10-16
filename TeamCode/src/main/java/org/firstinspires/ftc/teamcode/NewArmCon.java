package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;


//Driver-Controlled Period
@TeleOp
public class NewArmCon extends LinearOpMode {

    int count = 0;

    TelemetryController bufferLog = new TelemetryController(10);
    @Override
    public void runOpMode() {
        //Set delay between adding to telemetry data (in ms)
        //Min is 250ms, max is anything you want
        int delay = 250;

        //Debug option, usually not needed (default = 250)
        //telemetry.setMsTransmissionInterval(delay);


        bufferLog.addData(new TelemetryTemp("INIT CONFIG", delay + " Telemetry Refresh"));

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
            //curSpeed ramps up smoothly from 0.0 to maxSpeed
            //stick y: down is positive, up is negative
            double curSpeed = gamepad1.right_stick_y * maxSpeed;


            //Unused option to abruptly max out at maxSpeed (curSpeed ramps up to maxSpeed then stops)
            /*
            if (Math.abs(curSpeed) > maxSpeed){
                if(curSpeed>0){
                    curSpeed = maxSpeed;
                }
                else {
                    curSpeed = -maxSpeed;
                }
            }
             */

            if (Math.abs(gamepad1.right_stick_y)>0.2){
                armMove(myRobot, curSpeed);
            }

            else if(gamepad1.dpad_up){
                slideMove(myRobot, maxSpeed);
            }

            else if(gamepad1.dpad_down){
                slideMove(myRobot, -maxSpeed);
            }

            else{
                myRobot.stopMotors();
            }

            double curTime = runtime.milliseconds();
            if (curTime >= lastTime + delay) {
                bufferLog.addData(new TelemetryTemp("Status " + count, "curSpeed: " + roundDec2(curSpeed) + ", realY: " + roundDec2(gamepad1.right_stick_y)));
                count ++;
                TelemetryController.updateTelemetry(bufferLog.getAll(), telemetry);
                lastTime = curTime;
            }


        }
    }

    public void armMove(GeneralDrive myRobot, double speed){
        myRobot.setMotor0(speed);
        myRobot.setMotor1(speed);
    }

    public void slideMove(GeneralDrive myRobot, double speed){
        myRobot.setMotor2(speed);
    }

    public static double roundDec2(double num){
        return (int)(num*100)/100.0;
    }

}

