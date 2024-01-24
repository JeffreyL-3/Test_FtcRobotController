package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//Driver-Controlled Period
@TeleOp
public class TelTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        int count = 0;
        GeneralDrive myRobot = new GeneralDrive(hardwareMap);
        Telemetry telemetry;
        telemetry = this.telemetry;

        waitForStart();

        while (opModeIsActive()) {

            double maxSpeed = 0.5;
            double curSpeed = gamepad1.right_stick_y / 2;
            if (curSpeed > maxSpeed) {
                curSpeed = maxSpeed;
            }

            if (Math.abs(gamepad1.right_stick_y) > 0.2) {

                telemetry.addData("Status", "curSpeed: " + round2dec(curSpeed) + ", realY: " + round2dec(gamepad1.right_stick_y));
                telemetry.update();
            } else {
                telemetry.addData("Status", "curSpeed: " + round2dec(curSpeed) + ", realY: " + round2dec(gamepad1.right_stick_y));
                telemetry.update();
            }
        }
    }
    public static double round2dec(double num){
        return (int)(num*100)/100.0;
    }
}