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
public class NewGamepadDrive extends LinearOpMode {

    @Override
    public void runOpMode() {
        int count = 0;
        GeneralDrive myRobot = new GeneralDrive(hardwareMap);
        Telemetry telemetry;
        telemetry = this.telemetry;

        waitForStart();

        while ( opModeIsActive() ) {
            double drive = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            if(gamepad1.left_bumper){
                myRobot.turnLeft90();
                telemetry.addData("Status", "Turning left " + count);
                telemetry.update();

            }
            else if(gamepad1.right_bumper){
                myRobot.turnRight90();
                telemetry.addData("Status", "Turning left " + count);
                telemetry.update();

            }
            else if (gamepad1.right_trigger>0){
                myRobot.moveForward(gamepad1.right_trigger);
            }
            else if (gamepad1.left_trigger>0){
                myRobot.moveBackward(gamepad1.left_trigger);
            }
            else {
                myRobot.setLeftDrivePower(drive - turn);
                myRobot.setRightDrivePower(drive + turn);
            }


        }
    }
}

