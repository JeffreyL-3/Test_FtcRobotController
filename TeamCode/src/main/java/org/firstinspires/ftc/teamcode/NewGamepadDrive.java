package org.firstinspires.ftc.teamcode.control;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

//Driver-Controlled Period
@TeleOp
public class NewGamepadDrive extends LinearOpMode {


    @Override
    public void runOpMode() {
        boolean turning90 = false;
        GeneralDrive myRobot = new GeneralDrive(hardwareMap);
        waitForStart();

        while ( opModeIsActive() ) {
            double drive = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            if(gamepad1.left_bumper && turning90 == false){
                turning90 = true;
                myRobot.turnLeft90();
                turning90 = false;
            }
            else if(gamepad1.right_bumper && turning90 == false){
                turning90 = true;
                myRobot.turnRight90();
                turning90 = false;
            }
            else{
                myRobot.setLeftDrivePower(drive - turn);
                myRobot.setRightDrivePower(drive + turn);
            }

        }
    }
}

